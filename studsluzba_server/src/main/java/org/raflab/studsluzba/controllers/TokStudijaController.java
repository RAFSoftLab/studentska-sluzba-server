package org.raflab.studsluzba.controllers;

import org.raflab.studsluzba.controllers.request.ObnovaGodineInitRequest;
import org.raflab.studsluzba.controllers.request.ObnovaGodineRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineInitRequest;
import org.raflab.studsluzba.controllers.request.UpisGodineRequest;
import org.raflab.studsluzba.controllers.response.ObnovaGodineInitResponse;
import org.raflab.studsluzba.controllers.response.UpisGodineInitResponse;
import org.raflab.studsluzba.repositories.UplataRepository;
import org.raflab.studsluzba.services.TokStudijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * funkcije za snimanje i preuzimanje upisa, obnova, uplata
 * 
 */


@RestController
@RequestMapping(path="/tok")
@CrossOrigin
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

	@PostMapping(path="/upis/init")
	public UpisGodineInitResponse initUpis(@RequestBody UpisGodineInitRequest request) {

		return tokStudijaService.initUpis(request);
	}

	@PostMapping(path="/obnova/init")
	public ObnovaGodineInitResponse initObnova(@RequestBody ObnovaGodineInitRequest request) {

		return tokStudijaService.initObnovaGodine(request);

	}
}
