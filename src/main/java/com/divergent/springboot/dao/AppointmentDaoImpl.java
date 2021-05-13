package com.divergent.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.divergent.springboot.entity.Appointment;



@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Appointment add(Appointment appointment) {
		em.persist(appointment);
		return appointment;
	}

	@Override
	public List<Appointment> get() {
		CriteriaQuery<Appointment> criteriaQuery = em.getCriteriaBuilder().createQuery(Appointment.class);
		@SuppressWarnings("unused")
		Root<Appointment> root = criteriaQuery.from(Appointment.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

}
