package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Vehicule;

public class JpaVehiculeDao implements Dao<Vehicule>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaVehiculeDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(Vehicule t) {
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
	public Vehicule trouverParId(Long id) {
		em = emf.createEntityManager();
		Vehicule t = null;
		try {
			t = em.find(Vehicule.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Vehicule> lister() {
		em = emf.createEntityManager();
		List<Vehicule> vehicules = null;
		try {
			vehicules = (List<Vehicule>) em.createQuery("SELECT p FROM vehicule AS p").getResultList();
		} finally {
			em.close();
			return vehicules;
		}
	}

	@Override
	public void maJ(Vehicule t) {
		
	}

	@Override
	public void supprimer(Vehicule t) {
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
