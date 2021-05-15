package org.raflab.studsluzba.services;

import java.util.ArrayList;
import java.util.List;

import org.raflab.studsluzba.model.DrziPredmet;
import org.raflab.studsluzba.model.OsvojeniPoeniPredispitne;
import org.raflab.studsluzba.model.PredispitnaObaveza;
import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.dtos.OsvojeniPoeniPredispitneDTO;
import org.raflab.studsluzba.model.dtos.PredispitnaObavezaDTO;
import org.raflab.studsluzba.repositories.DrziPredmetRepository;
import org.raflab.studsluzba.repositories.OsvojeniPoeniPredispitneRepository;
import org.raflab.studsluzba.repositories.PredispitnaObavezaRepository;
import org.raflab.studsluzba.repositories.StudentIndeksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PredispitneService {
	
	@Autowired
	PredispitnaObavezaRepository predispitnaObavezaRepo;
	
	@Autowired
	DrziPredmetRepository drziPredmetRepo;
	
	@Autowired
	OsvojeniPoeniPredispitneRepository osvojeniPoeniPredispitneRepo;
	
	@Autowired
	StudentIndeksRepository studentIndeksRepo;
	
	public Long savePredispitne(Long idPredmet, Long idNastavnik, String naziv, Integer maxBr) {
		DrziPredmet dp = drziPredmetRepo.getDrziPredmetNastavnikPredmetAktivna(idPredmet, idNastavnik);
		PredispitnaObaveza po = new PredispitnaObaveza();
		po.setDrziPredmet(dp);
		po.setMaxBrojPoena(maxBr);
		po.setNaziv(naziv);
		predispitnaObavezaRepo.save(po);
		return po.getId();
		
	}
	
	public List<PredispitnaObavezaDTO> getPredispitneDTOForNastavnikPredmetAktivnaGodina(Long idNastavnik, Long idPredmet){
		List<PredispitnaObavezaDTO> retVal = new ArrayList<>();
		List<PredispitnaObaveza> predispitne = predispitnaObavezaRepo.getPredispitneForNastavnikPredmetAktivnaGodina(idNastavnik, idPredmet);
		for(PredispitnaObaveza po:predispitne) {
			PredispitnaObavezaDTO poDTO = new PredispitnaObavezaDTO(po);
			if(osvojeniPoeniPredispitneRepo.getOsvojeniPoeniZaPredispitne(po.getId()).size()==0) {
				poDTO.setImaUnetePoene(false);
			}else {
				poDTO.setImaUnetePoene(true);
			}
			retVal.add(poDTO);
		}
		return retVal;
	}
	
	public List<OsvojeniPoeniPredispitneDTO> getOsvojeniPoeniPredispitneDTOForNastavnikPredmetAktivna(Long idNastavnik, Long idPredmet){
		List<OsvojeniPoeniPredispitneDTO> retVal = new ArrayList<>();
		List<OsvojeniPoeniPredispitne> poeniPredispitne = osvojeniPoeniPredispitneRepo.getOsvojeniPoeniZaNastavnikPredmetAktivna(idNastavnik, idPredmet);
		for(OsvojeniPoeniPredispitne op:poeniPredispitne) {			
			retVal.add(new OsvojeniPoeniPredispitneDTO(op.getStudentIndeks().getId(),op.getPredispitnaObaveza().getId(),op.getPoeni()));			
		}
		return retVal;
	}
	
	public void sacuvajOsvojeniPoenipredispitne(List<OsvojeniPoeniPredispitneDTO> osvojeniPoeni) {
		for(OsvojeniPoeniPredispitneDTO val:osvojeniPoeni) {
			OsvojeniPoeniPredispitne op = osvojeniPoeniPredispitneRepo.getOsvojeniPoeniStudentIndeksPrdispitna(val.getIdStudentIndeks(),val.getIdPredispitnaObaveza());
			if(op == null) {
				op = new OsvojeniPoeniPredispitne();
				StudentIndeks si = studentIndeksRepo.findById(val.getIdStudentIndeks()).get();
				PredispitnaObaveza po = predispitnaObavezaRepo.findById(val.getIdPredispitnaObaveza()).get();
				op.setPredispitnaObaveza(po);
				op.setStudentIndeks(si);
			}
			op.setPoeni(val.getOsvojeniPoeni());
			osvojeniPoeniPredispitneRepo.save(op);
		}
		
	}
}
