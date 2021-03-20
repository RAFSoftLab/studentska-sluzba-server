package org.raflab.studsluzba.repositories;

import java.time.LocalDate;
import java.util.List;

import org.raflab.studsluzba.model.IspitniRok;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IspitniRokRepository extends CrudRepository<IspitniRok, Long> {
	
	
	@Query("select ir from IspitniRok ir where ir.skolskaGodina.aktivna = 1")
	List<IspitniRok> getIspitniRokoviForAktivnaSkolsaGodina();
	
	
	
	@Query("select ir from IspitniRok ir where ir.datumPocetkaPrijave<=CURRENT_DATE and ir.datumZavrsetka>=CURRENT_DATE")
	List<IspitniRok> getAktivniIspitniRokovi();
		
	

}
