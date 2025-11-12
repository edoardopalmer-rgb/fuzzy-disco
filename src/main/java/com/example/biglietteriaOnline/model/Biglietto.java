package com.example.biglietteriaOnline.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Biglietti")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Biglietto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_OPERAZIONE")
    private Integer codOperazione;

    @Column(name = "COD_CLIENTE", nullable = false)
    private Integer codCliente;

    @Column(name = "COD_REPLICA", nullable = false, length = 4)
    private String codReplica;

    @Column(name = "DATA_ORA")
    private LocalDateTime dataOra;

    @Column(name = "TIPO_PAGAMENTO", length = 20)
    private String tipoPagamento;

    @Column(name = "QUANTITA", nullable = false)
    private Integer quantita;

    @PrePersist
    protected void onCreate() {
        if (dataOra == null) {
            dataOra = LocalDateTime.now();
        }
    }
}