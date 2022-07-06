package com.tabeldata.bootcamp.mappers;

import com.tabeldata.bootcamp.dto.ProdukDto;
import com.tabeldata.bootcamp.entity.Produk;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public class ProdukMapper {


    @Mapper
     public interface New extends ObjectMapper<Produk, ProdukDto.New> {
         New converter = Mappers.getMapper(New.class);
     }

    @Mapper
    public interface Update extends ObjectMapper<Produk, ProdukDto.Update> {
        Update converter = Mappers.getMapper(Update.class);
    }



//    public Produk ProdukNewMapper(ProdukDto.New value) {
//        Produk produk = new Produk();
//        produk.setNama(value.getNama());
//        produk.setJenis(value.getJenis());
//        produk.setBerat(value.getBerat());
//        produk.setProdusen(value.getProdusen());
//        return produk;
//    }
//
//    public Produk ProdukUpdateMapper(ProdukDto.Update value) {
//        Produk produk = new Produk();
//        produk.setId(value.getId());
//        produk.setNama(value.getNama());
//        produk.setJenis(value.getJenis());
//        produk.setBerat(value.getBerat());
//        produk.setProdusen(value.getProdusen());
//        return produk;
//    }
}
