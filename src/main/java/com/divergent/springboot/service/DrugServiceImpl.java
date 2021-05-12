package com.divergent.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergent.springboot.dao.DrugDao;
import com.divergent.springboot.entity.Drug;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	private DrugDao drugDao;

	@Transactional
	@Override
	public void add(String name, int price) {
		Drug drug = new Drug();
		drug.setName(name);
		drug.setPrice(price);
		drugDao.add(drug);
	}

	@Transactional
	@Override
	public boolean remove(int id) {
		Drug drug = this.findById(id);
		if (drug != null) {
			this.drugDao.remove(drug);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public Drug findById(int id) {
		return drugDao.findById(id);

	}

	@Transactional
	@Override
	public List<Drug> list() {
		return this.drugDao.listAll();

	}

}
