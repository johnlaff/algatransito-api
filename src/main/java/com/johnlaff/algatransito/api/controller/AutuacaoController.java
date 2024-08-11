package com.johnlaff.algatransito.api.controller;

import com.johnlaff.algatransito.api.assembler.AutuacaoAssembler;
import com.johnlaff.algatransito.api.model.AutuacaoModel;
import com.johnlaff.algatransito.api.model.input.AutuacaoInput;
import com.johnlaff.algatransito.domain.model.Autuacao;
import com.johnlaff.algatransito.domain.service.RegistroAutuacaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private final RegistroAutuacaoService registroAutuacaoService;
    private final AutuacaoAssembler autuacaoAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoModel registrar(@PathVariable Integer veiculoId,
                                   @Valid @RequestBody AutuacaoInput autuacaoInput) {
        Autuacao novaAutuacao = autuacaoAssembler.toEntity(autuacaoInput);
        Autuacao autuacaoRegistrada = registroAutuacaoService
                .registrar(veiculoId, novaAutuacao);
        return autuacaoAssembler.toModel(autuacaoRegistrada);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AutuacaoModel> listar (@PathVariable Integer veiculoId) {
        return registroAutuacaoService.buscar(veiculoId).stream()
                .map(autuacaoAssembler::toModel)
                .toList();
    }
}
