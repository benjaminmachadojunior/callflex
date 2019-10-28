package com.produtos.apirest.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.produtos.apirest.models.Dolar;

@Repository
public interface DolarRepository extends JpaRepository<Dolar, Long>{

	Dolar findById(long id);

	void save(String body);
	

    @Query("INSERT INTO Dolar VALUES (?1, ?2)")
	void saveTodos(String... date);


}
