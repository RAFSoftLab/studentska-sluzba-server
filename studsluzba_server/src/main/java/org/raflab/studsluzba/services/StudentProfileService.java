package org.raflab.studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.raflab.studsluzba.model.Ispit;
import org.raflab.studsluzba.model.PolozenPredmet;
import org.raflab.studsluzba.model.PrijavaIspita;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.dtos.IspitPrijavaDTO;
import org.raflab.studsluzba.model.dtos.StudentProfileDTO;
import org.raflab.studsluzba.model.dtos.StudentWebProfileDTO;
import org.raflab.studsluzba.repositories.IspitRepository;
import org.raflab.studsluzba.repositories.ObnovaGodineRepository;
import org.raflab.studsluzba.repositories.OsvojeniPoeniPredispitneRepository;
import org.raflab.studsluzba.repositories.PolozenPredmetRepository;
import org.raflab.studsluzba.repositories.PredmetRepository;
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
	
	@Autowired
	PredmetRepository predmetRepo;
	
	@Autowired
	OsvojeniPoeniPredispitneRepository osvojeniPoeniPredispitneRepo;
	
	@Autowired
	IspitRepository ispitRepo;
	
	
	
	public StudentProfileDTO getStudentProfile(Long indeksId) {
		StudentProfileDTO retVal = new StudentProfileDTO();
		StudentIndeks studIndeks = studentIndeksRepo.findById(indeksId).get();		
		retVal.setIndeks(studIndeks);		
		retVal.setPolozeniPredmeti(polozeniPredmetRepo.getPolozeniPredmetForIndeks(indeksId));
		retVal.setUpisiGodine(upisGodineRepo.getUpisiForIndeks(indeksId));
		retVal.setObnoveGodine(obnovaGodineRepo.getObnoveForIndeks(indeksId));
		retVal.setUplate(uplataRepo.getUplateForIndeks(indeksId));
		retVal.setPrijaveIspita(prijavaIspitaRepo.getPrijaveIspitaForIndeksAktivnaGodina(indeksId));	
		retVal.setSlusaPredmete(slusaPredmetRepo.getSlusaPredmetForIndeksAktivnaGodina(indeksId));
		retVal.setNepolozeniPredmeti(predmetRepo.getNepolozeniPredmeti(indeksId));
		return retVal;
	}
	
	public StudentWebProfileDTO getStudentWebProfile(Long indeksId) {
		StudentWebProfileDTO retVal = new StudentWebProfileDTO();
		StudentIndeks studIndeks = studentIndeksRepo.findById(indeksId).get();
		Long studPodaciId = studIndeks.getStudent().getId();
		retVal.setAktivanIndeks(studentPodaciRepo.getAktivanIndeks(studPodaciId));		
		retVal.setPolozeniPredmeti(polozeniPredmetRepo.getPolozeniPredmetForIndeks(indeksId));
		retVal.setUpisiGodine(upisGodineRepo.getUpisiForIndeks(indeksId));
		retVal.setObnoveGodine(obnovaGodineRepo.getObnoveForIndeks(indeksId));
		retVal.setUplate(uplataRepo.getUplateForIndeks(indeksId));			
		retVal.setSlusaPredmete(slusaPredmetRepo.getSlusaPredmetForIndeksAktivnaGodina(indeksId));
		retVal.setOsvojeniPoeniPredispitne(osvojeniPoeniPredispitneRepo.getPoeniPredispitneZaIndeksAktivnu(indeksId));
		return retVal;
	}
	
	public List<IspitPrijavaDTO> getDustupniIspiti(Long idStudIndeks, Long idIspitniRok) {
		List<Ispit> dostupniIspiti = ispitRepo.getMoguciIspitiZaIndeksIRok(idStudIndeks, idIspitniRok);		
		List<IspitPrijavaDTO> retVal = new ArrayList<>();
		for(Ispit i:dostupniIspiti) {
			IspitPrijavaDTO sii = new IspitPrijavaDTO();
			sii.setDatumOdrzavanja(i.getDatumOdrzavanja());
			sii.setVremeOdrzavanja(i.getVremeOdrzavanja());
			sii.setIdIspit(i.getId());
			sii.setDrziPredmet(i.getDrziPredmet());
			sii.setMestoOdrzavanja(i.getMestoOdrzavanja());
			PrijavaIspita pi = prijavaIspitaRepo.getPrijavaForIndeksIspit(idStudIndeks, i.getId());
			if(pi==null) 
				sii.setPrijavljen(false);
			else {
				sii.setPrijavljen(true);
				sii.setIdPrijave(pi.getId());
			}
			
			retVal.add(sii);
		}
		return retVal;
	}

}
