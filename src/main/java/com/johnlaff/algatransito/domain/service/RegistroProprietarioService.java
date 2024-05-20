package com.johnlaff.algatransito.domain.service;

import com.johnlaff.algatransito.domain.model.Proprietario;
import com.johnlaff.algatransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Integer proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }

}
