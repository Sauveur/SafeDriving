package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Formateur;

public class JpaFormateurDao implements Dao<Formateur>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaFormateurDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(Formateur t) {
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
	public Formateur trouverParId(Long id) {
		em = emf.createEntityManager();
		Formateur t = null;
		try {
			t = em.find(Formateur.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Formateur> lister() {
		em = emf.createEntityManager();
		List<Formateur> formateurs = null;
		try {
			formateurs = (List<Formateur>) em.createQuery("SELECT p FROM formateur AS p").getResultList();
		} finally {
			em.close();
			return formateurs;
		}
	}

	@Override
	public void maJ(Formateur t) {
		
	}

	@Override
	public void supprimer(Formateur t) {
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
