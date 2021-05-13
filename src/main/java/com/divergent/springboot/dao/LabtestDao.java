package com.divergent.springboot.dao;

import java.util.List;

import com.divergent.springboot.entity.Labtest;

public interface LabtestDao {

	Labtest add(Labtest labtest);

	List<Labtest> listAll();

	void remove(Labtest labtest);

	Labtest findById(int id);
}
