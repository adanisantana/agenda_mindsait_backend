package com.agenda.dsm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.agenda.dsm.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
	public List<Pessoa> findAllByEnderecoContainingIgnoreCase(@Param("endereco") String endereco);
}
