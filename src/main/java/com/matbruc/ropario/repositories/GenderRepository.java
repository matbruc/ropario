package com.matbruc.ropario.repositories;

import com.matbruc.ropario.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}
