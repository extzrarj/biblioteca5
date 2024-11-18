
package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Analise;
import com.example.senacead.cinema7.model.Dados;
import com.example.senacead.cinema7.model.Filme;
import com.example.senacead.cinema7.service.AnaliseService;
import com.example.senacead.cinema7.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ControllerAnalises {
    
    @Autowired
    FilmeService filmeService;
    
    @Autowired
    AnaliseService analiseService;
    
    @PostMapping("/guardar-analise")
    public String processarFormularioAnalise(Model model, @ModelAttribute Filme filme, @ModelAttribute Analise analise) {
        analise.setFilme(filme);
        analiseService.criarAnalise(analise);
        return "redirect:/listagem-filme";
    }

    @GetMapping("/excluir-analise")
    public String excluirAnalise(Model model, @RequestParam String id) {
        Integer idAnalise = Integer.parseInt(id);
        analiseService.excluir(idAnalise);
        return "redirect:/listagem-filme";
    }

    
}
