package com.certant2.PokedexSpring2.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certant2.PokedexSpring2.dao.PokemonDao;
import com.certant2.PokedexSpring2.domain.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {

	@Autowired
	private PokemonDao pokemonDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pokemon> listarPokemones() {
		return (List<Pokemon>) pokemonDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Pokemon pokemon) {
		pokemonDao.save(pokemon);
	}

	@Override
	@Transactional
	public void eliminar(Pokemon pokemon) {
		pokemonDao.delete(pokemon);
	}

	@Override
	@Transactional(readOnly = true)
	public Pokemon encontrarPokemon(Pokemon pokemon) {
		return pokemonDao.findById(pokemon.getidpokemon()).orElse(null); // manejar luego una excepcion
	}
	
}
