
package com.example.senacead.cinema7.repository;

import com.example.senacead.cinema7.model.Aluguel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Integer> {
    List<Aluguel> findByLivroId(Integer livroId); // Busca por id do livro
}