package com.danimlds.carros.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danimlds.carros.domain.Carro;
import com.danimlds.carros.domain.CarroService;
@RestController
@RequestMapping("/api/v1/carros")
public class CarrosController {
	@Autowired
	private CarroService service;
	
	@GetMapping
	public Iterable<Carro> get() {
		return service.getCarros();
	}
	
	@GetMapping("/{id}")
	public java.util.Optional<Carro> get(@PathVariable("id") Long id) {
		return service.getCarroById(id);
	}
	
	@GetMapping("/tipo/{tipo}")
	public Iterable<Carro> getCarroByTipo(@PathVariable("tipo") String tipo) {
		return service.getCarroByTipo(tipo);
	}
	
	@PostMapping
	public String post(@RequestBody Carro carro){
		Carro c = service.insert(carro);
		return "Carro salvo com sucesso: "+c.getId(); 
	}
	
	@PutMapping("/{id}")
	public String put(@PathVariable("Id") Long id, @RequestBody Carro carro) {
		Carro c = service.update(carro, id);
		
		return "Carro atualizado com sucesso" +c.getId();
		
	}
	
	
}
