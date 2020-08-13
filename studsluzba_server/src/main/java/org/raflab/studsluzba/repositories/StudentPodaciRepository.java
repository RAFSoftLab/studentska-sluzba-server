package org.raflab.studsluzba.repositories;



import java.util.List;

import org.raflab.studsluzba.model.StudentPodaci;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPodaciRepository extends CrudRepository<StudentPodaci, Long> {
	
	@Query("select sp from StudentPodaci sp where "
			+ "(:ime is null or lower(sp.ime) like :ime) and "
			+ "(:prezime is null or lower(sp.prezime) like :prezime) and "
			+ "not exists (select indeks from StudentIndeks indeks where indeks.student = sp)")			
	List<StudentPodaci> findStudent(String ime, String prezime);

	
	
}
