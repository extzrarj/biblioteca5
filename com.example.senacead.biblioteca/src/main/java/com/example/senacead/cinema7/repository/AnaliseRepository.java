
package com.example.senacead.cinema7.repository;

import com.example.senacead.cinema7.model.Analise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnaliseRepository extends JpaRepository<Analise, Integer> {
    List<Analise> findByFilmeId(Integer filmeId); // Busca por id do filme
}