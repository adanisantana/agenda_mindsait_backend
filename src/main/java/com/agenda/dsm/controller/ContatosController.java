package com.agenda.dsm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.agenda.dsm.model.Contatos;
import com.agenda.dsm.repository.ContatosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/contatos")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class ContatosController {
	
	@Autowired
	private ContatosRepository contatosRepository;
	
	@GetMapping
	public ResponseEntity<List<Contatos>> getAll(){
		return ResponseEntity.ok(contatosRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contatos> getById(@PathVariable Long id){
		return contatosRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Contatos> post(@Valid @RequestBody  Contatos contatos){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(contatosRepository.save(contatos));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Contatos> put(@Valid @RequestBody Contatos contatos){
		return contatosRepository.findById(contatos.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED)
						.body(contatosRepository.save(contatos)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
				
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Contatos> contatos = contatosRepository.findById(id);
		
		if(contatos.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		contatosRepository.deleteById(id);
	}
}
