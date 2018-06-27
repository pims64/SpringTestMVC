package fr.formation.dao;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import fr.formation.entities.Utilisateur;

public interface IUtilisateurJpaRepository
	extends JpaRepository<Utilisateur, Long> {

    @Query("select u from Utilisateur u where u.email = :email and u.motDePasse = :motDePasse")
    public Utilisateur findbyCredentials(@Param("email") String code,
	    @Param("motDePasse") String motDePasse);

    // Requete derivee = findBy + attribut de l'entite
    public Utilisateur findByEmail(String email);
}
