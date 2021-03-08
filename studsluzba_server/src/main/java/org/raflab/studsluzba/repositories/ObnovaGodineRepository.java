package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.ObnovaGodine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ObnovaGodineRepository extends CrudRepository<ObnovaGodine, Long> {
	
	@Query("select og from ObnovaGodine og where og.studentIndeks.id = :indeksId")
	List<ObnovaGodine> getObnoveForIndeks(Long indeksId);

}
