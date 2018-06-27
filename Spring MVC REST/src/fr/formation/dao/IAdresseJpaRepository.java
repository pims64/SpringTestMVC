package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entities.Adresse;

public interface IAdresseJpaRepository extends JpaRepository<Adresse, Long> {
    //
}
