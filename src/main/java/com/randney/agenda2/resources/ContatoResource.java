package com.randney.agenda2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.randney.agenda2.models.Contato;
import com.randney.agenda2.repository.ContatoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API Rest Contatos")
@CrossOrigin(origins="*")
public class ContatoResource {
	@Autowired
	ContatoRepository contatoRepository;
	
	@GetMapping("/contatos")
	@ApiOperation(value="Retorna uma lista de contatos")
	public List<Contato> listaContatos(){
		return contatoRepository.findAll();
	}
	
	@GetMapping("/contato/{id}")
	@ApiOperation(value="Retorna um contato")
	public Contato listaContatoUnico(@PathVariable(value="id") long id){
		return contatoRepository.findById(id);
	}
	
	@PostMapping("/contato")
	@ApiOperation(value="Salva um novo contato")
	public Contato salvaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
	
	@DeleteMapping("/contato")
	@ApiOperation(value="Apaga um contato da lista")
	public void deletaContato(@RequestBody Contato contato) {
		contatoRepository.delete(contato);
	}
	
	@PutMapping("/contato")
	@ApiOperation(value="Atualiza um contato")
	public Contato atualizaContato(@RequestBody Contato contato) {
		return contatoRepository.save(contato);
	}
}
