package com.certant2.PokedexSpring2;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.certant2.PokedexSpring2.domain.Pokemon;

@MappedTypes(Pokemon.class)
@MapperScan("com.certant2.PokedexSpring2.mapper")
@SpringBootApplication
public class PokedexSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(PokedexSpring2Application.class, args);
	}

}