package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.PrijavaIspita;
import org.raflab.studsluzba.model.StudentIndeks;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PrijavaIspitaRepository extends CrudRepository<PrijavaIspita, Long> {
	
	
	@Query("select pi from PrijavaIspita pi where pi.studentIndeks.id = :indeksId and pi.ispit.ispitniRok.skolskaGodina.aktivna = 1")
	List<PrijavaIspita> getPrijaveIspitaForIndeksAktivnaGodina(Long indeksId);
	
	@Query("select pi from PrijavaIspita pi where pi.studentIndeks.id = :indeksId and pi.ispit.id = :ispitId")
	PrijavaIspita getPrijavaForIndeksIspit(Long indeksId, Long ispitId);
	
	@Query("select pi.studentIndeks from PrijavaIspita pi where pi.ispit.id = :idIspita")
	List<StudentIndeks> getPrijavljeniZaIspit(Long idIspita);
	
	@Query("select pi from PrijavaIspita pi where pi.ispit.id = :idIspita")
	List<PrijavaIspita> getPrijaveZaIspit(Long idIspita);
	
	@Query("select pi from PrijavaIspita pi where pi.ispit.drziPredmet.skolskaGodina.aktivna=1 and pi.ispit.drziPredmet.nastavnik.id = :idNastavnik "
			+ "and pi.ispit.drziPredmet.predmet.id = :idPredmet and pi.ispit.ispitniRok.id = :idIspitniRok")
	List<PrijavaIspita> getPrijavljeniForIspitNastavnikPredmetIspitniRokAktivna(Long idNastavnik, Long idPredmet, Long idIspitniRok); 
	
	
}
