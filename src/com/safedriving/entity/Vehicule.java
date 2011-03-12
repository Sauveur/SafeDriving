package com.safedriving.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicule")
public class Vehicule implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="type_vehivule")
	private TypeVehicule typeVehicule;
	private String Immatriculation;
	@ManyToOne
	@JoinColumn(name="agence")
	private Lieu agence;
	@OneToMany
	private List<SessionFormation> sessionsFormation;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypeVehicule getTypeVehicule() {
		return typeVehicule;
	}
	public void setTypeVehicule(TypeVehicule typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	public String getImmatriculation() {
		return Immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		Immatriculation = immatriculation;
	}
	public Lieu getAgence() {
		return agence;
	}
	public void setAgence(Lieu agence) {
		this.agence = agence;
	}
	public List<SessionFormation> getSessionsFormation() {
		return sessionsFormation;
	}
	public void setSessionsFormation(List<SessionFormation> sessionsFormation) {
		this.sessionsFormation = sessionsFormation;
	}
	
	public Vehicule() {
		
	}
}
