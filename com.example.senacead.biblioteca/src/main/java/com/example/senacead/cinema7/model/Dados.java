package com.example.senacead.cinema7.model;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private static List<Livro> listaLivros = new ArrayList();
    private static List<Aluguel> listaAlugueis = new ArrayList();

    public static void adicionarLivro(Livro livro) {
        livro.setId(listaLivros.size() + 1);
        listaLivros.add(livro);
    }

    public static List<Livro> listarLivros() {
        /**
         * refatoração de código, cpodigos da controller estão sendo adaptados
         * para a lista de Dados*
         */
        return listaLivros;
    }

    public static void excluirLivro(Integer id) {
        for (Livro f : listaLivros) {
            if (f.getId() == id) {
                listaLivros.remove(f);
                break;
            }
        }
    }

    public static Livro obtemLivro(Integer id) {
        Livro livroEncontrado = new Livro();
        for (Livro l : listaLivros) {
            if (l.getId() == id) {
                livroEncontrado = l;
                break;
            }
        }

        return livroEncontrado;
    }

    public static void atualizarFilme(Livro livro) {
        for (Livro l : listaLivros) {
            if (l.getId() == livro.getId()) {
                l.setNome(livro.getNome());
                l.setGenero(livro.getGenero());
                l.setSinopse(livro.getSinopse());
                l.setAnoLancamento(livro.getAnoLancamento());
                l.setAutor(livro.getAutor());
                break;
            }
        }

    }
    
      public static void adicionarAluguel(Aluguel aluguel, Livro livro) {
        aluguel.setId(listaAlugueis.size() + 1);
        aluguel.setLivro(livro);
        listaAlugueis.add(aluguel);
    }
      
       public static void excluirAluguel(Integer id) {
        for (Aluguel a : listaAlugueis) {
            if (a.getId() == id) {
                listaAlugueis.remove(a);
                break;
            }
        }
    }
       
       public static List<Aluguel> listaAlugueis(Integer idLivro){
           List<Aluguel> aluguelEncontrada = new ArrayList();
           for (Aluguel a : listaAlugueis){
               if(a.getLivro().getId() == idLivro){
                   aluguelEncontrada.add(a);
               }
           }
           return aluguelEncontrada;
       }
}
