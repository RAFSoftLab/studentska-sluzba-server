package org.raflab.studsluzba.controllers;

import org.raflab.studsluzba.model.SkolskaGodina;
import org.raflab.studsluzba.repositories.SkolskaGodinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Kontroler preko koga se povlace razne admin stvari, na primer aktivna skolska godina
 * 
 */
@CrossOrigin
@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {
	
	@Autowired
	SkolskaGodinaRepository skolskaGodinaRepo;
	
	@GetMapping(path = "/skolskagodina/aktivna")
	public SkolskaGodina getAktivnaSkolskaGodina() {
		return skolskaGodinaRepo.getAktivnaSkolskaGodina();
	}
	
	@GetMapping(path = "/skolskagodina/all")
	public Iterable<SkolskaGodina> getSveSkolskeGodine(){
		return skolskaGodinaRepo.findAll();		
	}
	
	@PostMapping(path="/skolskagodina/add") 
	public Long addAktivnaSkolskaGodina(@RequestBody SkolskaGodina sk) {
		if(sk.isAktivna()) {
			// za sve druge postavimo aktivna na false
			Iterable<SkolskaGodina> sveSkolskeGodine = skolskaGodinaRepo.findAll();
			for(SkolskaGodina s: sveSkolskeGodine) {
				s.setAktivna(false);
				skolskaGodinaRepo.save(s);
			}		
		}
		SkolskaGodina s = skolskaGodinaRepo.save(sk);
		return s.getId();		
	}
	
	
	/*
	 * ne koristi se, moze Post da se zove i azurira se ako ima id
	 */
	
	@PutMapping(path = "/skolskagodina/update")
	public void updateSkolskaGodina(@RequestBody SkolskaGodina sk) {	
		if(sk.isAktivna()) {
			// za sve druge postavimo aktivna na false
			Iterable<SkolskaGodina> sveSkolskeGodine = skolskaGodinaRepo.findAll();
			for(SkolskaGodina s: sveSkolskeGodine) {
				if(s.getId()!=sk.getId()) {
					s.setAktivna(false);
					skolskaGodinaRepo.save(s);
				}
			}		
		}
		skolskaGodinaRepo.save(sk);
	}

}
