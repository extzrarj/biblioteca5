package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Aluguel;
import com.example.senacead.cinema7.model.Livro;
import com.example.senacead.cinema7.service.AluguelService;
import com.example.senacead.cinema7.service.LivroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerLivro {
    
    @Autowired
    LivroService livroService;
    
    @Autowired
    AluguelService aluguelService;

    @GetMapping("/tela-inicio")
    public String mostraIndex() {
        return "index";
    }

    @GetMapping("/cadastro-livro")
    public String mostraCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        return "cadastroLivro";
    }

    @PostMapping("/guardar-livro")
    public String processarFormulario(@ModelAttribute Livro livro) {
        if (livro.getId() != null) {
            livroService.atualizar(livro.getId(), livro);
        } else {
            livroService.criarLivro(livro);
        }
        return "redirect:/listagem-livro";
    }

    @GetMapping("/listagem-livro")
    public String mostraLivro(Model model) {
        model.addAttribute("livros", livroService.listarTodos());
        return "listagemLivro";
    }

    @GetMapping("/exibir")
    public String mostraDetalhes(Model model, @RequestParam Integer id) {
        Livro livroEncontrado = livroService.buscarPorId(id);
        model.addAttribute("livro", livroEncontrado);

        List<Aluguel> aluguelEncontrada = aluguelService.buscarPorIdLivro(id);
        model.addAttribute("aluguelE", aluguelEncontrada);
        model.addAttribute("aluguel", new Aluguel());
        return "detalhes";
    }

    @GetMapping("/excluir-livro")
    public String excluirLivro(@RequestParam Integer id) {
        livroService.excluir(id);
        return "redirect:/listagem-livro";
    }

    @GetMapping("/alterar-livro")
    public String alterarLivro(Model model, @RequestParam Integer id) {
        model.addAttribute("livro", livroService.buscarPorId(id));
        return "cadastroLivro";
    }
}
