package com.maxprogrammer.apicdc.site.models;

import com.maxprogrammer.apicdc.models.Livro;

public class LivroParaHome {

    private final Long id;
    private final String nomeAutor;
    private String titulo;

    public Long getId() {
        return id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LivroParaHome(Livro livro) {
        this.titulo = livro.getTitulo();
        this.id = livro.getID();
        this.nomeAutor = livro.getAutor().getNome();
    }


}
