package com.safedriving.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="formateur")
public class Formateur implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private boolean estCommercial;
	@OneToMany(mappedBy="formateur")
	private List<SessionFormation> sessionsFormation;
	@OneToOne
	@JoinColumn(name="FK_utilisateur")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy="formateur")
	private List<Indisponibilite> indisponibilites;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isEstCommercial() {
		return estCommercial;
	}
	public void setEstCommercial(boolean estCommercial) {
		this.estCommercial = estCommercial;
	}
	public List<SessionFormation> getSessionsFormation() {
		return sessionsFormation;
	}
	public void setSessionsFormation(List<SessionFormation> sessionsFormation) {
		this.sessionsFormation = sessionsFormation;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<Indisponibilite> getIndisponibilites() {
		return indisponibilites;
	}
	public void setIndisponibilites(List<Indisponibilite> indisponibilites) {
		this.indisponibilites = indisponibilites;
	}
	
	public Formateur() {
		
	}
}
