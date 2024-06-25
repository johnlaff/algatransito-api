package com.johnlaff.algatransito.domain.service;

import com.johnlaff.algatransito.domain.exception.NegocioException;
import com.johnlaff.algatransito.domain.model.Proprietario;
import com.johnlaff.algatransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public Proprietario buscar(Integer proprietarioId) {
        return proprietarioRepository.findById(proprietarioId)
                .orElseThrow(() -> new NegocioException("Proprietário não encontrado"));
    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioException("Já existe um proprietário cadastrado com este e-mail");
        }

        return proprietarioRepository.save(proprietario);
    }

    @Transactional
    public void excluir(Integer proprietarioId) {
        proprietarioRepository.deleteById(proprietarioId);
    }

}
