package com.maxprogrammer.apicdc.site.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.LivroRepository;
import com.maxprogrammer.apicdc.site.dtos.LivroDetalheDto;
import com.maxprogrammer.apicdc.site.models.Carrinho;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(value = "/api/livro/{id}")
    @Operation(summary = "Return a book by autorID")
    public LivroDetalheDto exibeDetalhes(@PathVariable("id") Long id) {
        Livro livro = livroRepository.findById(id).get();
        return new LivroDetalheDto(livro);
    }

    @PostMapping(value = "/api/carrinho/{idLivro}")
    @Operation(summary = "Return a book by idLivro")
    public String adicionaLivroCarrinho(@PathVariable("idLivro") Long idLivro,
                                        @CookieValue("carrinho") Optional<String> jsonCarrinho, HttpServletResponse response) throws JsonProcessingException {

        Carrinho carrinho = jsonCarrinho.map(json -> {
            try {
                return new ObjectMapper().readValue(json, Carrinho.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).orElse(new Carrinho());

        carrinho.adiciona(livroRepository.findById(idLivro).get());
        Cookie cookie = new Cookie("carrinho", new ObjectMapper().writeValueAsString(carrinho));
        cookie.setHttpOnly(true);

        response.addCookie(cookie);
        return carrinho.toString();

        /*
         * receber o carrinho pelo cookie(json)
         * se não tiver ainda cookie para o carrinho, etnão cria um carrinho novo
         *  precisa da capa, titulo, preco
         */
    }
}
