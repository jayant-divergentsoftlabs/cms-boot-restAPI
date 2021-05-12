package com.divergent.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergent.springboot.entity.Doctor;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Doctor doctor) {
		em.persist(doctor);
	}

	@Override
	public List<Doctor> listAll() {
		CriteriaQuery<Doctor> criteriaQuery = em.getCriteriaBuilder().createQuery(Doctor.class);
		@SuppressWarnings("unused")
		Root<Doctor> root = criteriaQuery.from(Doctor.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void remove(Doctor doctor) {
		em.remove(doctor);
	}

	@Override
	public Doctor findById(int id) {
		return em.find(Doctor.class, id);
	}

	@Override
	public void update(Doctor doctor) {
		em.persist(doctor);

	}

}
