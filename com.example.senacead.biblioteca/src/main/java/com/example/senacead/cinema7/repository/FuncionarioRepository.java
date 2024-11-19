package com.example.senacead.cinema7.repository;

import com.example.senacead.cinema7.model.Funcionario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
    Optional<Funcionario> findByNome(String nome);
}
