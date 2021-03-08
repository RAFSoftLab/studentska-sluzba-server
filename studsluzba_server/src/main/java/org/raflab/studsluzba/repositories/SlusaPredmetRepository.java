package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.SlusaPredmet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SlusaPredmetRepository extends CrudRepository<SlusaPredmet, Long> {
	
	@Query("select sp from SlusaPredmet sp where sp.studentIndeks.id = :indeksId and sp.drziPredmet.skolskaGodina.aktivna = 1")
	List<SlusaPredmet> getSlusaPredmetForIndeksAktivnaGodina(Long indeksId);

}
