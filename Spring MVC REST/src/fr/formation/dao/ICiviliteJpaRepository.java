package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entities.Civilite;

public interface ICiviliteJpaRepository extends JpaRepository<Civilite, Long> {
    //
}
