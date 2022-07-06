package com.tabeldata.bootcamp.controller;

import com.tabeldata.bootcamp.dto.ProdusenDto;
import com.tabeldata.bootcamp.entity.Produsen;
import com.tabeldata.bootcamp.mappers.ProdusenMapper;
import com.tabeldata.bootcamp.service.ProdusenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produsen")
@Slf4j
public class ProdusenController {

    @Autowired
    private ProdusenService service;

    @GetMapping("")
    public List<Produsen> list() {
        return this.service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produsen> findId(@PathVariable Integer id) throws EmptyResultDataAccessException {
        try {
            Produsen produsen = this.service.findId(id);
            return ResponseEntity.ok(produsen);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Valid ProdusenDto.New produsen, BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("status", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            output.put("id", service.save(produsen));
            output.put("status", "Berhasil menambah Produk");
            return ResponseEntity.ok(output);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Valid ProdusenDto.Update produsen, BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("status", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            try {
                service.findId(produsen.getId());
                service.update(produsen);
                output.put("status", "Berhasil mengupdate Produk");
                return ResponseEntity.ok(output);
            } catch (EmptyResultDataAccessException e) {
                output.put("status", "Tidak ada Produk dengan id " + produsen.getId());
                return ResponseEntity.badRequest().body(output);
            }
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
        Map<String, Object> output = new HashMap<>();
        try {
            service.findId(id);
            service.delete(id);
            output.put("status", "Berhasil menghapus Produk");
            return ResponseEntity.ok(output);
        } catch (EmptyResultDataAccessException e) {
            output.put("status", "Tidak ada Produk dengan id " + id);
            return ResponseEntity.badRequest().body(output);
        }
    }
}
