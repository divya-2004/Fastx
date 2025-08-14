package com.hexaware.fastx.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.fastx.entity.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
	Optional<Administrator> findByEmail(String email);
}
