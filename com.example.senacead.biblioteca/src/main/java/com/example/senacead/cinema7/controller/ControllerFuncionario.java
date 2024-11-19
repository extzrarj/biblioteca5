package com.example.senacead.cinema7.controller;

import com.example.senacead.cinema7.model.Funcionario;
import com.example.senacead.cinema7.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerFuncionario {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/cadastro-funcionario")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "cadastroFuncionario";
    }

    @PostMapping("/guardar-funcionario")
    public String processarFormularioCadastro(@Valid @ModelAttribute Funcionario funcionario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastroFuncionario";
        }

        try {
            funcionarioService.cadastrarFuncionario(funcionario);
        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
            return "cadastroFuncionario";
        }

        return "redirect:/login-funcionario";
    }

    @GetMapping("/login-funcionario")
    public String mostrarFormularioLogin(Model model) {
        model.addAttribute("funcionario", new Funcionario());
        return "loginFuncionario";
    }

    @PostMapping("/autenticar-funcionario")
    public String autenticarFuncionario(@ModelAttribute Funcionario funcionario, Model model) {
        boolean autenticado = funcionarioService.autenticar(funcionario.getNome(), funcionario.getSenha());

        if (!autenticado) {
            model.addAttribute("erro", "Nome ou senha inválidos.");
            return "loginFuncionario";
        }

        return "redirect:/tela-inicio";
    }
}
