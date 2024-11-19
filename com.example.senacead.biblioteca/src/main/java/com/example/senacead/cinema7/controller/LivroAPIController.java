package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Livro;
import com.example.senacead.cinema7.service.LivroService;
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
@RequestMapping("/livro")
public class LivroAPIController {

    @Autowired
    LivroService livroService;

    @GetMapping("buscar/{id}")
    public ResponseEntity<Livro> pesquisar(@PathVariable Integer id) {
        Livro LivroEncontrado = livroService.buscarPorId(id);
        return new ResponseEntity<>(LivroEncontrado, HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Livro> criar(@RequestBody Livro livro) {
        Livro novoLivro = livroService.criarLivro(livro);
        return new ResponseEntity<>(novoLivro, HttpStatus.CREATED);
    }

    @GetMapping("listar-todos")
    public ResponseEntity<List> listar() {
        List<Livro> livroLista = livroService.listarTodos();
        return new ResponseEntity<>(livroLista, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
     public ResponseEntity<Livro> atualizar (@RequestBody Livro livro , @PathVariable Integer id) {
        Livro livroAtualizado = livroService.atualizar(id, livro);
         return new ResponseEntity<>(livroAtualizado, HttpStatus.OK);
    }

    @DeleteMapping ("/excluir/{id}") 
     public ResponseEntity <?> excluir(@PathVariable Integer id) {
         livroService.excluir(id);
         return new ResponseEntity<>(HttpStatus.OK);
     }
     
}
