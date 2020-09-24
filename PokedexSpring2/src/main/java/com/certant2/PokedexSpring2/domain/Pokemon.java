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
@Table(name="pokemon")
public class Pokemon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpokemon")
	private Long idpokemon;
	
	public Long getId() {
		return serialVersionUID;
	}
	
	private String nombre;
	
	private Integer nivel;
	
	public Pokemon() {
		
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<PokemonType> pokemontype = new HashSet<PokemonType>();
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Abilities> abilities = new HashSet<Abilities>();
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Evolutions> evolutions = new HashSet<Evolutions>();
	
	public Pokemon(String name, Set<PokemonType> pokemonType, Integer level, Set<Abilities> abilities, Set<Evolutions> evolutions) {
		this.nombre = name;
		this.pokemontype = pokemonType;
		this.nivel = level;
		this.abilities = abilities;
		this.evolutions = evolutions;
	}
	
	public void setidpokemon(Long nuevoid) {
		this.idpokemon = nuevoid;
	}
	
	public void setNivel(Integer nuevoNivel) {
		this.nivel = nuevoNivel;
	}
	
	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}
	
	public Long getidpokemon(){
		return idpokemon;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Integer getNivel() {
		return nivel;
	}
	
	public String getData() {
		return " - Pokemon Name: " + this.nombre + "; Type/s: " + this.getTypeData() + "; Level: " + this.nivel;
	}
	
	public String getTypeData() {
		Collection<String> lista = new ArrayList<String>();
		pokemontype.forEach(type->lista.add(type.getNombre()));
		String retorno = lista.toString();
		return retorno;
	}
	
	public void addType(PokemonType type) {
		this.pokemontype.add(type);
	}
	
	public void addEvolution(Evolutions evolution) {
		this.evolutions.add(evolution);
	}
	
	public void removeType(PokemonType type) {
		this.pokemontype.remove(type);
	}
	
	public String getPokemonType() {
		return pokemontype.toString();
	}
	
	public Integer getLevel() {
		return nivel;
	}
	
	public Set<Abilities> getAbilities() {
		return abilities;
	}
	
	public Set<Evolutions> getEvolutions() {
		return evolutions;
	}
	
	public Set<PokemonType> getPokemonTypes() {
		return pokemontype;
	}
	
	public Boolean tieneNivelMayorIgualA(Integer unNivel) {
		return unNivel >= this.nivel;
	}
}