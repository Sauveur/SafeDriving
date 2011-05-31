package com.safedriving.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@ManyToMany
	@JoinTable(name="session_formation_vers_vehicule")
	private List<Vehicule> vehicules;
	@ManyToOne
	@JoinColumn(name="FK_formateur")
	private Formateur formateur;
	@ManyToOne
	@JoinColumn(name="FK_lieu")
	private Lieu lieu;
	@ManyToOne
	@JoinColumn(name="FK_formation")
	private Formation formation;
	private int note;
	private String commentaire;
	@ManyToOne
	@JoinColumn(name="FK_client")
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
		return commentaire;
	}
	public void setComentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	
	public SessionFormation() {
		
	}
}
