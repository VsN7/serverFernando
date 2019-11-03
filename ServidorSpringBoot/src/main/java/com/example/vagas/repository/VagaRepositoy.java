package com.example.vagas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vagas.model.Vaga;





public interface VagaRepositoy extends JpaRepository<Vaga, Long>{

	@Query("select v from Vaga v where v.salario between :salarioInicio and :salarioFim")
	List<Vaga> findByFaixaSalarial(
            @Param("salarioInicio") float salarioInicio,
            @Param("salarioFim") float salarioFim);
	
}
