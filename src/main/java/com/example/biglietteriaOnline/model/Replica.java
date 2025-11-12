package com.example.biglietteriaOnline.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Repliche")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Replica {

    @Id
    @Column(name = "COD_REPLICA", length = 4)
    private String codReplica;

    @Column(name = "COD_SPETTACOLO", nullable = false, length = 4)
    private String codSpettacolo;

    @Column(name = "DATA_REPLICA", nullable = false)
    private LocalDate dataReplica;

    @ManyToOne
    @JoinColumn(name = "COD_SPETTACOLO", insertable = false, updatable = false)
    private Spettacolo spettacolo;

    @OneToMany(mappedBy = "codReplica", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Biglietto> biglietti;
}