package com.safedriving.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.safedriving.dao.Dao;
import com.safedriving.entity.TypeVehicule;

public class JpaTypeVehiculeDao implements Dao<TypeVehicule>{
	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	public JpaTypeVehiculeDao(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	@Override
	public void ajouter(TypeVehicule t) {
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
	public TypeVehicule trouverParId(Long id) {
		em = emf.createEntityManager();
		TypeVehicule t = null;
		try {
			t = em.find(TypeVehicule.class, id);
		} finally {
			em.close();
			return t;			
		}
	}

	@Override
	public List<TypeVehicule> lister() {
		em = emf.createEntityManager();
		List<TypeVehicule> typesVehicule = null;
		try {
			typesVehicule = (List<TypeVehicule>) em.createQuery("SELECT p FROM type_vehicule AS p").getResultList();
		} finally {
			em.close();
			return typesVehicule;
		}
	}

	@Override
	public void maj(TypeVehicule t) {
		
	}

	@Override
	public void supprimer(TypeVehicule t) {
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
