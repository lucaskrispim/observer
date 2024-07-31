package org.example;

import java.util.Observable;

public class Noticia extends Observable {

    private String titulo;
    private String conteudo;

    public Noticia(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public void atualizarNoticia(String novoConteudo) {
        this.conteudo = novoConteudo;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Notícia{" +
                "título='" + titulo + '\'' +
                ", conteúdo='" + conteudo + '\'' +
                '}';
    }
}
