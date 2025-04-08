package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.Ispit;
import org.raflab.studsluzba.model.StudentIndeks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IspitRepository extends CrudRepository<Ispit, Long> {
	
	
	@Query("select i from Ispit i join fetch i.drziPredmet where i.ispitniRok.id = :idIspitniRok")
	List<Ispit> getIspitiForIspitniRok(Long idIspitniRok);
	
	
	@Query("select i from Ispit i where i.ispitniRok.id = :idIspitniRok and "
			+ "i.drziPredmet in (select sp.drziPredmet from SlusaPredmet sp where sp.drziPredmet.skolskaGodina.aktivna=true and sp.studentIndeks.id = :idStudentIndeks) and "
			+ "i.drziPredmet.predmet not in (select pp.predmet from PolozenPredmet pp where pp.studentIndeks.id = :idStudentIndeks)" )
	List<Ispit> getMoguciIspitiZaIndeksIRok(Long idStudentIndeks, Long idIspitniRok);
	
	
	/*
	 * vraca studente koji nisu prijavili ispit, a slusaju predmet
	 */
	@Query("select sp.studentIndeks from SlusaPredmet sp where sp.drziPredmet = (select i.drziPredmet from Ispit i where i.id = :idIspita) "
			+ "and not exists (select pi from PrijavaIspita pi where pi.ispit.id = :idIspita and pi.studentIndeks = sp.studentIndeks)")
	List<StudentIndeks> getNeprijavljeni(Long idIspita);
	
	
	@Query("select i from Ispit i where i.drziPredmet.skolskaGodina.aktivna=true and i.drziPredmet.nastavnik.id = :idNastavnik "
			+ "and i.drziPredmet.predmet.id = :idPredmet and i.ispitniRok.id = :idIspitniRok")
	Ispit getIspitForNastavnikPredmetIspitniRokAktivna(Long idNastavnik, Long idPredmet, Long idIspitniRok);


}
