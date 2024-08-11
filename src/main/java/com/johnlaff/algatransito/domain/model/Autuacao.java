package com.johnlaff.algatransito.domain.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "autuacao")
public class Autuacao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Valid
    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @NotBlank
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor_multa", nullable = false)
    private BigDecimal valorMulta;

    @Column(name = "data_ocorrencia", nullable = false)
    private OffsetDateTime dataOcorrencia;
}
