package fr.formation.entities;

import javax.persistence.*;

@Entity
public class Civilite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String abbreviation;

    public Civilite() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getAbbreviation() {
	return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
	this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
	return "{abbreviation=" + abbreviation + "}";
    }
}
