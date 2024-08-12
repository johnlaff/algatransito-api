package com.johnlaff.algatransito.domain.service;

import com.johnlaff.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ApreensaoVeiculoService {

    private final RegistroVeiculoService registroVeiculoService;

    @Transactional
    public void apreender(Integer veiculoId) {
        Veiculo veiculo = registroVeiculoService.buscar(veiculoId);
        veiculo.apreender();
    }

    @Transactional
    public void removerApreensao(Integer veiculoId) {
        Veiculo veiculo = registroVeiculoService.buscar(veiculoId);
        veiculo.removerApreendido();
    }

}
