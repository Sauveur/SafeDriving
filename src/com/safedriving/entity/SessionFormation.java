package com.safedriving.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="session_formation")
public class SessionFormation implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date debut;
	private Date fin;
	@ManyToOne
	@JoinColumn(name="vehicule")
	private Vehicule vehicule;
	@ManyToOne
	@JoinColumn(name="formateur")
	private Formateur formateur;
	@ManyToOne
	@JoinColumn(name="lieu")
	private Lieu lieu;
	@ManyToOne
	@JoinColumn(name="formation")
	private Formation formation;
	private int note;
	private String comentaire;
	@ManyToOne
	@JoinColumn(name="client")
	private Client client;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public Vehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getComentaire() {
		return comentaire;
	}
	public void setComentaire(String comentaire) {
		this.comentaire = comentaire;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public SessionFormation() {
		
	}
}
