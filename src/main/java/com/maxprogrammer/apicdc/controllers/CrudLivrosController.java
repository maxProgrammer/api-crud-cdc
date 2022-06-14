package com.maxprogrammer.apicdc.controllers;

import com.maxprogrammer.apicdc.dtos.LivroDto;
import com.maxprogrammer.apicdc.validations.IsbnUnicoValidator;
import com.maxprogrammer.apicdc.validations.TituloLivroUnicoValidator;
import com.maxprogrammer.apicdc.validations.Uploader;
import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.AutorRepository;
import com.maxprogrammer.apicdc.repository.LivroRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CrudLivrosController {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    private Uploader uploader;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new IsbnUnicoValidator(livroRepository),
                new TituloLivroUnicoValidator(livroRepository));
    }

    @PostMapping(value = "/api/livro")
    @Operation(summary = "Add a new book")
    @Transactional
    public void novoLivro(@Valid LivroDto livroDto) {
        Livro novoLivro = livroDto.novoLivro(autorRepository, uploader);
        livroRepository.save(novoLivro);
    }
}
