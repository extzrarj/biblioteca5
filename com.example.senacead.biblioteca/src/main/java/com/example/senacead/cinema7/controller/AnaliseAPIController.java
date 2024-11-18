package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Analise;
import com.example.senacead.cinema7.service.AnaliseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analise")
public class AnaliseAPIController {

    @Autowired
    AnaliseService analiseService;

    @PostMapping("/adicionar")
    public ResponseEntity<Analise> criar(@RequestBody Analise analise) {
        Analise novaAnalise = analiseService.criarAnalise(analise);
        return new ResponseEntity<>(novaAnalise, HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable Integer id) {
        analiseService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{filmeId}")
    public ResponseEntity<List<Analise>> listarAnalise(@PathVariable Integer filmeId) {
        List<Analise> lista = analiseService.buscarPorIdFilme(filmeId);
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
