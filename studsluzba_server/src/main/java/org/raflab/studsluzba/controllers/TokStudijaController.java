package org.raflab.studsluzba.controllers;

import org.raflab.studsluzba.model.ObnovaGodine;
import org.raflab.studsluzba.model.UpisGodine;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.UpisGodineRepository;
import org.raflab.studsluzba.repositories.UplataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * funkcije za snimanje i preuzimanje upisa, obnova, uplata
 * 
 */


@RestController
@RequestMapping(path="/tok")
public class TokStudijaController {
	
	@Autowired
	UpisGodineRepository upisGodineRepo;
	
	
	@Autowired
	ObnovaGodineRepository obnovaGodineRepo;
	
	@Autowired
	UplataRepository uplataRepository;
	
	@PostMapping(path="/upis/add")
	public Long addNewUpis(@RequestBody UpisGodine upis) {
		UpisGodine u = upisGodineRepo.save(upis);
		// TODO da li ovde dodati predmete koje slusa? predmete iz godine koju upisuje i predmete koje prenosi?
		return u.getId();
		
	}
	
	@PostMapping(path="/obnova/add")
	public Long addNewObnova(@RequestBody ObnovaGodine obnova) {
		ObnovaGodine o = obnovaGodineRepo.save(obnova);
		// TODO da li ovde dodati predmete koje slusa? predmete iz godine koju upisuje i predmete koje prenosi?
		return o.getId();
		
	}
	
	
	
	
	
	
	
		
}
