package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Formation;

public class JpaFormationDao implements Dao<Formation>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaFormationDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(Formation t) {
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
	public Formation trouverParId(Long id) {
		em = emf.createEntityManager();
		Formation t = null;
		try {
			t = em.find(Formation.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Formation> lister() {
		em = emf.createEntityManager();
		List<Formation> formations = null;
		try {
			formations = (List<Formation>) em.createQuery("SELECT p FROM formation AS p").getResultList();
		} finally {
			em.close();
			return formations;
		}
	}

	@Override
	public void maJ(Formation t) {
		
	}

	@Override
	public void supprimer(Formation t) {
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
