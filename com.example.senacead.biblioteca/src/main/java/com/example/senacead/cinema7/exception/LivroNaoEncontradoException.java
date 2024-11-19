
package com.example.senacead.cinema7.exception;

public class LivroNaoEncontradoException extends RuntimeException {
    public LivroNaoEncontradoException(Integer id) {
        super("Livro com ID " + id + " não foi encontrado.");
    }
}

