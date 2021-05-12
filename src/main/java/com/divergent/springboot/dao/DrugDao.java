package com.divergent.springboot.dao;

import java.util.List;

import com.divergent.springboot.entity.Drug;


public interface DrugDao {
	
	void add(Drug drug);

	List<Drug> listAll();

	void remove(Drug drug);

	Drug findById(int id);



}
