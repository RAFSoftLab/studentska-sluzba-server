package org.raflab.studsluzba.controllers;

import org.raflab.studsluzba.model.NastavnaNaucnaZvanja;
import org.raflab.studsluzba.model.StudijskiProgram;
import org.raflab.studsluzba.repositories.NastavnaNaucnaZvanjaRepository;
import org.raflab.studsluzba.repositories.StudijskiProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/coder")
public class SifarniciController {
	
	@Autowired
	NastavnaNaucnaZvanjaRepository zvanjaRepository;
	
	@Autowired
	StudijskiProgramRepository studProgramRepository;
	
	@GetMapping(path="/zvanja/all")
    public Iterable<NastavnaNaucnaZvanja> getAllZvanja() {      
      return zvanjaRepository.findAll();
    }
	
	@GetMapping(path="/studprogram/all")
    public Iterable<StudijskiProgram> getAllStudProgrami() {      
      return studProgramRepository.findAll();
    }

}
