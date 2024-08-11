package com.johnlaff.algatransito.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AutuacaoInput {

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal valorMulta;
}
