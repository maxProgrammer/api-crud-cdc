package com.maxprogrammer.apicdc.repository;

import com.maxprogrammer.apicdc.models.Autor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
}
