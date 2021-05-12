package com.divergent.springboot.service;

import java.util.List;

import com.divergent.springboot.entity.Labtest;

public interface LabtestService {
	public void add(String name, int price);

	public boolean remove(int id);

	public Labtest findById(int id);
	
	public List<Labtest> list();
}
