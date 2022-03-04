package com.example.novi.ncmdb;

import com.example.novi.ncmdb.domain.Coureur;
import com.example.novi.ncmdb.repository.CoureurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NcmdbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(NcmdbApplication.class, args);
		CoureurRepository coureurRepository =
				configurableApplicationContext.getBean(CoureurRepository.class);

		NcmdbApplication app = new NcmdbApplication();
		List<Coureur> coureurs= app.getCoureurList();

		coureurRepository.saveAll(coureurs);

	}

	private List<Coureur> getCoureurList(){

		List<Coureur> coureurs = new ArrayList<>();

		coureurs.add(new Coureur("Alexander Albon", 1));
		coureurs.add(new Coureur("Fernando Alonso", 1));
		coureurs.add(new Coureur("Valtteri Bottas", 1));
		coureurs.add(new Coureur("Pierre Gasly", 1));
		coureurs.add(new Coureur("Lewis Hamilton", 1));
		coureurs.add(new Coureur("Nicholas Latifi", 1));
		coureurs.add(new Coureur("Charles Leclerc", 1));
		coureurs.add(new Coureur("Nikita Mazepin", 1));
		coureurs.add(new Coureur("Lando Norris", 1));
		coureurs.add(new Coureur("Esteban Ocon", 1));
		coureurs.add(new Coureur("Sergio Pérez", 1));
		coureurs.add(new Coureur("Daniel Ricciardo", 1));
		coureurs.add(new Coureur("George Russell", 1));
		coureurs.add(new Coureur("Carlos Sainz jr.", 1));
		coureurs.add(new Coureur("Mick Schumacher", 1));
		coureurs.add(new Coureur("Yuki Tsunoda", 1));
		coureurs.add(new Coureur("Lance Stroll", 1));
		coureurs.add(new Coureur("Max Verstappen", 1));
		coureurs.add(new Coureur("Sebastian Vettel", 1));
		coureurs.add(new Coureur("Guanyu Zhou", 1));

		return coureurs;
	}

}
