package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Lieu;

public class JpaLieuDao implements Dao<Lieu>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaLieuDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(Lieu t) {
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
	public Lieu trouverParId(Long id) {
		em = emf.createEntityManager();
		Lieu t = null;
		try {
			t = em.find(Lieu.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Lieu> lister() {
		em = emf.createEntityManager();
		List<Lieu> lieux = null;
		try {
			lieux = (List<Lieu>) em.createQuery("SELECT p FROM Lieu AS p").getResultList();
		} finally {
			em.close();
			return lieux;
		}
	}

	@Override
	public void maj(Lieu t) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

	@Override
	public void supprimer(Lieu t) {
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
