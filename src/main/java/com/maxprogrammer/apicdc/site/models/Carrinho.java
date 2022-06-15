package com.maxprogrammer.apicdc.site.models;

import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.site.dtos.LivroCarrinhoDto;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<LivroCarrinhoDto> livros = new ArrayList<>();

    public void adiciona(Livro livro) {
        livros.add(new LivroCarrinhoDto(livro));
    }

    @Override
    public String toString() {
        return "Carrinho [livros=" + livros + "]";
    }

    public List<LivroCarrinhoDto> getLivros() {
        return livros;
    }

}
