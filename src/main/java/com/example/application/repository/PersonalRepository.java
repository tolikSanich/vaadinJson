package com.example.application.repository;

import com.example.application.model.Personal;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, Long>, BaseJpaRepository<Personal, Long> {

}
