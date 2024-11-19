package com.example.senacead.cinema7.service;

import com.example.senacead.cinema7.exception.AluguelInvalidoException;
import com.example.senacead.cinema7.model.Aluguel;
import com.example.senacead.cinema7.repository.AluguelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {

    @Autowired
    AluguelRepository aluguelRepository;

    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }

    public Aluguel buscarPorId(Integer id) {
        return aluguelRepository.findById(id).orElseThrow();
    }

    public Aluguel criarAluguel(Aluguel aluguel) {
        aluguel.setId(null);
        aluguelRepository.save(aluguel);
        return aluguel;
    }

    public List<Aluguel> buscarPorIdLivro(Integer livroId) {
        return aluguelRepository.findByLivroId(livroId);
    }

    public void excluir(Integer id) {
        Aluguel aluguelEncontrada = buscarPorId(id);
        aluguelRepository.deleteById(aluguelEncontrada.getId());
    }

    public Aluguel atualizar(Integer id, Aluguel aluguel) {
        buscarPorId(id);
        validarAluguel(aluguel);
        aluguel.setId(id);
        return aluguelRepository.save(aluguel);
    }

    private void validarAluguel(Aluguel aluguel) {
        if (aluguel.getNome().isBlank()) {
            throw new AluguelInvalidoException("O nome do livro não pode estar vazio.");
        }
        if (String.valueOf(aluguel.getValor()).isBlank()) {
            throw new AluguelInvalidoException("O valor do aluguel não pode estar vazio.");
        }
        if (aluguel.getDataAluguel() == null) {
            throw new AluguelInvalidoException("Ano de lançamento deve ser informado e maior que 1888.");
        }
    }
}
