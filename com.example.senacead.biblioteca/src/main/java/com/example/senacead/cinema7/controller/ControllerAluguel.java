package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Aluguel;
import com.example.senacead.cinema7.model.Dados;
import com.example.senacead.cinema7.model.Livro;
import com.example.senacead.cinema7.service.AluguelService;
import com.example.senacead.cinema7.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerAluguel {

    @Autowired
    LivroService livroService;

    @Autowired
    AluguelService aluguelService;

    @GetMapping("/cadastro-aluguel")
    public String mostraCadastroAluguel(Model model) {
        model.addAttribute("aluguel", new Aluguel());
        model.addAttribute("livros", livroService.listarTodos());
        return "cadastroAluguel"; 
    }

    @PostMapping("/guardar-aluguel")
    public String processarFormularioAluguel(@Valid @ModelAttribute Aluguel aluguel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("livros", livroService.listarTodos());
            return "cadastroAluguel";
        }

        if (aluguel.getLivro() != null && aluguel.getLivro().getId() != null) {
            Livro livro = livroService.buscarPorId(aluguel.getLivro().getId());
            aluguel.setLivro(livro);
        }

        if (aluguel.getId() != null) {
            aluguelService.atualizar(aluguel.getId(), aluguel);
        } else {
            aluguelService.criarAluguel(aluguel);
        }
        return "redirect:/listagem-aluguel";
    }

    @GetMapping("/listagem-aluguel")
    public String mostraListagemAluguel(Model model) {
        model.addAttribute("alugueis", aluguelService.listarTodos());
        return "listagemAluguel";
    }

    @GetMapping("/alterar-aluguel")
    public String alterarAluguel(Model model, @RequestParam Integer id) {
        model.addAttribute("aluguel", aluguelService.buscarPorId(id));
        model.addAttribute("livros", livroService.listarTodos());
        return "cadastroAluguel";
    }

    @GetMapping("/excluir-aluguel")
    public String excluirAluguel(@RequestParam Integer id) {
        aluguelService.excluir(id);
        return "redirect:/listagem-aluguel";
    }
}
