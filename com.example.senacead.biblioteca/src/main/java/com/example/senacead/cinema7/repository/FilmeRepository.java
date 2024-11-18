package com.example.senacead.cinema7.repository;

import com.example.senacead.cinema7.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface,
 **/

@Repository
public interface FilmeRepository extends JpaRepository <Filme , Integer> {
    
}
