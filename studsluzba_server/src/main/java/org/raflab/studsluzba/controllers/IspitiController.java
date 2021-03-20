package org.raflab.studsluzba.controllers;

import java.time.LocalDate;
import java.util.List;

import org.raflab.studsluzba.model.Ispit;
import org.raflab.studsluzba.model.IspitniRok;
import org.raflab.studsluzba.model.dtos.IspitPrijavaDTO;
import org.raflab.studsluzba.repositories.IspitRepository;
import org.raflab.studsluzba.repositories.IspitniRokRepository;
import org.raflab.studsluzba.services.IspitService;
import org.raflab.studsluzba.services.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
 * rest kontroler za ispite i ispitne rokove, da li ovde ukljuciti prijave ispita i izlaske na ispit 
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/ispiti")
public class IspitiController {
	
		@Autowired
		IspitniRokRepository ispitniRokRepo;
		
		@Autowired
		IspitRepository ispitRepo;
		
		@Autowired
		StudentProfileService studentProfileService;
		
		@Autowired
		IspitService ispitService;
		
		@GetMapping(path = "/ispitnirok/all")
		public Iterable<IspitniRok> getAllIspitniRok(){
			return ispitniRokRepo.findAll();
		}
		
		@GetMapping(path = "/ispitnirok/aktivna/all")
		public List<IspitniRok> getAllIspitniRokForAktivnaSkolskaGodina(){
			return ispitniRokRepo.getIspitniRokoviForAktivnaSkolsaGodina();
		}
		
		@PostMapping(path = "/ispitnirok/add")
		public Long addIspitniRok(@RequestBody IspitniRok ir) {
			ispitniRokRepo.save(ir);
			return ir.getId();
		}
		
		/*
		 * vraca sve ispite
		 */
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
		
		@DeleteMapping(path = "/ispitnirok/{id}")
		public void deleteIspitniRok(@PathVariable Long id) {
			ispitniRokRepo.deleteById(id);
		}
		
		/*
		 * brisanje ispita po id
		 */
		@DeleteMapping(path = "/{id}")
		public void deleteIspit(@PathVariable Long id) {
			ispitRepo.deleteById(id);
		}
		
		@GetMapping(path = "/aktivni-ispitni-rokovi")
		public List<IspitniRok> getAktivniIspitniRokovi(){			
			return ispitniRokRepo.getAktivniIspitniRokovi();
		}
		
		@GetMapping(path = "/dostupni-ispiti")
		public List<IspitPrijavaDTO> getDostupniIspiti(@RequestParam Long idStudIndeks, @RequestParam Long idIspitniRok){			
			return studentProfileService.getDustupniIspiti(idStudIndeks, idIspitniRok);
		}
		
		@PostMapping(path = "/prijavi")
		public boolean prijaviIspit(@RequestParam Long idStudIndeks, @RequestParam Long idIspit) {
			return ispitService.prijaviIspit(idStudIndeks, idIspit);
		}
		
		@DeleteMapping(path = "/odjavi/{idPrijave}")
		public boolean odjaviPrijavuIspita(@PathVariable Long idPrijave) {
			return ispitService.odjaviPrijavuIspta(idPrijave);
		}
		
}
