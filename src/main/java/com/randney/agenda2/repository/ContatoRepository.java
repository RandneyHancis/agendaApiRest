package com.randney.agenda2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.randney.agenda2.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	Contato findById(long id);
}
