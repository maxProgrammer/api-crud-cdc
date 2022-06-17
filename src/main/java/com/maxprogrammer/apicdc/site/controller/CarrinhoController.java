package com.maxprogrammer.apicdc.site.controller;

import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.LivroRepository;
import com.maxprogrammer.apicdc.shared.Cookies;
import com.maxprogrammer.apicdc.site.models.Carrinho;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
public class CarrinhoController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private Cookies cookies;

    @PostMapping(value = "/api/carrinho/{idLivro}/atualiza")
    @Operation(summary = "Update a shopping cart")
    public void atualiza(@PathVariable("idLivro") Long idLivro, @RequestParam int novaQuantidade, @CookieValue("carrinho") String jsonCarrinho, HttpServletResponse response) {
        Carrinho carrinho = Carrinho.cria(Optional.of(jsonCarrinho));
        Livro livro = livroRepository.findById(idLivro).get();

        carrinho.atualiza(livro, novaQuantidade);
        cookies.writeAsJson("carrinho", carrinho, response);


    }


}
