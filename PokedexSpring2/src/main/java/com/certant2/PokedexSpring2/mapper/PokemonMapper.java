package com.certant2.PokedexSpring2.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.certant2.PokedexSpring2.domain.Abilities;
import com.certant2.PokedexSpring2.domain.Evolutions;
import com.certant2.PokedexSpring2.domain.Pokemon;
import com.certant2.PokedexSpring2.domain.PokemonType;

@Mapper
public interface PokemonMapper {
	
	@Select("select * from pokemon")
	List<Pokemon> findAllPokemones();
	
	@Select("select * from evolutions")
	List<Evolutions> findAllEvoluciones();
	
	@Select("select * from pokemontype")
	List<PokemonType> findAllPokemontypes();
	
	@Select("select * from abilities")
	List<Abilities> findAllHabilidades();
	
	@Select("select * from pokemon where idpokemon=#{idpokemon}")
	Pokemon encontrarPokemon(Pokemon pokemon);
	
	@Insert("insert into pokemon(nombre,nivel) values(#{nombre},#{nivel})")
	@SelectKey(statement =  "SELECT LAST_INSERT_ID()", keyProperty = "idpokemon",
			before = false, resultType = Pokemon.class)
	void agregarPokemon(Pokemon pokemon);

	@Select("select pt.nombre from pokemon p join pokemon_pokemontype ppt join pokemontype pt where p.idpokemon = ppt.idpokemon and pt.idpokemontype = ppt.idpokemontype and p.idpokemon = #{idpokemon}")
	List<String> encontrarTiposDe(Pokemon pokemon);

	@Select("select e.nombre from pokemon p join pokemon_evolutions pe join evolutions e where p.idpokemon = pe.idpokemon and e.idevolutions = pe.idevolutions and p.idpokemon = #{idpokemon}")
	List<String> encontrarEvolucionesDe(Pokemon pokemon);

	@Select("select a.nombre from pokemon p join pokemon_abilities pa join abilities a where p.idpokemon = pa.idpokemon and pa.idabilities = a.idabilities and p.idpokemon = #{idpokemon}")
	List<String> encontrarHabilidadesDe(Pokemon pokemon);	
	
	@Select("select et.nombre from evolutions e join evolutiontype et join evolutions_evolutiontype eet where eet.idevolutions = e.idevolutions and eet.idevolutiontype = et.idevolutiontype and e.idevolutions = #{idevolutions}")
	List<String> encontrarEvolutionTypesDe(Evolutions evolution);
	
	@Update("update pokemon set nombre=#{nombre}, nivel=#{nivel} where idpokemon=#{idpokemon}")
	void actualizar(Pokemon pokemon);

	@Insert("insert into pokemon_pokemontype values(#{idpokemon},#{idpokemontype})")
	void addPokemonTypeTo(Pokemon pokemon, PokemonType pokemontype);

	void removePokemonTypeTo(Pokemon pokemon, PokemonType pokemontype);
}
