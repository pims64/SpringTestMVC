package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.entities.Credentials;

public interface ICredentialsJpaRepository
	extends JpaRepository<Credentials, Long> {
    //
}
