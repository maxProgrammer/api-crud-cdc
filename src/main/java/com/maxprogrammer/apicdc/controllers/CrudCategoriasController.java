package com.maxprogrammer.apicdc.controllers;

import com.maxprogrammer.apicdc.models.Categoria;
import com.maxprogrammer.apicdc.dtos.CategoriaDto;
import com.maxprogrammer.apicdc.repository.CategoriaRepository;
import com.maxprogrammer.apicdc.validations.SemCategoriaComNomeDuplicadoValidator;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CrudCategoriasController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @InitBinder("novaCategoriaForm")
    public void init(WebDataBinder dataBinder){
        dataBinder.addValidators(new SemCategoriaComNomeDuplicadoValidator(categoriaRepository));
    }

    @PostMapping(value = "/api/categoria")
    @Operation(summary = "Add a new category")
    @Transactional
    public void novaCategoria(@Valid @RequestBody CategoriaDto categoriaDto) {
        Categoria novaCategoria = categoriaDto.novaCategoria();
        categoriaRepository.save(novaCategoria);
    }
}
