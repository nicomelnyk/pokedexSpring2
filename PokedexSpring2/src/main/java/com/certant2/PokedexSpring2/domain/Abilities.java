package com.certant2.PokedexSpring2.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="abilities")
public class Abilities implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idabilities")
	private Long idabilities;
	
	public Long getidabilities(){
		return idabilities;
	}
	
	public Long getId() {
		return serialVersionUID;
	}
	
	private String nombre;

	public Abilities() {
	}

	public Abilities(String name) {
		this.nombre = name;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getData() {
		return " - Ability Name: " + this.nombre;
	}
}