
package com.example.senacead.cinema7.service;

import com.example.senacead.cinema7.model.Funcionario;
import com.example.senacead.cinema7.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionarioRepository.findByNome(funcionario.getNome()).isPresent()) {
            throw new IllegalArgumentException("Funcionário com este nome já está cadastrado.");
        }
        funcionarioRepository.save(funcionario);
    }

    public boolean autenticar(String nome, String senha) {
        return funcionarioRepository.findByNome(nome)
                .map(f -> f.getSenha().equals(senha))
                .orElse(false);
    }
}
