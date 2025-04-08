package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.PredispitnaObaveza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PredispitnaObavezaRepository extends CrudRepository<PredispitnaObaveza, Long> {
	
	@Query("select pi from PredispitnaObaveza pi where pi.drziPredmet.predmet.id=:idPredmet "
			+ "and pi.drziPredmet.nastavnik.id=:idNastavnik "
			+ "and pi.drziPredmet.skolskaGodina.aktivna = true")
	List<PredispitnaObaveza> getPredispitneForNastavnikPredmetAktivnaGodina(Long idNastavnik, Long idPredmet);
	
	

}
