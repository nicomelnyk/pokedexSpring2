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
@Table(name="evolutiontype")
public class EvolutionType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idevolutiontype")
	private Long idevolutiontype;
	
	public Long getidevolutiontype() {
		return idevolutiontype;
	}
	
	public Long getId() {
		return serialVersionUID;
	}
	
	private String nombre;
	
	public EvolutionType() {
	}
	
	public EvolutionType(String name) {
		this.nombre = name;
	}
	
	public String getNombre() {
		return nombre;
	}
}
