package org.raflab.studsluzba.repositories;


import org.raflab.studsluzba.model.ObnovaGodineUpisujePredmete;
import org.raflab.studsluzba.model.ObnovaGodineUpisujePredmeteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObnovaGodineUpisujePredmeteRepository extends JpaRepository<ObnovaGodineUpisujePredmete, ObnovaGodineUpisujePredmeteId> {
}
