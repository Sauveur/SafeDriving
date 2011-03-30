package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.SessionFormation;

public class JpaSessionFormationDao implements Dao<SessionFormation>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaSessionFormationDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(SessionFormation t) {
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
	public SessionFormation trouverParId(Long id) {
		em = emf.createEntityManager();
		SessionFormation t = null;
		try {
			t = em.find(SessionFormation.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<SessionFormation> lister() {
		em = emf.createEntityManager();
		List<SessionFormation> sessionsFormation = null;
		try {
			sessionsFormation = (List<SessionFormation>) em.createQuery("SELECT p FROM SessionFormation AS p").getResultList();
		} finally {
			em.close();
			return sessionsFormation;
		}
	}

	@Override
	public void maj(SessionFormation t) {
		
	}

	@Override
	public void supprimer(SessionFormation t) {
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
