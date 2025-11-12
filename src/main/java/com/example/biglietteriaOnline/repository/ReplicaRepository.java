package com.example.biglietteriaOnline.repository;

import com.example.biglietteriaOnline.model.Replica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplicaRepository extends JpaRepository<Replica, String> {

    Replica findByCodReplica(String codReplica);

    List<Replica> findByCodSpettacolo(String codSpettacolo);
}
