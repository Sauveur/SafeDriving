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
@Table(name="examen")
public class Examen implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@JoinColumn(name="FK_type_examen")
	private TypeExamen typeExamen;
	private Date dateDePassage;
	private boolean obtenu;
	@ManyToOne
	@JoinColumn(name="FK_client")
	private Client client;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypeExamen getTypeExamen() {
		return typeExamen;
	}
	public void setTypeExamen(TypeExamen typeExamen) {
		this.typeExamen = typeExamen;
	}
	public Date getDateDePassage() {
		return dateDePassage;
	}
	public void setDateDePassage(Date dateDePassage) {
		this.dateDePassage = dateDePassage;
	}
	public boolean isObtenu() {
		return obtenu;
	}
	public void setObtenu(boolean obtenu) {
		this.obtenu = obtenu;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Examen() {
		
	}
}
