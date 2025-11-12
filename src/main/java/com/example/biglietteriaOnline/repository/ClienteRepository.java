package com.example.biglietteriaOnline.repository;

import com.example.biglietteriaOnline.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByCodCliente(Integer codCliente);
}
