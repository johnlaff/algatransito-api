package com.johnlaff.algatransito.domain.service;

import com.johnlaff.algatransito.domain.exception.EntidadeNaoEncontradaException;
import com.johnlaff.algatransito.domain.exception.NegocioException;
import com.johnlaff.algatransito.domain.model.Proprietario;
import com.johnlaff.algatransito.domain.model.StatusVeiculo;
import com.johnlaff.algatransito.domain.model.Veiculo;
import com.johnlaff.algatransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RegistroVeiculoService {

    private VeiculoRepository veiculoRepository;
    private final RegistroProprietarioService registroProprietarioService;

    public Veiculo buscar(Integer veiculoId) {
        return veiculoRepository.findById(veiculoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veiculo não encontrado"));
    }

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {

        if (novoVeiculo.getId() != null){
            throw new NegocioException("Veículo já cadastrado");
        }

        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                        .filter(veiculo -> !veiculo.equals(novoVeiculo))
                        .isPresent();

        if (placaEmUso) {
            throw new NegocioException("Já existe um veículo cadastrado com esta placa");
        }

        Proprietario proprietario = registroProprietarioService.buscar(novoVeiculo.getProprietario().getId());

        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setDataCadastro(OffsetDateTime.now());


        return veiculoRepository.save(novoVeiculo);
    }
}
