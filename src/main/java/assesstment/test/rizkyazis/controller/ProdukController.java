package assesstment.test.rizkyazis.controller;

import assesstment.test.rizkyazis.dto.ProdukDto;
import assesstment.test.rizkyazis.entity.Produk;
import assesstment.test.rizkyazis.service.ProdukService;
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
@RequestMapping("/api/produk")
@Slf4j
public class ProdukController {

    @Autowired
    private ProdukService service;

    @GetMapping("")
    public List<Produk> list() {
        return this.service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produk> findId(@PathVariable Integer id) {
        try {
            Produk produk = this.service.findId(id);
            return ResponseEntity.ok(produk);
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> save(@RequestBody @Valid ProdukDto.New produk, BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("status", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            output.put("id", service.save(produk));
            output.put("status", "Berhasil menambah Produk");
            return ResponseEntity.ok(output);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody @Valid ProdukDto.Update produk, BindingResult result) {
        Map<String, Object> output = new HashMap<>();
        if (result.hasErrors()) {
            output.put("status", result.getAllErrors());
            return ResponseEntity.badRequest().body(output);
        } else {
            try {
                service.findId(produk.getId());
                service.update(produk);
                output.put("status", "Berhasil mengupdate Produk");
                return ResponseEntity.ok(output);
            } catch (EmptyResultDataAccessException e) {
                output.put("status", "Tidak ada Produk dengan id " + produk.getId());
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
