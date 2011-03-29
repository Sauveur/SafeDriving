package com.safedriving.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="examen_prefecture")
public class ExamenPrefecture implements Serializable{
	private Long id;
	@ManyToOne
	@JoinColumn(name="FK_type_examen")
	private TypeExamen typeExamen;
	private int nombrePlaces;
	private Date date;
	@ManyToOne
	@JoinColumn(name="FK_lieu")
	private Lieu lieu;
	@ManyToMany
	@JoinTable(name="examen_prefecture_vers_vehicule")
	private List<Vehicule> vehicules;
	
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
	public int getNombrePlaces() {
		return nombrePlaces;
	}
	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	public List<Vehicule> getVehicules() {
		return vehicules;
	}
	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	
	public ExamenPrefecture() {
		
	}
}
