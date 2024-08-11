package com.johnlaff.algatransito.domain.service;

import com.johnlaff.algatransito.domain.model.Autuacao;
import com.johnlaff.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class RegistroAutuacaoService {

    private RegistroVeiculoService registroVeiculoService;

    public List<Autuacao> buscar(Integer veiculoId){
        return registroVeiculoService.buscar(veiculoId).getAutuacoes();
    }

    @Transactional
    public Autuacao registrar(Integer veiculoId, Autuacao novaAutuacao) {
        Veiculo veiculo = registroVeiculoService.buscar(veiculoId);
        return veiculo.adicionarAutuacao(novaAutuacao);
    }

}
