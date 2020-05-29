package com.matbruc.ropario.repositories;

import com.matbruc.ropario.models.Age;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeRespository extends JpaRepository<Age, Long> {
}
