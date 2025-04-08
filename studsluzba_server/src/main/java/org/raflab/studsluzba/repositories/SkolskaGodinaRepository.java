package org.raflab.studsluzba.repositories;

import org.raflab.studsluzba.model.SkolskaGodina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SkolskaGodinaRepository extends CrudRepository<SkolskaGodina, Long> {
	
	@Query("select s from SkolskaGodina s where s.aktivna=true")
	SkolskaGodina getAktivnaSkolskaGodina();

	SkolskaGodina findTopByOrderByKrajnjaDesc();
	

}
