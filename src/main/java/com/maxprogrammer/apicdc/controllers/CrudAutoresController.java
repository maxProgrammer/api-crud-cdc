package com.maxprogrammer.apicdc.controllers;

import com.maxprogrammer.apicdc.dtos.AutorDto;
import com.maxprogrammer.apicdc.models.Autor;
import com.maxprogrammer.apicdc.repository.AutorRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CrudAutoresController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/api/autor")
    @Operation(summary = "Add a new author")
    @Transactional
    public void novoAutor(@Valid @RequestBody AutorDto autorDto) {
        Autor novoAutor = autorDto.novoAutor();
        autorRepository.save(novoAutor);

    }

}
