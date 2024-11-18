package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Analise;
import com.example.senacead.cinema7.model.Filme;
import com.example.senacead.cinema7.service.AnaliseService;
import com.example.senacead.cinema7.service.FilmeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerCinema {
    
    @Autowired
    FilmeService filmeService;
    
    @Autowired
    AnaliseService analiseService;

    @GetMapping("/tela-inicio")
    public String mostraIndex() {
        return "index";
    }

    @GetMapping("/cadastro-filme")
    public String mostraCadastro(Model model) {
        model.addAttribute("filme", new Filme());
        return "cadastroFilme";
    }

    @PostMapping("/guardar-filme")
    public String processarFormulario(@ModelAttribute Filme filme) {
        if (filme.getId() != null) {
            filmeService.atualizar(filme.getId(), filme);
        } else {
            filmeService.criarFilme(filme);
        }
        return "redirect:/listagem-filme";
    }

    @GetMapping("/listagem-filme")
    public String mostraFilme(Model model) {
        model.addAttribute("filmes", filmeService.listarTodos());
        return "listagemFilme";
    }

    @GetMapping("/exibir")
    public String mostraDetalhes(Model model, @RequestParam Integer id) {
        Filme filmeEncontrado = filmeService.buscarPorId(id);
        model.addAttribute("filme", filmeEncontrado);

        List<Analise> analiseEncontrada = analiseService.buscarPorIdFilme(id);
        model.addAttribute("analiseE", analiseEncontrada);
        model.addAttribute("analise", new Analise());
        return "detalhes";
    }

    @GetMapping("/excluir-filme")
    public String excluirFilme(@RequestParam Integer id) {
        filmeService.excluir(id);
        return "redirect:/listagem-filme";
    }

    @GetMapping("/alterar-filme")
    public String alterarFilme(Model model, @RequestParam Integer id) {
        model.addAttribute("filme", filmeService.buscarPorId(id));
        return "cadastroFilme";
    }
}
