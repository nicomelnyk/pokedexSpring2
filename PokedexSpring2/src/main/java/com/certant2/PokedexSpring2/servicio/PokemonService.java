package com.certant2.PokedexSpring2.servicio;

import java.util.List;

import com.certant2.PokedexSpring2.domain.Pokemon;

public interface PokemonService {
	public List<Pokemon> listarPokemones();
	
	public void guardar(Pokemon pokemon);
	
	public void eliminar(Pokemon pokemon);
	
	public Pokemon encontrarPokemon(Pokemon pokemon);
}
