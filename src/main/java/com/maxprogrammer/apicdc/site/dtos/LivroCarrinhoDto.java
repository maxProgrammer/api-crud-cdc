package com.maxprogrammer.apicdc.site.dtos;

import com.maxprogrammer.apicdc.models.Livro;

import java.math.BigDecimal;

public class LivroCarrinhoDto {

    private String linkCapaLivro;
    private BigDecimal preco;
    private String titulo;

    @Deprecated
    public LivroCarrinhoDto() {
    }

    public LivroCarrinhoDto(Livro livro) {
        titulo = livro.getTitulo();
        preco = livro.getPreco();
        linkCapaLivro = livro.getLinkCapaLivro();
    }


    public String getLinkCapaLivro() {
        return linkCapaLivro;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "LivroCarrinhoDto{" +
                "linkCapaLivro='" + linkCapaLivro + '\'' +
                ", preco=" + preco +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
