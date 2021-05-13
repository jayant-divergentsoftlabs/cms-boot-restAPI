package com.divergent.springboot.dao;

import java.util.List;

import com.divergent.springboot.entity.Drug;


public interface DrugDao {
	
	Drug add(Drug drug);

	List<Drug> listAll();

	void remove(Drug drug);

	Drug findById(int id);



}
