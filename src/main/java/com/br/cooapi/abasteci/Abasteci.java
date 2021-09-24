package com.br.cooapi.abasteci;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
public class Abasteci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAbastecimento;
    private long vlPago;
    private LocalDateTime dataTime;


}

