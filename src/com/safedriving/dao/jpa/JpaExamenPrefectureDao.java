package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.ExamenPrefecture;

public class JpaExamenPrefectureDao implements Dao<ExamenPrefecture>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaExamenPrefectureDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(ExamenPrefecture t) {
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
	public ExamenPrefecture trouverParId(Long id) {
		em = emf.createEntityManager();
		ExamenPrefecture t = null;
		try {
			t = em.find(ExamenPrefecture.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<ExamenPrefecture> lister() {
		em = emf.createEntityManager();
		List<ExamenPrefecture> examensPrefecture = null;
		try {
			examensPrefecture = (List<ExamenPrefecture>) em.createQuery("SELECT p FROM examen_prefecture AS p").getResultList();
		} finally {
			em.close();
			return examensPrefecture;
		}
	}

	@Override
	public void maJ(ExamenPrefecture t) {
		
	}

	@Override
	public void supprimer(ExamenPrefecture t) {
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
