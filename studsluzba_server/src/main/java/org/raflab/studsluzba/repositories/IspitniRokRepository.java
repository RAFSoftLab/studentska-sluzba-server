package org.raflab.studsluzba.repositories;

import java.util.List;

import org.raflab.studsluzba.model.IspitniRok;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IspitniRokRepository extends CrudRepository<IspitniRok, Long> {
	
	
	@Query("select ir from IspitniRok ir where ir.skolskaGodina.aktivna = true")
	Iterable<IspitniRok> getForAktivnaSkolskaGodina();

	@Query(value = "select ir from IspitniRok ir where ir.skolskaGodina.aktivna=true and ir.datumPocetkaPrijave<=CURRENT_DATE and ir.datumZavrsetka>=CURRENT_DATE")
	IspitniRok getAktivniIspitniRokovi();

}
