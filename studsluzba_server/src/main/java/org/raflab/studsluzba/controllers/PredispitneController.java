package org.raflab.studsluzba.controllers;

import java.util.List;

import org.raflab.studsluzba.model.OsvojeniPoeniPredispitne;
import org.raflab.studsluzba.model.PredispitnaObaveza;
import org.raflab.studsluzba.model.dtos.OsvojeniPoeniPredispitneDTO;
import org.raflab.studsluzba.model.dtos.PredispitnaObavezaDTO;
import org.raflab.studsluzba.repositories.OsvojeniPoeniPredispitneRepository;
import org.raflab.studsluzba.repositories.PredispitnaObavezaRepository;
import org.raflab.studsluzba.services.PredispitneService;
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

@CrossOrigin
@RestController
@RequestMapping(path = "/api/predispitne")
public class PredispitneController {
	
	@Autowired
	PredispitnaObavezaRepository predispitnaObavezaRepo;
	
	@Autowired
	PredispitneService predispitneService;
	
	@Autowired
	OsvojeniPoeniPredispitneRepository osvojeniPoeniPredispitneRepo;
	
	@GetMapping(path = "/struktura/{idNastavnik}/{idPredmet}")
	public List<PredispitnaObavezaDTO> getPredispitneForNastavnikPredmetAktivna(@PathVariable Long idNastavnik, @PathVariable Long idPredmet){
		return predispitneService.getPredispitneDTOForNastavnikPredmetAktivnaGodina(idNastavnik, idPredmet);
	}
	
	@DeleteMapping(path = "/struktura/{idPredispitna}")
	public boolean deletePredispitna(@PathVariable Long idPredispitna) {
		try {
			predispitnaObavezaRepo.deleteById(idPredispitna);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	@PostMapping(path = "/struktura/add/{idNastavnik}/{idPredmet}")
	public Long addPredispitna(@PathVariable Long idNastavnik, @PathVariable Long idPredmet, @RequestParam String naziv, @RequestParam Integer maxBr) {
		return predispitneService.savePredispitne(idPredmet, idNastavnik, naziv, maxBr);
	}
	
	/*
	 * vraca sve osvojene poene predispitnih na svim predmetima za nastavnika i predmet u aktivnoj skolskoj godini
	 */
	
	@GetMapping(path = "/osvojenipoeni/{idNastavnik}/{idPredmet}")
	public List<OsvojeniPoeniPredispitne> getOsvojeniPoeniPredispitneForNastavnikPredmetAktivna(@PathVariable Long idNastavnik, @PathVariable Long idPredmet){
		return osvojeniPoeniPredispitneRepo.getOsvojeniPoeniZaNastavnikPredmetAktivna(idNastavnik, idPredmet);
	}
	
	@GetMapping(path = "/osvojenipoenishort/{idNastavnik}/{idPredmet}")
	public List<OsvojeniPoeniPredispitneDTO> getOsvojeniPoeniPredispitneForNastavnikPredmetAktivnaShort(@PathVariable Long idNastavnik, @PathVariable Long idPredmet){
		return predispitneService.getOsvojeniPoeniPredispitneDTOForNastavnikPredmetAktivna(idNastavnik, idPredmet);
	}
	
	@PostMapping(path = "/osvojenipoenishort/add" )
	public void saveOsvojeniPoeniPredispitne(@RequestBody List<OsvojeniPoeniPredispitneDTO> poeni) {
		predispitneService.sacuvajOsvojeniPoenipredispitne(poeni);
	}
	
	
	
	
}
