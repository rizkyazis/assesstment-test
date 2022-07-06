package com.tabeldata.bootcamp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produk {
    private Integer id;
    private String nama;
    private String jenis;
    private String berat;
    private Produsen produsen;
}
