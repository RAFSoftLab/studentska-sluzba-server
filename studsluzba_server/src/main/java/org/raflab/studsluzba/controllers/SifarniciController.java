package org.raflab.studsluzba.controllers;

import org.raflab.studsluzba.model.NastavnaNaucnaZvanja;
import org.raflab.studsluzba.repositories.NastavnaNaucnaZvanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/coder")
public class SifarniciController {
	
	@Autowired
	NastavnaNaucnaZvanjaRepository zvanjaRepository;
	
	@GetMapping(path="/zvanja/all")
    public Iterable<NastavnaNaucnaZvanja> getAllStudentPodaci() {      
      return zvanjaRepository.findAll();
    }

}
