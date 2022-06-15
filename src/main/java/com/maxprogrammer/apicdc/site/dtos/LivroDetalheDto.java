package com.maxprogrammer.apicdc.site.dtos;

import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.shared.Markdown;

import java.math.BigDecimal;

public class LivroDetalheDto {
    private final String conteudo;
    private final String sumarioOriginal;
    private final int paginas;
    private final String isbn;
    private final Long id;
    private String sumarioHtml;
    private BigDecimal preco;
    private String titulo;
    private String subtitulo;

    public LivroDetalheDto(Livro livro) {
        titulo = livro.getTitulo();
        subtitulo = livro.getSubTitulo();
        preco = livro.getPreco();
        conteudo = livro.getConteudo();
        sumarioOriginal = livro.getSumario();
        sumarioHtml = Markdown.renderHtml(livro.getSumario());
        AutorLivroDetalheDto autor = new AutorLivroDetalheDto(livro.getAutor());
        paginas = livro.getNumeroPaginas();
        isbn = livro.getIsbn();
        id = livro.getId();

    }

    public String getConteudo() {
        return conteudo;
    }

    public String getSumarioOriginal() {
        return sumarioOriginal;
    }

    public String getSumarioHtml() {
        return sumarioHtml;
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
