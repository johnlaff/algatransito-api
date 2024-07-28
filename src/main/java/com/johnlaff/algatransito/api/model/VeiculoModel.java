package com.johnlaff.algatransito.api.model;

import com.johnlaff.algatransito.domain.model.StatusVeiculo;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class VeiculoModel {
    private Integer id;
    private ProprietarioResumoModel proprietario;
    private String marca;
    private String modelo;
    private String placa;
    private StatusVeiculo status;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;
}
