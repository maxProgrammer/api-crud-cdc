package com.maxprogrammer.apicdc.site.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.LivroRepository;
import com.maxprogrammer.apicdc.shared.Cookies;
import com.maxprogrammer.apicdc.site.dtos.LivroDetalheDto;
import com.maxprogrammer.apicdc.site.models.Carrinho;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    Cookies cookies;

    @GetMapping(value = "/api/livro/{id}")
    @Operation(summary = "Return a book by autorID")
    public LivroDetalheDto exibeDetalhes(@PathVariable("id") Long id) {
        Livro livro = livroRepository.findById(id).get();
        return new LivroDetalheDto(livro);
    }

    @PostMapping(value = "/api/carrinho/{idLivro}")
    @Operation(summary = "Return a book by idLivro")
    public String adicionaLivroCarrinho(@PathVariable("idLivro") Long idLivro, @CookieValue("carrinho") Optional<String> jsonCarrinho, HttpServletResponse response) throws JsonProcessingException {
        Carrinho carrinho = Carrinho.cria(jsonCarrinho);

        carrinho.adiciona(livroRepository.findById(idLivro).get());

        cookies.writeAsJson("carrinho", carrinho, response);

        return carrinho.toString();
    }
}
