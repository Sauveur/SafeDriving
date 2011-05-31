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
			utilisateurs = (List<Utilisateur>) em.createQuery("SELECT p FROM Utilisateur AS p").getResultList();
		} finally {
			em.close();
		}
		return utilisateurs;
	}

	@Override
	public void maj(Utilisateur t) {
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
	/* méthode appelée dans le filtre d'authentification pour contrôler les données de connexion */
	public boolean authentifier(String pseudo, String mdp) {
		em = emf.createEntityManager();
		boolean auth = false;
		Utilisateur utilisateur;
		try {
			Query req = em.createQuery("SELECT p FROM Utilisateur AS p WHERE p.pseudo= :pseudo");
			req.setParameter("pseudo", pseudo);
			utilisateur = (Utilisateur) req.getSingleResult();
		} catch (Exception e) {
			utilisateur = null;
		}
			if (utilisateur != null && utilisateur.getMdp().equals(mdp)) {
				auth = true;
			}
			else auth = false;
		em.close();
		return auth;
	}

}
