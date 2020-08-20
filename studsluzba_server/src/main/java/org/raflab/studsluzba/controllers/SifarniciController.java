package org.raflab.studsluzba.controllers;

import org.raflab.studsluzba.model.NastavnaNaucnaZvanja;
import org.raflab.studsluzba.model.SrednjaSkola;
import org.raflab.studsluzba.model.StudentPodaci;
import org.raflab.studsluzba.model.StudijskiProgram;
import org.raflab.studsluzba.repositories.NastavnaNaucnaZvanjaRepository;
import org.raflab.studsluzba.repositories.SrednjaSkolaRepository;
import org.raflab.studsluzba.repositories.StudijskiProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/coder")
public class SifarniciController {
	
	@Autowired
	NastavnaNaucnaZvanjaRepository zvanjaRepository;
	
	@Autowired
	StudijskiProgramRepository studProgramRepository;
	
	@Autowired
	SrednjaSkolaRepository srednjeSkoleRepository;
	
	@GetMapping(path="/zvanje/all")
    public Iterable<NastavnaNaucnaZvanja> getAllZvanja() {      
      return zvanjaRepository.findAll();
    }
	
	@GetMapping(path="/studprogram/oznaka/all")
    public Iterable<String> getAllStudProgramOznaka() {      
      return studProgramRepository.findAllOznaka();
    }
	
	@GetMapping(path="/srednjaskola/all")
    public Iterable<SrednjaSkola> getAllSrednjaSkola() {      
      return srednjeSkoleRepository.findAll();
    }
	
	 @PostMapping(path="/srednjaskola/add") 
	 public Long addSrednjaSkola (@RequestBody SrednjaSkola srednjaSkola) {	    	
	  	    SrednjaSkola sp = srednjeSkoleRepository.save(srednjaSkola);   	   	    
	   	    return sp.getId();
	   	 }

}
