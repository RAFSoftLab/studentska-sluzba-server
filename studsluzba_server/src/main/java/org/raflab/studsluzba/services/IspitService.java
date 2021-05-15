package org.raflab.studsluzba.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.raflab.studsluzba.model.Ispit;
import org.raflab.studsluzba.model.IzlazakIspit;
import org.raflab.studsluzba.model.OsvojeniPoeniPredispitne;
import org.raflab.studsluzba.model.PrijavaIspita;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.dtos.RezultatIspitaDTO;
import org.raflab.studsluzba.model.dtos.StudentIndeksPredispitneDTO;
import org.raflab.studsluzba.repositories.IspitRepository;
import org.raflab.studsluzba.repositories.IzlazakIspitRepository;
import org.raflab.studsluzba.repositories.OsvojeniPoeniPredispitneRepository;
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
	
	@Autowired
	OsvojeniPoeniPredispitneRepository osvojeniPoeniPredispitneRepo;
	
	@Autowired
	IzlazakIspitRepository izlazakIspitRepo;
	
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
	
	public boolean odjaviPrijavuIspit(Long idPrjave) {
		try {
			prijavaIspitaRepo.deleteById(idPrjave);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public List<StudentIndeksPredispitneDTO> getPrijavljeniSaPredispitnimZaIspit(Long idIspit){
		Ispit ispit = ispitRepo.findById(idIspit).get();
		List<PrijavaIspita> prijavljeni = prijavaIspitaRepo.getPrijaveZaIspit(idIspit);		
		List<StudentIndeksPredispitneDTO> retVal = new ArrayList<>();
		for(PrijavaIspita si:prijavljeni) {
			StudentIndeksPredispitneDTO val = new StudentIndeksPredispitneDTO();
			val.setStudentIndeks(si.getStudentIndeks());
			val.setIdPrijave(si.getId());
			Float poeni = osvojeniPoeniPredispitneRepo.getSumaPredispitneForIndeksDrziPredmet(si.getStudentIndeks().getId(), ispit.getDrziPredmet());			
			val.setUkupnoPredispitne(poeni==null ? 0 : poeni);
			retVal.add(val);
		}
		return retVal;		
	}
	
	public void saveRezultatiIspita(List<RezultatIspitaDTO> rezultati) {
		for(RezultatIspitaDTO rez:rezultati) {
			IzlazakIspit ii = izlazakIspitRepo.getIzlazakIspitForPrijava(rez.getIdPrijave());
			if(ii == null){
				ii = new IzlazakIspit();				
			}
			PrijavaIspita pi = prijavaIspitaRepo.findById(rez.getIdPrijave()).get();
			ii.setPrijava(pi);
			ii.setBrojPoenaIspit(rez.getPoeniIspit());
			ii.setBrojPoenaPredispitne(rez.getUkupnoPredispitne());
			ii.setPonisten(rez.isPonisten());
			ii.setNapomena(rez.getNapomena());
			ii.setOcena(rez.getOcena());
			izlazakIspitRepo.save(ii);			
		}
		
	}

}
