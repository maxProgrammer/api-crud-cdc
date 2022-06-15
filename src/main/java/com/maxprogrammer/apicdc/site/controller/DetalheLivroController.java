package com.maxprogrammer.apicdc.site.controller;

import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.LivroRepository;
import com.maxprogrammer.apicdc.site.dtos.LivroDetalheDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalheLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping(value = "/api/livro/{id}")
    @Operation(summary = "Return a book by {id}")
    public LivroDetalheDto getMethodName(@PathVariable("id") Long id) {

        Livro livro = livroRepository.findById(id).get();
        return new LivroDetalheDto(livro);
    }
}
