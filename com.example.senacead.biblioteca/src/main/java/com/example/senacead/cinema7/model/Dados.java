package com.example.senacead.cinema7.model;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private static List<Filme> listaFilmes = new ArrayList();
    private static List<Analise> listaAnalises = new ArrayList();

    public static void adicionarFilme(Filme filme) {
        filme.setId(listaFilmes.size() + 1);
        listaFilmes.add(filme);
    }

    public static List<Filme> listarFilmes() {
        /**
         * refatoração de código, cpodigos da controller estão sendo adaptados
         * para a lista de Dados*
         */
        return listaFilmes;
    }

    public static void excluirFilme(Integer id) {
        for (Filme f : listaFilmes) {
            if (f.getId() == id) {
                listaFilmes.remove(f);
                break;
            }
        }
    }

    public static Filme obtemFilme(Integer id) {
        Filme filmeEncontrado = new Filme();
        for (Filme f : listaFilmes) {
            if (f.getId() == id) {
                filmeEncontrado = f;
                break;
            }
        }

        return filmeEncontrado;
    }

    public static void atualizarFilme(Filme filme) {
        for (Filme f : listaFilmes) {
            if (f.getId() == filme.getId()) {
                f.setNome(filme.getNome());
                f.setGenero(filme.getGenero());
                f.setSinopse(filme.getSinopse());
                f.setAnoLancamento(filme.getAnoLancamento());
                break;
            }
        }

    }
    
      public static void adicionarAnalise(Analise analise, Filme filme) {
        analise.setId(listaAnalises.size() + 1);
        analise.setFilme(filme);
        listaAnalises.add(analise);
    }
      
       public static void excluirAnalise(Integer id) {
        for (Analise a : listaAnalises) {
            if (a.getId() == id) {
                listaAnalises.remove(a);
                break;
            }
        }
    }
       
       public static List<Analise> listaAnalises(Integer idFilme){
           List<Analise> analiseEncontrada = new ArrayList();
           for (Analise a : listaAnalises){
               if(a.getFilme().getId() == idFilme){
                   analiseEncontrada.add(a);
               }
           }
           return analiseEncontrada;
       }
}
