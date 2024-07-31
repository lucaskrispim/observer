package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deveNotificarUmUsuario() {
        Noticia noticia = new Noticia("Tecnologia", "Avanços em IA.");
        Usuario usuario = new Usuario("Usuário 1");
        usuario.seguirNoticia(noticia);
        noticia.atualizarNoticia("Tecnologia: IA revoluciona indústrias.");
        assertEquals("Usuário 1, nova atualização na notícia: Notícia{título='Tecnologia', conteúdo='Tecnologia: IA revoluciona indústrias.'}", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuarios() {
        Noticia noticia = new Noticia("Política", "Debate presidencial agendado.");
        Usuario usuario1 = new Usuario("Usuário 1");
        Usuario usuario2 = new Usuario("Usuário 2");
        usuario1.seguirNoticia(noticia);
        usuario2.seguirNoticia(noticia);
        noticia.atualizarNoticia("Política: Debate presidencial ocorre amanhã.");
        assertEquals("Usuário 1, nova atualização na notícia: Notícia{título='Política', conteúdo='Política: Debate presidencial ocorre amanhã.'}", usuario1.getUltimaNotificacao());
        assertEquals("Usuário 2, nova atualização na notícia: Notícia{título='Política', conteúdo='Política: Debate presidencial ocorre amanhã.'}", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuarioNaoInscrito() {
        Noticia noticia = new Noticia("Esportes", "Campeonato de futebol começa este mês.");
        Usuario usuario = new Usuario("Usuário 1");
        noticia.atualizarNoticia("Esportes: Campeonato de futebol começa esta semana.");
        assertNull(usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarUsuariosEspecificos() {
        Noticia noticiaA = new Noticia("Economia", "Novo pacote econômico anunciado.");
        Noticia noticiaB = new Noticia("Saúde", "Vacina contra nova doença é testada.");
        Usuario usuario1 = new Usuario("Usuário 1");
        Usuario usuario2 = new Usuario("Usuário 2");
        usuario1.seguirNoticia(noticiaA);
        usuario2.seguirNoticia(noticiaB);
        noticiaA.atualizarNoticia("Economia: Detalhes do novo pacote econômico.");
        assertEquals("Usuário 1, nova atualização na notícia: Notícia{título='Economia', conteúdo='Economia: Detalhes do novo pacote econômico.'}", usuario1.getUltimaNotificacao());
        assertNull(usuario2.getUltimaNotificacao());
    }
}