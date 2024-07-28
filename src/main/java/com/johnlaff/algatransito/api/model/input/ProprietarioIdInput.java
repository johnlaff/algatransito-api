package com.johnlaff.algatransito.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProprietarioIdInput {

    @NotNull
    private Integer id;

}
