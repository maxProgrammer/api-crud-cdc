package com.maxprogrammer.apicdc.validations;

import com.maxprogrammer.apicdc.dtos.LivroDto;
import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.LivroRepository;

import java.util.Optional;

public class IsbnUnicoValidator extends CampoUnicoLivroValidator {

    private LivroRepository livroRepository;

    public IsbnUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public Optional<Livro> buscaLivroPorCampo(LivroDto livroDto) {
        return livroRepository.findByIsbn(livroDto.getIsbn());
    }

    @Override
    protected String getNomeCampoInvalido() {
        return "isbn";
    }

}