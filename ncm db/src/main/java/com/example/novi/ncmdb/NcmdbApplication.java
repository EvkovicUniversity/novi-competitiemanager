package com.example.novi.ncmdb;

import com.example.novi.ncmdb.domain.Formula1.Coureur;
import com.example.novi.ncmdb.domain.Formula1.F1Competitie;
import com.example.novi.ncmdb.repository.f1repositories.CompetitieRepository;
import com.example.novi.ncmdb.repository.f1repositories.CoureurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NcmdbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(NcmdbApplication.class, args);

		CoureurRepository coureurRepository =
				configurableApplicationContext.getBean(CoureurRepository.class);
		CompetitieRepository competitieRepository =
				configurableApplicationContext.getBean(CompetitieRepository.class);

		NcmdbApplication app = new NcmdbApplication();
		List<Coureur> coureurs= app.getCoureurList();
		List<F1Competitie> competities = app.getCompetities();

		coureurRepository.saveAll(coureurs);
		competitieRepository.saveAll(competities);

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

	private List<F1Competitie> getCompetities(){
		List<F1Competitie> competities = new ArrayList<>();
		LocalDateTime tijdnu = LocalDateTime.now();

		competities.add(new F1Competitie("OTS Competitie", "123", tijdnu, 5, 1, "dag"));
		competities.add(new F1Competitie("Vrouwen Competitie", "123", tijdnu, 5, 1, "dag"));
		competities.add(new F1Competitie("RTL 7 Live", "123", tijdnu, 5, 1, "dag"));
		competities.add(new F1Competitie("Evan's Competitie", "123", tijdnu, 5, 1, "dag"));
		competities.add(new F1Competitie("Competitie 5", "123", tijdnu, 5, 1, "dag"));
		competities.add(new F1Competitie("Competitie 6", "123", tijdnu, 5, 1, "dag"));

		return competities;
	}

}
