package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Aluguel;
import com.example.senacead.cinema7.service.AluguelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluguel")
public class AluguelAPIController {

    @Autowired
    AluguelService aluguelService;

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Aluguel>> listar() {
        return new ResponseEntity<>(aluguelService.listarTodos(), HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Aluguel> criar(@RequestBody Aluguel aluguel) {
        return new ResponseEntity<>(aluguelService.criarAluguel(aluguel), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Aluguel> atualizar(@RequestBody Aluguel aluguel, @PathVariable Integer id) {
        return new ResponseEntity<>(aluguelService.atualizar(id, aluguel), HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Integer id) {
        aluguelService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

