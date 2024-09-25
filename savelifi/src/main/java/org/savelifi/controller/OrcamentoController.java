package org.savelifi.controller;

import org.savelifi.model.entity.Orcamento;
import org.savelifi.service.OrcamentosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orcamento")
public class OrcamentoController {

    private final OrcamentosService orcamentosService;

    public OrcamentoController(OrcamentosService orcamentosService) {
        this.orcamentosService = orcamentosService;
    }

    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(orcamentosService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(orcamentosService.findById(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity save(@RequestBody Orcamento orcamento) {
        try {
            return ResponseEntity.ok(orcamentosService.save(orcamento));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity edit(@RequestBody Orcamento orcamento) {
        try {
            return ResponseEntity.ok(orcamentosService.save(orcamento));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(orcamentosService.delete(id));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/total")
    public ResponseEntity getTotal() {
        return ResponseEntity.ok(orcamentosService.count());
    }
}
