package com.elcaserio.repository;

import com.elcaserio.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoRepository extends JpaRepository <Carrito, Long> {
}
