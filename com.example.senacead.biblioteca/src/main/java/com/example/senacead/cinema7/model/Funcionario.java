package com.example.senacead.cinema7.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "funcionario")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String senha;
}

