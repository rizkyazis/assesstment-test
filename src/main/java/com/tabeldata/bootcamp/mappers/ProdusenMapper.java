package com.tabeldata.bootcamp.mappers;

import com.tabeldata.bootcamp.dto.ProdukDto;
import com.tabeldata.bootcamp.dto.ProdusenDto;
import com.tabeldata.bootcamp.entity.Produk;
import com.tabeldata.bootcamp.entity.Produsen;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Component
public class ProdusenMapper {

    @Mapper
    public interface New extends ObjectMapper<Produsen, ProdusenDto.New> {
        New converter = Mappers.getMapper(New.class);
    }

    @Mapper
    public interface Update extends ObjectMapper<Produsen, ProdusenDto.Update> {
        Update converter = Mappers.getMapper(Update.class);
    }

//    public Produsen ProdusenNewMapper(ProdusenDto.New value) {
//        Produsen produsen = new Produsen();
//        produsen.setNama(produsen.getNama());
//        produsen.setKode(produsen.getKode());
//        produsen.setAlamat(produsen.getAlamat());
//        return produsen;
//    }
//
//    public Produsen ProdusenUpdateMapper(ProdusenDto.Update value) {
//        Produsen produsen = new Produsen();
//        produsen.setId(produsen.getId());
//        produsen.setNama(produsen.getNama());
//        produsen.setKode(produsen.getKode());
//        produsen.setAlamat(produsen.getAlamat());
//        return produsen;
//    }
}
