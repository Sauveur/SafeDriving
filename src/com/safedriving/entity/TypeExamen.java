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
@Table(name="type_examen")
public class TypeExamen implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nom;
	@OneToMany
	private List<Examen> examens;
	@OneToMany
	private List<ExamenPrefecture> examensPrefecture;
	
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
	public List<Examen> getExamens() {
		return examens;
	}
	public void setExamens(List<Examen> examens) {
		this.examens = examens;
	}
	public List<ExamenPrefecture> getExamensPrefecture() {
		return examensPrefecture;
	}
	public void setExamensPrefecture(List<ExamenPrefecture> examensPrefecture) {
		this.examensPrefecture = examensPrefecture;
	}
	
	public TypeExamen() {
		
	}
}
