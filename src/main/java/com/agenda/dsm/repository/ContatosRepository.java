package com.agenda.dsm.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.dsm.model.Contatos;

@Repository
public interface ContatosRepository extends JpaRepository<Contatos,Long> {

}
