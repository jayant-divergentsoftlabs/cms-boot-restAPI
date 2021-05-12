package com.divergent.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergent.springboot.dao.LabtestDao;
import com.divergent.springboot.entity.Labtest;

@Service
public class LabtestServiceImpl implements LabtestService {
	@Autowired
	private LabtestDao labtestDao;

	@Transactional
	@Override
	public void add(String name, int price) {
		Labtest labtest = new Labtest();
		labtest.getName();
		labtest.getPrice();
		labtestDao.add(labtest);
	}

	@Transactional
	@Override
	public boolean remove(int id) {
		Labtest labtest = this.findById(id);
		if (labtest != null) {
			this.labtestDao.remove(labtest);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public Labtest findById(int id) {
		return labtestDao.findById(id);
	}

	@Transactional
	@Override
	public List<Labtest> list() {
		return this.labtestDao.listAll();
	}

}
