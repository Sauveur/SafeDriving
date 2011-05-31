package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Client;

public class JpaClientDao implements Dao<Client>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaClientDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(Client t) {
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
	public Client trouverParId(Long id) {
		em = emf.createEntityManager();
		Client t = null;
		try {
			t = em.find(Client.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Client> lister() {
		em = emf.createEntityManager();
		List<Client> clients = null;
		try {
			clients = (List<Client>) em.createQuery("SELECT p FROM Client AS p").getResultList();
		} finally {
			em.close();
			return clients;
		}
	}

	@Override
	public void maj(Client t) {
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
	public void supprimer(Client t) {
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
