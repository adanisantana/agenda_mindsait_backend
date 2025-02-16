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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.agenda.dsm.model.Pessoa;
import com.agenda.dsm.record.PessoaRecord;
import com.agenda.dsm.repository.PessoaRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*", allowedHeaders ="*")
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll(){
		return ResponseEntity.ok(pessoaRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getById(@PathVariable Long id){
		return pessoaRepository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Pessoa> post(@Valid @RequestBody Pessoa pessoa){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(pessoaRepository.save(pessoa));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Pessoa> put(@Valid @RequestBody Pessoa pessoa){
		return pessoaRepository.findById(pessoa.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK)
						.body(pessoaRepository.save(pessoa)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		if(pessoa.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		pessoaRepository.deleteById(id);
	}
	
	
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<PessoaRecord> getPessoaMalaDireta(@PathVariable Long id) {
	    Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);

	    if (pessoaOptional.isPresent()) {
	        Pessoa pessoa = pessoaOptional.get();
	
	        
	        String malaDireta = String.format("%s – CEP: %s – %s/%s",
	                pessoa.getEndereco(),
	                pessoa.getCep(),
	                pessoa.getCidade(),
	                pessoa.getUf());

	        
	        PessoaRecord pessoaMalaDiretaRecord = new PessoaRecord(
	                pessoa.getId(),
	                pessoa.getNome(),
	                malaDireta
	        );

	        return ResponseEntity.ok(pessoaMalaDiretaRecord);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	
	}
	}
