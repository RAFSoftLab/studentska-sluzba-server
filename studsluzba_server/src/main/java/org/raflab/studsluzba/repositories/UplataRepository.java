package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.Uplata;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UplataRepository extends CrudRepository<Uplata, Long> {
	
	@Query("select up from Uplata up where up.studentIndeks.id = :indeksId")
	List<Uplata> getUplateForIndeks(Long indeksId);
 	
}
