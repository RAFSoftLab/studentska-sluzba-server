package org.raflab.studsluzba.repositories;



import java.util.List;

import org.raflab.studsluzba.model.StudentIndeks;
import org.raflab.studsluzba.model.StudentPodaci;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPodaciRepository extends CrudRepository<StudentPodaci, Long> {	//	nasljedjene implementacije poput findById i findByAll
	
	@Query("select sp from StudentPodaci sp where "
			+ "(:ime is null or lower(sp.ime) like :ime) and "
			+ "(:prezime is null or lower(sp.prezime) like :prezime) and "
			+ "not exists (select indeks from StudentIndeks indeks where indeks.student = sp)")			
	List<StudentPodaci> findStudent(String ime, String prezime);
	
	@Query("select si from StudentIndeks si where si.aktivan=1 and si.student.id = :studPodaciId")
	StudentIndeks getAktivanIndeks(Long studPodaciId);
	
	@Query("select si from StudentIndeks si where si.aktivan=0 and si.student.id = :studPodaciId")
	List<StudentIndeks> getNeaktivniIndeksi(Long studPodaciId);
		
	
	


	
	
}
