package org.raflab.studsluzba.controllers;

import org.raflab.studsluzba.controllers.request.ObnovaGodineRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineRequest;
import org.raflab.studsluzba.model.ObnovaGodine;
import org.raflab.studsluzba.model.UpisGodine;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.UpisGodineRepository;
import org.raflab.studsluzba.repositories.UplataRepository;
import org.raflab.studsluzba.services.TokStudijaService;
import org.raflab.studsluzba.utils.Converters;
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
	TokStudijaService tokStudijaService;
	
	@Autowired
	UplataRepository uplataRepository;
	
	@PostMapping(path="/upis/add")
	public Long addNewUpis(@RequestBody UpisGodineRequest request) {

		return tokStudijaService.addUpis(request);
	}
	
	@PostMapping(path="/obnova/add")
	public Long addNewObnova(@RequestBody ObnovaGodineRequest request) {

		return tokStudijaService.addObnovaGodine(request);
		
	}
}
