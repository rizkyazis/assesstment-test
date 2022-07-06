package com.tabeldata.bootcamp.service;

import com.tabeldata.bootcamp.dao.ProdusenDao;
import com.tabeldata.bootcamp.dto.ProdusenDto;
import com.tabeldata.bootcamp.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProdusenService {

    @Autowired
    private ProdusenDao dao;

    public Produsen findId(Integer id) throws EmptyResultDataAccessException {
        return dao.findId(id);
    }

    public List<Produsen> list() {
        return dao.list();
    }

    @Transactional
    public Integer save(ProdusenDto.New value) {
        return dao.insert(value);
    }

    @Transactional
    public void update(ProdusenDto.Update value){
        dao.update(value);
    }

    @Transactional
    public void delete(Integer id){
        dao.delete(id);
    }
}
