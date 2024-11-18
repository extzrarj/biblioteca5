
package com.example.senacead.cinema7.service;

import com.example.senacead.cinema7.model.Analise;
import com.example.senacead.cinema7.model.Filme;
import com.example.senacead.cinema7.repository.AnaliseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnaliseService {

    @Autowired
    AnaliseRepository analiseRepository;

    public List<Analise> listarTodos() {
        return analiseRepository.findAll();
    }

    public Analise buscarPorId(Integer id) {
        return analiseRepository.findById(id).orElseThrow();
    }

    public Analise criarAnalise(Analise analise) {
        analise.setId(null);
        analiseRepository.save(analise);
        return analise;
    }

    public List<Analise> buscarPorIdFilme(Integer filmeId) {
        return analiseRepository.findByFilmeId(filmeId);
    }

    public void excluir(Integer id) {
        Analise analiseEncontrada = buscarPorId(id);
        analiseRepository.deleteById(analiseEncontrada.getId());
    }
}
