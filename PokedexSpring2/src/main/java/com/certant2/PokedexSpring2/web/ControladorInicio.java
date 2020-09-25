package com.certant2.PokedexSpring2.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.certant2.PokedexSpring2.domain.Evolutions;
import com.certant2.PokedexSpring2.domain.Pokemon;
import com.certant2.PokedexSpring2.domain.PokemonType;
import com.certant2.PokedexSpring2.mapper.PokemonMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
	
	private PokemonMapper pokemonMapper;
	
	public ControladorInicio(PokemonMapper pokemonMapper) {
		this.pokemonMapper = pokemonMapper;
	}
	
	@GetMapping("/")
	public String getAll(Model model){
		var pokemones =  pokemonMapper.findAllPokemones();
		model.addAttribute("pokemones", pokemones);
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Pokemon pokemon) {
		return "crearPokemon";
	}
	
	@PostMapping("/guardar")
	public String guardar(Pokemon pokemon) {
		pokemonMapper.agregarPokemon(pokemon);
		return "redirect:/";
	}
	
	@GetMapping("/actualizar/{idpokemon}")
	public String actualizar(Pokemon pokemon) {
		return "editarPokemon";
	}
	
	@PostMapping("/actualizar/validar")
	public String validarActualizacion(Pokemon pokemon) {
		pokemonMapper.actualizar(pokemon);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{idpokemon}")
	public String editar(Pokemon pokemon, Model model) {
		pokemon = pokemonMapper.encontrarPokemon(pokemon);
		model.addAttribute("pokemon", pokemon);
		return "editarPokemon";
	}
	
	@GetMapping("/visualizarEvoluciones")
	public String visualizarEvoluciones(Model model) {
		var evoluciones =  pokemonMapper.findAllEvoluciones();
		model.addAttribute("evoluciones", evoluciones);
		return "listadoEvoluciones";
	}
	
	@GetMapping("/visualizarEvoluciones/mostrarTipos/{idevolutions}")
	public String eliminar(Evolutions evolutions, Model model) {
		var tipos = pokemonMapper.encontrarEvolutionTypesDe(evolutions);
		model.addAttribute("tipos", tipos);
		return "listadoTiposEvolucion";
	}
	
	@GetMapping("/infoTiposPokemon/{idpokemon}")
	public String infoTiposPokemon(Pokemon pokemon, Model model) {
		var tipos = pokemonMapper.encontrarTiposDe(pokemon);
		var tiposdisponibles = pokemonMapper.findAllPokemontypes();
		model.addAttribute("pokemon", pokemon);
		model.addAttribute("tipos", tipos);
		model.addAttribute("tiposdisponibles", tiposdisponibles);
		return "infoTiposPokemon";
	}
	
	@GetMapping("/infoTiposPokemon/{idpokemontype}&{idpokemontype}")
	public String agregarTipoPokemon(Pokemon pokemon, PokemonType pokemontype, Model model) {
		System.out.print(pokemon.getNombre());
		pokemonMapper.addPokemonTypeTo(pokemon, pokemontype);
		return "infoTiposPokemon";
	}
	
	@PostMapping("/removerTipo/{idpokemontype}")
	public String removerTipoPokemon(Pokemon pokemon, PokemonType pokemontype, Model model) {
		pokemonMapper.removePokemonTypeTo(pokemon, pokemontype);
		return "infoTiposPokemon";
	}
	
	@GetMapping("/infoEvolucionesPokemon?{idpokemon}")
	public String infoEvolucionesPokemon(Pokemon pokemon, Model model) {
		var evoluciones = pokemonMapper.encontrarEvolucionesDe(pokemon);
		model.addAttribute("evoluciones", evoluciones);
		return "infoEvolucionesPokemon";
	}
	
	@GetMapping("/infoHabilidades/{idpokemon}")
	public String infoHabilidades(Pokemon pokemon, Model model) {
		var habilidades = pokemonMapper.encontrarHabilidadesDe(pokemon);
		model.addAttribute("habilidades", habilidades);
		return "infoHabilidades";
	}
	
}