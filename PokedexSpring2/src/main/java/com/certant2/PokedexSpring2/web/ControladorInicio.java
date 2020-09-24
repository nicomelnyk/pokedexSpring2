package com.certant2.PokedexSpring2.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.certant2.PokedexSpring2.domain.Pokemon;
import com.certant2.PokedexSpring2.servicio.PokemonService;

import lombok.extern.slf4j.Slf4j;

//@RestController // SPRING
@Controller // Thymeleaf
@Slf4j //Manejo de login
public class ControladorInicio {
	
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping("/")
	public String inicio(Model model) {
		
		var pokemones = pokemonService.listarPokemones();
		
		model.addAttribute("pokemones", pokemones);
		
		return "index";
	}
	
	@GetMapping("/agregar")
	public String agregar(Pokemon pokemon) {
		return "modificar";
	}
	
	@PostMapping("/guardar")
	public String guardar(Pokemon pokemon) {
		pokemonService.guardar(pokemon);
		return "redirect:/";
	}
	
	@GetMapping("/editar/{idpokemon}")
	public String editar(Pokemon pokemon, Model model) {
		pokemon = pokemonService.encontrarPokemon(pokemon);
		model.addAttribute("pokemon", pokemon);
		return "modificar";
	}
	
	@GetMapping("/eliminar/{idpokemon}")
	public String eliminar(Pokemon pokemon, Model model) {
		pokemonService.eliminar(pokemon);
		return "redirect:/";
	}
}