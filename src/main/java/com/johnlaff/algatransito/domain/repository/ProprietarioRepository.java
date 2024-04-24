package com.johnlaff.algatransito.domain.repository;

import com.johnlaff.algatransito.domain.model.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProprietarioRepository extends JpaRepository<Proprietario, Integer> {
    List<Proprietario> findByNomeContaining(String nome);
}
