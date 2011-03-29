package com.safedriving.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="formation")
public class Formation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private float prix;
	private int duree;
	private int nombrePlaces;
	@OneToMany(mappedBy="formation")
	private List<SessionFormation> sessionsFormation;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getNombrePlaces() {
		return nombrePlaces;
	}
	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}
	public List<SessionFormation> getSessionsFormation() {
		return sessionsFormation;
	}
	public void setSessionsFormation(List<SessionFormation> sessionsFormation) {
		this.sessionsFormation = sessionsFormation;
	}
	
	public Formation() {
		
	}
}
