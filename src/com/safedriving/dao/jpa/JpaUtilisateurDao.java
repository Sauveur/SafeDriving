package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.safedriving.dao.Dao;
import com.safedriving.entity.Utilisateur;

public class JpaUtilisateurDao implements Dao<Utilisateur>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaUtilisateurDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(Utilisateur t) {
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
	public Utilisateur trouverParId(Long id) {
		em = emf.createEntityManager();
		Utilisateur t = null;
		try {
			t = em.find(Utilisateur.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<Utilisateur> lister() {
		em = emf.createEntityManager();
		List<Utilisateur> utilisateurs = null;
		try {
			utilisateurs = (List<Utilisateur>) em.createQuery("SELECT p FROM utilisateur AS p").getResultList();
		} finally {
			em.close();
		}
		return utilisateurs;
	}

	@Override
	public void maj(Utilisateur t) {
		
	}

	@Override
	public void supprimer(Utilisateur t) {
		em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public boolean authentifier(String pseudo, String mdp) {
		em = emf.createEntityManager();
		boolean auth = false;
		try {
			Query req = em.createQuery("SELECT p FROM utilisateur AS p WHERE p.pseudo= :pseudo");
			req.setParameter("pseudo", pseudo);
			Utilisateur utilisateur = (Utilisateur) req.getSingleResult();
			if (utilisateur != null && utilisateur.getMotDePasse() == mdp) {
				auth = true;
			}
			else auth = false;
		} finally {
			em.close();
		}
		return auth;
	}

}
