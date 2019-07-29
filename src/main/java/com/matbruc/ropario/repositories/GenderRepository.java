package com.matbruc.ropario.repositories;

import com.matbruc.ropario.models.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderRepository extends CrudRepository<Gender, Long> {
}
