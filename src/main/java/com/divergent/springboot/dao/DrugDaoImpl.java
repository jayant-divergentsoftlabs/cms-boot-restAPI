package com.divergent.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergent.springboot.entity.Drug;

@Repository
public class DrugDaoImpl implements DrugDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Drug add(Drug drug) {
		em.persist(drug);
		return drug;		
	}

	@Override
	public List<Drug> listAll() {
		CriteriaQuery<Drug> criteriaQuery = em.getCriteriaBuilder().createQuery(Drug.class);
		@SuppressWarnings("unused")
		Root<Drug> root = criteriaQuery.from(Drug.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void remove(Drug drug) {
		em.remove(drug);
		
	}

	@Override
	public Drug findById(int id) {
		return em.find(Drug.class, id);
	}

	

}
