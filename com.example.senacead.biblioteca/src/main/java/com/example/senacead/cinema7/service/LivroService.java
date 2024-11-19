
package com.example.senacead.cinema7.service;

import com.example.senacead.cinema7.exception.AluguelInvalidoException;
import com.example.senacead.cinema7.exception.LivroNaoEncontradoException;
import com.example.senacead.cinema7.model.Livro;
import com.example.senacead.cinema7.repository.LivroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *Parte lógica
 */
@Service
public class LivroService {

    @Autowired
    LivroRepository livroRepository;

    public Livro buscarPorId(Integer id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new LivroNaoEncontradoException(id));
    }
      public List<Livro> listarTodos(){
          
        return livroRepository.findAll();
    }

    public Livro criarLivro(Livro livro) {
        validarLivro(livro);
        livro.setId(null);
        livroRepository.save(livro);
        return livro;
    }

    public Livro atualizar(Integer id, Livro livro) {
        buscarPorId(id); 
        validarLivro(livro);
        livro.setId(id);
        return livroRepository.save(livro);
    }

    public void excluir(Integer id) {
        Livro livroEncontrado = buscarPorId(id);
        livroRepository.delete(livroEncontrado);
    }

    private void validarLivro(Livro livro) {
        if (livro.getNome().isBlank()) {
            throw new AluguelInvalidoException("O nome do livro não pode estar vazio.");
        }
        if (livro.getGenero().isBlank()) {
            throw new AluguelInvalidoException("O gênero do livro não pode estar vazio.");
        }
        if (livro.getAnoLancamento() == null || livro.getAnoLancamento() < 1888) {
            throw new AluguelInvalidoException("Ano de lançamento deve ser informado e maior que 1888.");
        }
    }
}