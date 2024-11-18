package com.example.senacead.cinema7.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name ="livro")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "O nome do livro não pode estar vazio.")
    @Size(min = 2, max = 50, message = "O nome do livro deve ter entre 2 e 50 caracteres.")
    private String nome;

    @NotBlank(message = "O gênero do livro não pode estar vazio.")
    private String genero;

    @NotNull(message = "O ano de lançamento é obrigatório.")
    private Integer anoLancamento;

    @Size(max = 500, message = "A sinopse não pode exceder 500 caracteres.")
    private String sinopse;
    
    @NotBlank(message = "O autor do livro não pode estar vazio.")
    private String autor;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.REMOVE)
    private List<Aluguel> alugueis;
}
