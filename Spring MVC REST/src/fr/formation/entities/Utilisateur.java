package fr.formation.entities;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Civilite civilite;

    @NotEmpty(message = "{error.utilisateur.nom.obligatoire}")
    private String nom;

    @NotEmpty(message = "{error.utilisateur.prenom.obligatoire}")
    private String prenom;

    @NotEmpty(message = "{error.utilisateur.email.obligatoire}")
    @Email(message = "{error.utilisateur.email.malforme}")
    @Column(unique = true, nullable = false)
    private String email;

    @NotEmpty(message = "{error.utilisateur.motDePasse.obligatoire}")
    private String motDePasse;

    @NotNull(message = "{error.utilisateur.role.obligatoire}")
    @Enumerated(EnumType.STRING)
    private RoleUtilisateur role = RoleUtilisateur.ROLE_USER;

    @Valid
    @OneToOne(cascade = { CascadeType.ALL })
    private Adresse adresse;

    public Utilisateur() {
	//
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Civilite getCivilite() {
	return civilite;
    }

    public void setCivilite(Civilite civilite) {
	this.civilite = civilite;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getPrenom() {
	return prenom;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Adresse getAdresse() {
	return adresse;
    }

    public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
    }

    public String getMotDePasse() {
	return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
    }

    public RoleUtilisateur getRole() {
	return role;
    }

    public void setRole(RoleUtilisateur role) {
	this.role = role;
    }

    @Override
    public String toString() {
	return "{nom=" + nom + ", prenom=" + prenom + ", email=" + email + "}";
    }
}
