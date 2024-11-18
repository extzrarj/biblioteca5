package com.example.senacead.cinema7.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name ="analise")
@Entity //tabela do banco de dados, que irá criar uma tabela no myswl com todos as infos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analise {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_filme") // referência à coluna id_filme na tabela de analises
    private Filme filme;
    private String analiseA;
    private int nota;
    
}

