package assesstment.test.rizkyazis.controller;

import assesstment.test.rizkyazis.entity.Produsen;
import assesstment.test.rizkyazis.service.ProdusenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/produsen")
@Slf4j
public class ProdusenController {

    @Autowired
    private ProdusenService service;

    @GetMapping("")
    public Iterable<Produsen> list() {
        return this.service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produsen> findId(@PathVariable Integer id) {
        Optional<Produsen> produsen = this.service.findId(id);
        if (produsen.isPresent()) {
            return ResponseEntity.ok(produsen.get());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> save(@RequestBody Produsen produsen) {
        Map<String, Object> output = new HashMap<>();
        output.put("id", service.save(produsen));
        if (produsen.getId() != null) {
            output.put("status", "Berhasil mengupdate Produsen");
        } else {
            output.put("status", "Berhasil menambah Produsen");
        }

        return ResponseEntity.ok(output);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id) {
        Map<String, Object> output = new HashMap<>();
        Optional<Produsen> produsen = this.service.findId(id);
        if (produsen.isPresent()) {
            output.put("status", "Berhasil menghapus Produsen");
            service.delete(id);
            return ResponseEntity.ok(output);
        } else {
            output.put("status", "Tidak ada Produsen dengan id " + id);
            return ResponseEntity.badRequest().body(output);
        }
    }
}
