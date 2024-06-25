package com.johnlaff.algatransito.domain.model;

import com.johnlaff.algatransito.domain.validation.ValidationsGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "proprietarios")
public class Proprietario {

    @NotNull(groups = ValidationsGroups.ProprietarioId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proprietarioid", nullable = false)
    private Integer id;

    @NotBlank
    @Size(max = 60)
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @NotBlank
    @Size(max = 255)
    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "telefone", nullable = false, length = 20)
    private String telefone;

}
