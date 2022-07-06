package com.tabeldata.bootcamp.service;

import com.tabeldata.bootcamp.dao.ProdukDao;
import com.tabeldata.bootcamp.dto.ProdukDto;
import com.tabeldata.bootcamp.entity.Produk;
import com.tabeldata.bootcamp.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProdukService {

    @Autowired
    private ProdukDao dao;

    public Produk findId(Integer id) throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    public List<Produk> list(){
        return dao.list();
    }

    @Transactional
    public Integer save(ProdukDto.New value) {
        return dao.insert(value);
    }

    @Transactional
    public void update(ProdukDto.Update value){
        dao.update(value);
    }

    @Transactional
    public void delete(Integer id){
        dao.delete(id);
    }
}
