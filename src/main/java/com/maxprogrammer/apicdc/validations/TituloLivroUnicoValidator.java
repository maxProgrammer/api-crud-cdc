package com.maxprogrammer.apicdc.validations;

import com.maxprogrammer.apicdc.dtos.LivroDto;
import com.maxprogrammer.apicdc.models.Livro;
import com.maxprogrammer.apicdc.repository.LivroRepository;

import java.util.Optional;

public class TituloLivroUnicoValidator extends CampoUnicoLivroValidator {

    private LivroRepository livroRepository;

    public TituloLivroUnicoValidator(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public Optional<Livro> buscaLivroPorCampo(LivroDto novoLivroForm) {
        return livroRepository.findByTitulo(novoLivroForm.getTitulo());
    }

    @Override
    protected String getNomeCampoInvalido() {
        return "titulo";
    }



}