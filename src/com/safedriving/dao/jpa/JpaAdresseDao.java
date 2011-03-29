package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Adresse;

public class JpaAdresseDao implements Dao<Adresse>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaAdresseDao(EntityManagerFactory emf){
		this.emf = emf;
	}

	@Override
	public void ajouter(Adresse t) {
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
	public Adresse trouverParId(Long id) {
		em = emf.createEntityManager();
		Adresse t = null;
		try {
			t = em.find(Adresse.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Adresse> lister() {
		em = emf.createEntityManager();
		List<Adresse> adresses = null;
		try {
			adresses = (List<Adresse>) em.createQuery("SELECT p FROM adresse AS p").getResultList();
		} finally {
			em.close();
			return adresses;
		}
	}

	@Override
	public void maj(Adresse t) {
		
	}

	@Override
	public void supprimer(Adresse t) {
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
