package com.example.biglietteriaOnline.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "Spettacoli")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Spettacolo {

    @Id
    @Column(name = "COD_SPETTACOLO", length = 4)
    private String codSpettacolo;

    @Column(name = "TITOLO", nullable = false, length = 40)
    private String titolo;

    @Column(name = "AUTORE", length = 25)
    private String autore;

    @Column(name = "REGISTA", length = 25)
    private String regista;

    @Column(name = "PREZZO", nullable = false, precision = 6, scale = 2)
    private BigDecimal prezzo;

    @Column(name = "COD_TEATRO", length = 4)
    private String codTeatro;

    @ManyToOne
    @JoinColumn(name = "COD_TEATRO", insertable = false, updatable = false)
    private Teatro teatro;

    @OneToMany(mappedBy = "codSpettacolo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Replica> repliche;
}