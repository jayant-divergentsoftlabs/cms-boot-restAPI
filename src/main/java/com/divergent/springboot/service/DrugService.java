package com.divergent.springboot.service;

import java.util.List;

import com.divergent.springboot.entity.Drug;

public interface DrugService {

	public void add(String name, int price);

	public boolean remove(int id);

	public Drug findById(int id);

	public List<Drug> list();

}
