package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.OsvojeniPoeniPredispitne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OsvojeniPoeniPredispitneRepository extends CrudRepository<OsvojeniPoeniPredispitne, Long> {
	
	
	@Query("select op from OsvojeniPoeniPredispitne op where op.studentIndeks.id = :indeksId "
			+ "and op.predispitnaObaveza.drziPredmet.skolskaGodina.aktivna = 1")
	List<OsvojeniPoeniPredispitne> getPoeniPredispitneZaIndeksAktivnu(Long indeksId);

}
