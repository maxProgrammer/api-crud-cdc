package com.maxprogrammer.apicdc.validators;

import com.maxprogrammer.apicdc.forms.NovaCategoriaForm;
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
        return NovaCategoriaForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NovaCategoriaForm form = (NovaCategoriaForm) target;
        Optional<Categoria> possivelCategoria = categoriaRepository.findByNome(form.getNome());

        if (possivelCategoria.isPresent()) {
            errors.rejectValue("nome", null, "Já existe uma categoria com este nome");
        }
    }
}
