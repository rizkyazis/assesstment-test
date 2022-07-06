package com.tabeldata.bootcamp.dto;

import com.tabeldata.bootcamp.entity.Produsen;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdukDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class New {
        @NotNull
        @NotEmpty
        private String nama;
        @NotNull
        @NotEmpty
        private String jenis;
        @NotNull
        @NotEmpty
        private String berat;
        @NotNull
        private Produsen produsen;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update {
        @NotNull
        private Integer id;
        @NotNull
        @NotEmpty
        private String nama;
        @NotNull
        @NotEmpty
        private String jenis;
        @NotNull
        @NotEmpty
        private String berat;
        @NotNull
        private Produsen produsen;
    }
}
