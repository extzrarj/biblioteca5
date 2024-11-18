package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Filme;
import com.example.senacead.cinema7.service.FilmeService;
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

/**
 *
 *
 */
@RestController
@RequestMapping("/filme")
public class FilmeAPIController {

    @Autowired
    FilmeService filmeService;

    @GetMapping("buscar/{id}")
    public ResponseEntity<Filme> pesquisar(@PathVariable Integer id) {
        Filme filmeEncontrado = filmeService.buscarPorId(id);
        return new ResponseEntity<>(filmeEncontrado, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Filme> criar(@RequestBody Filme filme) {
        Filme novoFilme = filmeService.criarFilme(filme);
        return new ResponseEntity<>(novoFilme, HttpStatus.CREATED);
    }

    @GetMapping("listar-todos")
    public ResponseEntity<List> listar() {
        List<Filme> filmeLista = filmeService.listarTodos();
        return new ResponseEntity<>(filmeLista, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
     public ResponseEntity<Filme> atualizar (@RequestBody Filme filme , @PathVariable Integer id) {
        Filme filmeAtualizado = filmeService.atualizar(id, filme);
         return new ResponseEntity<>(filmeAtualizado, HttpStatus.OK);
    }

    @DeleteMapping ("/excluir/{id}") 
     public ResponseEntity <?> excluir(@PathVariable Integer id) {
         filmeService.excluir(id);
         return new ResponseEntity<>(HttpStatus.OK);
     }
     
}
