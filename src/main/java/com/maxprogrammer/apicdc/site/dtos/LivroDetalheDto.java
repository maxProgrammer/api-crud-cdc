package com.maxprogrammer.apicdc.site.dtos;

import com.maxprogrammer.apicdc.models.Livro;

import java.math.BigDecimal;

public class LivroDetalheDto {
    private final String conteudo;
    private final String sumario;
    private final int paginas;
    private final String isbn;
    private final Long id;
    private BigDecimal preco;
    private String titulo;
    private String subtitulo;

    public LivroDetalheDto(Livro livro) {
        titulo = livro.getTitulo();
        subtitulo = livro.getSubTitulo();
        preco = livro.getPreco();
        conteudo = livro.getConteudo();
        sumario = livro.getSumario();
        AutorLivroDetalheDto autor = new AutorLivroDetalheDto(livro.getAutor());
        paginas = livro.getNumeroPaginas();
        isbn = livro.getIsbn();
        id = livro.getId();

    }

    public String getConteudo() {
        return conteudo;
    }

    public String getSumario() {
        return sumario;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public Long getId() {
        return id;
    }
}
