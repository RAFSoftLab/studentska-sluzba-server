package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.PolozenPredmet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PolozenPredmetRepository extends CrudRepository<PolozenPredmet, Long> {
	
	@Query("select pp from PolozenPredmet pp where pp.studentIndeks.id = :indeksId")
	List<PolozenPredmet> getPolozeniPredmetForIndeks(Long indeksId);

}
