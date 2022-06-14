package com.maxprogrammer.apicdc.forms;

import com.maxprogrammer.apicdc.models.Categoria;

public class NovaCategoriaForm {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria novaCategoria() {
        return new Categoria(nome);
    }
}
