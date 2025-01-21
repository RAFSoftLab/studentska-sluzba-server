package org.raflab.studsluzba.repositories;

import org.raflab.studsluzba.model.UpisGodinePredmeti;
import org.raflab.studsluzba.model.UpisGodinePredmetiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpisGodinePredmetiRepository extends JpaRepository<UpisGodinePredmeti, UpisGodinePredmetiId> {
}
