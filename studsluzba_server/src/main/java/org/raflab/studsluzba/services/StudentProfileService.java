package org.raflab.studsluzba.services;

import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.dtos.StudentProfileDTO;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.PolozenPredmetRepository;
import org.raflab.studsluzba.repositories.PrijavaIspitaRepository;
import org.raflab.studsluzba.repositories.SlusaPredmetRepository;
import org.raflab.studsluzba.repositories.StudentIndeksRepository;
import org.raflab.studsluzba.repositories.StudentPodaciRepository;
import org.raflab.studsluzba.repositories.UpisGodineRepository;
import org.raflab.studsluzba.repositories.UplataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileService {
	
	
	@Autowired
	PolozenPredmetRepository polozeniPredmetRepo;
	
	@Autowired
	StudentIndeksRepository studentIndeksRepo;
	
	@Autowired
	StudentPodaciRepository studentPodaciRepo;
	
	@Autowired
	UpisGodineRepository upisGodineRepo;
	
	@Autowired
	ObnovaGodineRepository obnovaGodineRepo;
	
	@Autowired
	UplataRepository uplataRepo;
	
	@Autowired
	PrijavaIspitaRepository prijavaIspitaRepo;
	
	@Autowired
	SlusaPredmetRepository slusaPredmetRepo;
	
	
	public StudentProfileDTO getStudentProfile(Long indeksId) {
		StudentProfileDTO retVal = new StudentProfileDTO();
		StudentIndeks studIndeks = studentIndeksRepo.findById(indeksId).get();
		Long studPodaciId = studIndeks.getStudent().getId();
		retVal.setAktivanIndeks(studentPodaciRepo.getAktivanIndeks(studPodaciId));
		retVal.setNeaktivniIndeksi(studentPodaciRepo.getNeaktivniIndeksi(studPodaciId));		
		retVal.setPolozeniPredmeti(polozeniPredmetRepo.getPolozeniPredmetForIndeks(indeksId));
		retVal.setUpisiGodine(upisGodineRepo.getUpisiForIndeks(indeksId));
		retVal.setObnoveGodine(obnovaGodineRepo.getObnoveForIndeks(indeksId));
		retVal.setUplate(uplataRepo.getUplateForIndeks(indeksId));
		retVal.setPrijaveIspita(prijavaIspitaRepo.getPrijaveIspitaForIndeksAktivnaGodina(indeksId));	
		retVal.setSlusaPredmete(slusaPredmetRepo.getSlusaPredmetForIndeksAktivnaGodina(indeksId));
		return retVal;
	}

}
