package com.certant2.PokedexSpring2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="evolutions")
public class Evolutions implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idevolutions")
	private Long idevolutions;
	
	public void idevolutions(Long nuevoid) {
		this.idevolutions = nuevoid;
	}
	
	public Long getidevolutions(){
		return idevolutions;
	}
	
	public Long getId() {
		return serialVersionUID;
	}
	
	private String nombre;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<EvolutionType> evolutiontype = new HashSet<EvolutionType>();
	
	private Integer nivel;
	
	public Evolutions() {
	}

	public Evolutions(String name, Set<EvolutionType> evolutionType, Integer level) {
		this.nombre = name;
		this.evolutiontype = evolutionType;
		this.nivel = level;
	}
	
	public String getData() {
		return " - Evolution Name: " + this.nombre + "; Type/s: " + this.getTypeData() + "; Level on which Pokemon evolves to that evolution: " + this.nivel;
	}
	
	public String getTypeData() {
		Collection<String> lista = new ArrayList<String>();
		evolutiontype.forEach(type->lista.add(type.getNombre()));
		String retorno = lista.toString();
		return retorno;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Set<EvolutionType> getEvolutionType() {
		return evolutiontype;
	}
	
	public Integer getNivel() {
		return nivel;
	}
	
	public Boolean puedeAccederUnPokemon(Integer nivelPokemon) {
		return nivelPokemon >= nivel;
	}
}
