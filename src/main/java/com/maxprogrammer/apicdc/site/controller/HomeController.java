package com.maxprogrammer.apicdc.site.controller;

import com.maxprogrammer.apicdc.repository.LivroRepository;
import com.maxprogrammer.apicdc.site.models.LivroParaHome;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class HomeController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping(value = "/api/home")
    @Operation(summary = "Return list with all books")
    public Collection<LivroParaHome> lista() {
        return livroRepository.findAll().stream().map(LivroParaHome::new).
                collect(Collectors.toList());
    }
}
