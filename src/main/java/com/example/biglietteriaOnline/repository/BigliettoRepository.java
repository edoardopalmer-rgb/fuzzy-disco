package com.example.biglietteriaOnline.repository;

import com.example.biglietteriaOnline.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BigliettoRepository extends JpaRepository<Biglietto, Integer> {

    List<Biglietto> findByCodCliente(Integer codCliente);

    @Query("SELECT IFNULL(SUM(b.quantita), 0) FROM Biglietto b WHERE b.codReplica = :codReplica")
    int sumQuantitaByCodReplica(@Param("codReplica") String codReplica);

    Biglietto getByCodClienteAndCodReplica(Integer codCliente, String codReplica);

    boolean existsByCodClienteAndCodReplica(Integer codCliente, String codReplica);
}
