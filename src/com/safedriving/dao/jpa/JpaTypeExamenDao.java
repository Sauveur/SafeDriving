package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.TypeExamen;

public class JpaTypeExamenDao implements Dao<TypeExamen>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaTypeExamenDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(TypeExamen t) {
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
	public TypeExamen trouverParId(Long id) {
		em = emf.createEntityManager();
		TypeExamen t = null;
		try {
			t = em.find(TypeExamen.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<TypeExamen> lister() {
		em = emf.createEntityManager();
		List<TypeExamen> typesExamen = null;
		try {
			typesExamen = (List<TypeExamen>) em.createQuery("SELECT p FROM TypeExamen AS p").getResultList();
		} finally {
			em.close();
			return typesExamen;
		}
	}

	@Override
	public void maj(TypeExamen t) {
		
	}

	@Override
	public void supprimer(TypeExamen t) {
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
