package com.tabeldata.bootcamp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produsen {
    private Integer id;
    private String nama;
    private String kode;
    private String alamat;
}


