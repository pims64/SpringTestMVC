package fr.formation.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rue;

    @NotEmpty(message = "{error.adresse.codePostal.obligatoire}")
    private String codePostal;

    @NotEmpty(message = "{error.adresse.ville.obligatoire}")
    private String ville;

    public Adresse() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getRue() {
	return rue;
    }

    public void setRue(String rue) {
	this.rue = rue;
    }

    public String getCodePostal() {
	return codePostal;
    }

    public void setCodePostal(String codePostal) {
	this.codePostal = codePostal;
    }

    public String getVille() {
	return ville;
    }

    public void setVille(String ville) {
	this.ville = ville;
    }

    @Override
    public String toString() {
	return "{rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
		+ "}";
    }
}
