package org.raflab.studsluzba.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ObnovaGodine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private StudentIndeks studentIndeks;
	
	private int godinaKojuObnavlja;	
	
	@ManyToMany
	private Set<Predmet> upisujePredmete;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getGodinaKojuObnavlja() {
		return godinaKojuObnavlja;
	}
	public void setGodinaKojuObnavlja(int godinaKojuObnavlja) {
		this.godinaKojuObnavlja = godinaKojuObnavlja;
	}
	public Set<Predmet> getUpisujePredmete() {
		return upisujePredmete;
	}
	public void setUpisujePredmete(Set<Predmet> upisujePredmete) {
		this.upisujePredmete = upisujePredmete;
	}	
	
	
}
