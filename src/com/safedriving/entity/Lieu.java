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
import javax.persistence.Table;

@Entity
@Table(name="lieu")
public class Lieu implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	@ManyToOne
	@JoinColumn(name="FK_adresse")
	private Adresse adresse;
	@OneToMany(mappedBy="agence")
	private List<Client> clients;
	@OneToMany(mappedBy="lieu")
	private List<ExamenPrefecture> examensPrefecture;
	@OneToMany(mappedBy="agence")
	private List<Vehicule> vehicules;
	@OneToMany(mappedBy="lieu")
	private List<SessionFormation> sessionsFormation;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<ExamenPrefecture> getExamensPrefecture() {
		return examensPrefecture;
	}
	public void setExamensPrefecture(List<ExamenPrefecture> examensPrefecture) {
		this.examensPrefecture = examensPrefecture;
	}
	public List<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	public List<SessionFormation> getSessionsFormation() {
		return sessionsFormation;
	}
	public void setSessionsFormation(List<SessionFormation> sessionsFormation) {
		this.sessionsFormation = sessionsFormation;
	}
	
	public Lieu() {
		
	}
}
