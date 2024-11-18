
package com.example.senacead.cinema7.exception;

public class FilmeNaoEncontradoException extends RuntimeException {
    public FilmeNaoEncontradoException(Integer id) {
        super("Filme com ID " + id + " não foi encontrado.");
    }
}

