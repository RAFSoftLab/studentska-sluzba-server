package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.Ispit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IspitRepository extends CrudRepository<Ispit, Long> {
	
	
	@Query("select i from Ispit i join fetch i.drziPredmet where i.ispitniRok.id = :idIspitniRok")
	List<Ispit> getIspitiForIspitniRok(Long idIspitniRok);
	
	
	@Query("select i from Ispit i where i.ispitniRok.id = :idIspitniRok and "
			+ "i.drziPredmet in (select sp.drziPredmet from SlusaPredmet sp where sp.drziPredmet.skolskaGodina.aktivna=1 and sp.studentIndeks.id = :idStudentIndeks) and "
			+ "i.drziPredmet.predmet not in (select pp.predmet from PolozenPredmet pp where pp.studentIndeks.id = :idStudentIndeks)" )
	List<Ispit> getMoguciIspitiZaIndeksIRok(Long idStudentIndeks, Long idIspitniRok);
	

}
