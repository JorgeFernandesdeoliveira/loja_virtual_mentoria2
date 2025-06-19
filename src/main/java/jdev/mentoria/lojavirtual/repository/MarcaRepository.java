package jdev.mentoria.lojavirtual.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jdev.mentoria.lojavirtual.model.MarcaProduto;

@Repository
public interface MarcaRepository extends CrudRepository<MarcaProduto, Long> {
	

	@Query("select a from MarcaProduto a where upper(trim(a.nomeDesc)) like %?1%")
	public List<MarcaProduto> buscarMarcaDesc(String desc); 
}
