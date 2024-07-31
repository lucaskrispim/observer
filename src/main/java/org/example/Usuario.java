package org.example;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void seguirNoticia(Noticia noticia) {
        noticia.addObserver(this);
    }

    @Override
    public void update(Observable noticia, Object arg1) {
        this.ultimaNotificacao = this.nome + ", nova atualização na notícia: " + noticia.toString();
    }
}
