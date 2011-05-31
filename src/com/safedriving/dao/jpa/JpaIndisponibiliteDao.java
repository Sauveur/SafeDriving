package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Indisponibilite;
import com.safedriving.entity.TypeExamen;

public class JpaIndisponibiliteDao implements Dao<Indisponibilite> {
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public JpaIndisponibiliteDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(Indisponibilite t) {
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
	public Indisponibilite trouverParId(Long id) {
		em = emf.createEntityManager();
		Indisponibilite t = null;
		try {
			t = em.find(Indisponibilite.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Indisponibilite> lister() {
		em = emf.createEntityManager();
		List<Indisponibilite> indisponibilites = null;
		try {
			indisponibilites = (List<Indisponibilite>) em.createQuery("SELECT p FROM Indisponibilite AS p").getResultList();
		} finally {
			em.close();
			return indisponibilites;
		}
	}

	@Override
	public void maj(Indisponibilite t) {
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
	public void supprimer(Indisponibilite t) {
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
