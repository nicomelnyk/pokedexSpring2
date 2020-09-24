package com.certant2.PokedexSpring2.dao;

import org.springframework.data.repository.CrudRepository;

import com.certant2.PokedexSpring2.domain.Pokemon;

public interface PokemonDao extends CrudRepository<Pokemon, Long>{
	
}