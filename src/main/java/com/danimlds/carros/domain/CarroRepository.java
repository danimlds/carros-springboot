package com.danimlds.carros.domain;


import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Long>{


	Iterable<Carro> getCarroByTipo(String tipo);

}
