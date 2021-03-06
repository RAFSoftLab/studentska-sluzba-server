package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.SlusaPredmet;
import org.raflab.studsluzba.model.StudentIndeks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SlusaPredmetRepository extends CrudRepository<SlusaPredmet, Long> {
	
	@Query("select sp from SlusaPredmet sp where sp.studentIndeks.id = :indeksId and sp.drziPredmet.skolskaGodina.aktivna = 1")
	List<SlusaPredmet> getSlusaPredmetForIndeksAktivnaGodina(Long indeksId);
	
	
	@Query("select sp.studentIndeks from SlusaPredmet sp where sp.drziPredmet.predmet.id = :idPredmeta "
			+ "and sp.drziPredmet.nastavnik.id = :idNastavnika  "
			+ "and sp.drziPredmet.skolskaGodina.aktivna = 1")
	List<StudentIndeks> getStudentiSlusaPredmetAktivnaGodina(Long idPredmeta, Long idNastavnika);
	
	
	@Query("select sp.studentIndeks from SlusaPredmet sp where sp.drziPredmet.id = :idDrziPredmet and sp.drziPredmet.skolskaGodina.aktivna = 1")		
	List<StudentIndeks> getStudentiSlusaPredmetZaDrziPredmet(Long idDrziPredmet);
	
	
	/*
	 * TODO dodati slicne operacije koja vracaju sve studente za stud program/ godinu studija koje ne slusaju predmet
	 */
	@Query("select si from StudentIndeks si where not exists "
			+ "(select sp from SlusaPredmet sp where sp.studentIndeks=si and sp.drziPredmet.id = :idDrziPredmet "
			+ "and sp.drziPredmet.skolskaGodina.aktivna = 1) ")
	List<StudentIndeks> getStudentiNeSlusajuDrziPredmet(Long idDrziPredmet);
	

}
