package com.maxprogrammer.apicdc.validations;

import com.maxprogrammer.apicdc.dtos.LivroDto;
import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.LivroRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class IsbnUnicoValidator implements Validator {

    private LivroRepository livroRepository;
    public IsbnUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return LivroDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LivroDto novoLivro = (LivroDto) target;
        String isbn = novoLivro.getIsbn();

       Optional<Livro> possivelLivro = livroRepository.findByIsbn(isbn);
       if(possivelLivro.isPresent()){
           errors.reject("isbn", null, "Já existe um livro com esse isbn");
       }
    }
}
