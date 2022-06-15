package com.maxprogrammer.apicdc.validations;

import com.maxprogrammer.apicdc.dtos.LivroDto;
import com.maxprogrammer.apicdc.models.Livro;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import java.util.Optional;

public abstract class CampoUnicoLivroValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LivroDto.class.isAssignableFrom(clazz);
    }

    public abstract Optional<Livro> buscaLivroPorCampo(LivroDto novoLivroForm);

    @Override
    public void validate(Object target, Errors errors) {
        LivroDto form = (LivroDto) target;

        Optional<Livro> possivelLivro = buscaLivroPorCampo(form);

        if(possivelLivro.isPresent()) {
            String nomeCampoInvalido = getNomeCampoInvalido();
            errors.rejectValue(nomeCampoInvalido, null,nomeCampoInvalido+": Já existe um livro igual cadastrado");
        }
    }

    protected abstract String getNomeCampoInvalido();
}