package com.elcaserio.repository;

import com.elcaserio.model.DireccionCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccionClienteRepository extends JpaRepository <DireccionCliente, Long> {
}
