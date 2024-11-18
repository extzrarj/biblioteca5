
package com.example.senacead.cinema7.service;

import com.example.senacead.cinema7.exception.FilmeInvalidoException;
import com.example.senacead.cinema7.exception.FilmeNaoEncontradoException;
import com.example.senacead.cinema7.model.Filme;
import com.example.senacead.cinema7.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *Parte lógica
 */
@Service
public class FilmeService {

    @Autowired
     FilmeRepository filmeRepository;

    public Filme buscarPorId(Integer id) {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new FilmeNaoEncontradoException(id));
    }
      public List<Filme> listarTodos(){
          
        return filmeRepository.findAll();
    }

    public Filme criarFilme(Filme filme) {
        validarFilme(filme);
        filme.setId(null);
        filmeRepository.save(filme);
        return filme;
    }

    public Filme atualizar(Integer id, Filme filme) {
        buscarPorId(id); 
        validarFilme(filme);
        filme.setId(id);
        return filmeRepository.save(filme);
    }

    public void excluir(Integer id) {
        Filme filmeEncontrado = buscarPorId(id);
        filmeRepository.delete(filmeEncontrado);
    }

    private void validarFilme(Filme filme) {
        if (filme.getNome().isBlank()) {
            throw new FilmeInvalidoException("O nome do filme não pode estar vazio.");
        }
        if (filme.getGenero().isBlank()) {
            throw new FilmeInvalidoException("O gênero do filme não pode estar vazio.");
        }
        if (filme.getAnoLancamento() == null || filme.getAnoLancamento() < 1888) {
            throw new FilmeInvalidoException("Ano de lançamento deve ser informado e maior que 1888.");
        }
    }
}