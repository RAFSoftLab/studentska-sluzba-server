package org.raflab.studsluzba.controllers;

import java.time.LocalDate;
import java.util.List;

import org.raflab.studsluzba.model.Ispit;
import org.raflab.studsluzba.model.PrijavaIspita;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.dtos.IspitPrijavaDTO;
import org.raflab.studsluzba.model.dtos.RezultatIspitaDTO;
import org.raflab.studsluzba.model.dtos.StudentIndeksPredispitneDTO;
import org.raflab.studsluzba.repositories.IspitRepository;
import org.raflab.studsluzba.repositories.PrijavaIspitaRepository;
import org.raflab.studsluzba.services.IspitService;
import org.raflab.studsluzba.services.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * rest kontroler za ispite da li ovde ukljuciti prijave ispita i izlaske na ispit
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/api/ispiti")
public class IspitiController {

		@Autowired
		IspitRepository ispitRepo;
		
		@Autowired
		PrijavaIspitaRepository prijavaIspitaRepo;
		
		@Autowired
		StudentProfileService studentProfileService;
		
		@Autowired
		IspitService ispitService;

		@GetMapping(path = "/all")
		public Iterable<Ispit> getAllIspit(){
			return ispitRepo.findAll();
		}
		
		@GetMapping(path = "/allforrok/{idIspitniRok}")
		public List<Ispit> getAllIspitForRok(@PathVariable Long idIspitniRok){
			return ispitRepo.getIspitiForIspitniRok(idIspitniRok);
		}
		
		@PostMapping(path = "/add")
		public Long addIspit(@RequestBody Ispit i) {
			ispitRepo.save(i);
			return i.getId();
		}

		/*
		 * brisanje ispita po id
		 */
		@DeleteMapping(path = "/{id}")
		public void deleteIspit(@PathVariable Long id) {
			ispitRepo.deleteById(id);
		}
		
		@GetMapping(path = "/dostupni-ispiti")
		public List<IspitPrijavaDTO> getDostupniIspiti(@RequestParam Long idStudIndeks, @RequestParam Long idIspitniRok){			
			return studentProfileService.getDustupniIspiti(idStudIndeks, idIspitniRok);
		}
		
		@PostMapping(path = "/prijavi")
		public boolean prijaviIspit(@RequestParam Long idStudIndeks, @RequestParam Long idIspit) {
			return ispitService.prijaviIspit(idStudIndeks, idIspit);
		}
		
		@PostMapping(path = "/prijava/add")
		public Long prijaviIspit(@RequestBody PrijavaIspita pi) {
			prijavaIspitaRepo.save(pi);
			return pi.getId();
		}
		
		@DeleteMapping(path = "/odjavi/{idPrijave}")
		public boolean odjaviPrijavuIspita(@PathVariable Long idPrijave) {
			return ispitService.odjaviPrijavuIspit(idPrijave);
		}
		
		@GetMapping(path = "/prijavljeni/{idIspita}")
		public List<StudentIndeks> getPrijavljeniZaIspit(@PathVariable Long idIspita){			
			return prijavaIspitaRepo.getPrijavljeniZaIspit(idIspita);
		}
		
		@GetMapping(path = "/neprijavljeni/{idIspita}")
		public List<StudentIndeks> getNeprijavljeniZaIspit(@PathVariable Long idIspita){			
			return ispitRepo.getNeprijavljeni(idIspita);
		}
		
		@GetMapping(path = "/{idNastavnik}/{idPredmet}/{idIspitniRok}")
		public Ispit getIspitForNastavnikPredmetIspitniRokAktivna(@PathVariable Long idNastavnik,@PathVariable Long idPredmet,@PathVariable Long idIspitniRok) {
			return ispitRepo.getIspitForNastavnikPredmetIspitniRokAktivna(idNastavnik, idPredmet, idIspitniRok);
		}
		
		@GetMapping(path = "/prijavljenisapredispitnim/{idIspita}")
		public List<StudentIndeksPredispitneDTO> getPrijavljeniSaPredispitnimZaIspit(@PathVariable Long idIspita){			
			return ispitService.getPrijavljeniSaPredispitnimZaIspit(idIspita);
		}
		
		@PostMapping(path = "/rezultati/add")
		public void saveRezultatiIspita(@RequestBody List<RezultatIspitaDTO> rezultati) {
			ispitService.saveRezultatiIspita(rezultati);
		}
		
}
