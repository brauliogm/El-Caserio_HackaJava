package com.elcaserio.repository;

import com.elcaserio.model.Alergeno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlergenoRepository extends JpaRepository <Alergeno, Long> {
}
