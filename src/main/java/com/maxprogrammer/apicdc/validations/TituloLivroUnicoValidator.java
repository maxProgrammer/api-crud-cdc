package com.maxprogrammer.apicdc.validations;

import com.maxprogrammer.apicdc.dtos.LivroDto;
import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class TituloLivroUnicoValidator implements Validator {


    private LivroRepository livroRepository;
    public TituloLivroUnicoValidator( LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return LivroDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LivroDto novoLivro = (LivroDto) target;
        String titulo = novoLivro.getTitulo();

        Optional<Livro> possivelLivro = livroRepository.findByTitulo(titulo);
        if(possivelLivro.isPresent()){
            errors.reject("isbn", null, "Já existe um livro com esse titulo");
        }
    }
}
