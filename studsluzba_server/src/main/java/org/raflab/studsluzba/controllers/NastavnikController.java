package org.raflab.studsluzba.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.raflab.studsluzba.model.Nastavnik;
import org.raflab.studsluzba.repositories.NastavnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/nastavnik")
public class NastavnikController {

	@Autowired
	NastavnikRepository nastavnikRepository;
	
	@PostMapping(path = "/add")
	public String addNewNastavnik(@RequestBody Nastavnik nastavnik) {
		System.out.println("Nastavnik " + nastavnik.getPrezime() + " je uspešno sačuvan");
		nastavnikRepository.save(nastavnik);
		return "Nastavnik sačuvan";
	}
	
	@GetMapping(path = "/all")
	public Iterable<Nastavnik> getAllNastavnik(){
		return nastavnikRepository.findAll();
	}

	@GetMapping(path = "/nastavnik")
	public Nastavnik getNastavnik(@RequestParam Long id) {
		Optional<Nastavnik> rez = nastavnikRepository.findById(id);
		if(rez.isEmpty())
			return null;
		return rez.get();
	}
	
	@GetMapping(path = "/search")
	public List<Nastavnik> search(@RequestParam(required = false) String ime,
									@RequestParam(required = false) String prezime){
		List<Nastavnik> retVal = nastavnikRepository.findNastavnik(ime, prezime);
		return retVal;
	}
	
}
