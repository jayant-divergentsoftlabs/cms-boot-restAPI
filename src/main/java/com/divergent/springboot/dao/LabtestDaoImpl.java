package com.divergent.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergent.springboot.entity.Labtest;

@Repository
public class LabtestDaoImpl implements LabtestDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Labtest> listAll() {
		CriteriaQuery<Labtest> criteriaQuery = em.getCriteriaBuilder().createQuery(Labtest.class);
		@SuppressWarnings("unused")
		Root<Labtest> root = criteriaQuery.from(Labtest.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Labtest add(Labtest labtest) {
		em.persist(labtest);
		return labtest;

	}

	@Override
	public void remove(Labtest labtest) {
		em.remove(labtest);

	}

	@Override
	public Labtest findById(int id) {
		return em.find(Labtest.class, id);

	}

}
