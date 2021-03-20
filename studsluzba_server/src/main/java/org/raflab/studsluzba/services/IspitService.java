package org.raflab.studsluzba.services;

import java.time.LocalDate;

import org.raflab.studsluzba.model.Ispit;
import org.raflab.studsluzba.model.PrijavaIspita;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.repositories.IspitRepository;
import org.raflab.studsluzba.repositories.PrijavaIspitaRepository;
import org.raflab.studsluzba.repositories.StudentIndeksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IspitService {
	
	@Autowired
	IspitRepository ispitRepo;
	
	@Autowired 
	PrijavaIspitaRepository prijavaIspitaRepo;
	
	@Autowired
	StudentIndeksRepository studentIndeksRepo;
	
	
	public boolean prijaviIspit(Long idStudIndeks, Long idIspit) {	
		try {
			StudentIndeks si = studentIndeksRepo.findById(idStudIndeks).get();
			Ispit i = ispitRepo.findById(idIspit).get();
			PrijavaIspita pi = new PrijavaIspita();
			pi.setDatumPrijave(LocalDate.now());
			pi.setStudentIndeks(si);
			pi.setIspit(i);
			prijavaIspitaRepo.save(pi);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean odjaviPrijavuIspta(Long idPrjave) {
		try {
			prijavaIspitaRepo.deleteById(idPrjave);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

}
