package com.maxprogrammer.apicdc.site.dtos;

import com.maxprogrammer.apicdc.models.Autor;

public class AutorLivroDetalheDto {
    private final String descricao;
    private  String nome;

    public AutorLivroDetalheDto(Autor autor) {
        nome = autor.getNome();
        descricao = "Aqui precisa vir a descrição do autor";
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }
}
