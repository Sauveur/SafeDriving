package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Examen;

public class JpaExamenDao implements Dao<Examen>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaExamenDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(Examen t) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public Examen trouverParId(Long id) {
		em = emf.createEntityManager();
		Examen t = null;
		try {
			t = em.find(Examen.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Examen> lister() {
		em = emf.createEntityManager();
		List<Examen> examens = null;
		try {
			examens = (List<Examen>) em.createQuery("SELECT p FROM examen AS p").getResultList();
		} finally {
			em.close();
			return examens;
		}
	}

	@Override
	public void maJ(Examen t) {
		
	}

	@Override
	public void supprimer(Examen t) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

}
