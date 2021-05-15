package org.raflab.studsluzba.repositories;

import org.raflab.studsluzba.model.IzlazakIspit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IzlazakIspitRepository extends CrudRepository<IzlazakIspit, Long> {
	
	@Query("select ii from IzlazakIspit ii where ii.prijava.id = :idPrijave")
	IzlazakIspit getIzlazakIspitForPrijava(Long idPrijave);

}
