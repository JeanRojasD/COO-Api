package com.br.cooapi.services;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ServicesForm {

    private Double valorPago;
    private LocalDateTime data;
}
