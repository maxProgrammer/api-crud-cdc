package com.maxprogrammer.apicdc.validations;

import com.maxprogrammer.apicdc.dtos.CategoriaDto;
import com.maxprogrammer.apicdc.models.Categoria;
import com.maxprogrammer.apicdc.repository.CategoriaRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class SemCategoriaComNomeDuplicadoValidator implements Validator {

    private CategoriaRepository categoriaRepository;

    public SemCategoriaComNomeDuplicadoValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CategoriaDto categoriaDto = (CategoriaDto) target;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(categoriaDto.getNome());

        if (possivelCategoria.isPresent()) {
            errors.rejectValue("nome", null, "Já existe uma categoria com este nome");
        }
    }
}
