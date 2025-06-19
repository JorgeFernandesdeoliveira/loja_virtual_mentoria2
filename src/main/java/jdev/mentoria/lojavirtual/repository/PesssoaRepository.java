package jdev.mentoria.lojavirtual.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jdev.mentoria.lojavirtual.model.PessoaFisica;

@Repository
public interface PesssoaRepository extends CrudRepository<PessoaFisica, Long> {

}
