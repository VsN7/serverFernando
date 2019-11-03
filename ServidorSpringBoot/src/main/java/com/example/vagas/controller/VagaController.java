package com.example.vagas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vagas.model.Vaga;
import com.example.vagas.repository.VagaRepositoy;

@RestController
@RequestMapping(value="/api")
public class VagaController {
	
	@Autowired
	private VagaRepositoy vr;
	
	@GetMapping(produces="application/json")
	public  @ResponseBody Iterable<Vaga> listaVagas() {
		Iterable<Vaga> listaVagas = vr.findAll();
		return listaVagas;
	}
	
	@GetMapping("/faixaSalarial/{valorInicio}/{valorFinal}")
	public @ResponseBody Iterable<Vaga> faixaSalarial(@PathVariable float valorInicio,@PathVariable float valorFinal, Model model) {
		
		Iterable<Vaga> listaVagasFaixaSalarial = vr.findByFaixaSalarial(valorInicio, valorFinal);
		
		return listaVagasFaixaSalarial;
	}
	
	
	@PostMapping()
	public Vaga CadastraVaga(@RequestBody @Valid Vaga vaga) {
		return vr.save(vaga);
	}
	
	@DeleteMapping()
	public Vaga deletaVaga( @RequestBody Vaga vaga ) {
		vr.delete(vaga);
		return vaga;
	}
	@PutMapping()
	public Vaga editartaVaga( @RequestBody Vaga vaga ) {
		if(vaga.getId() != null)
			return vr.save(vaga);
		else
			return vaga;
	}
	

}
