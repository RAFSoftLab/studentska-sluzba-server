package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.UpisGodine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UpisGodineRepository extends CrudRepository<UpisGodine, Long> {
	
	@Query("select ug from UpisGodine ug where ug.studentIndeks.id = :indeksId")
	List<UpisGodine> getUpisiForIndeks(Long indeksId);

	@Query("select ug.godinaKojaSeUpisuje from UpisGodine ug " +
			"where ug.studentIndeks.id = :indeksId " +
			"order by ug.godinaKojaSeUpisuje desc ")
	List<Integer> getUpisaneGodineForStudentIndeks(Long indeksId);

}
