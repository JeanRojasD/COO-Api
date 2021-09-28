package com.br.cooapi.abasteci;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbasteciForm {

    private long vlPago;
    private LocalDateTime dataTime = LocalDateTime.now();

}
