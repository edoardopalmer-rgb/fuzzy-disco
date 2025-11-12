package com.example.biglietteriaOnline.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Teatri")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teatro {

    @Id
    @Column(name = "COD_TEATRO")
    private String codTeatro;

    private String nome;
    private String indirizzo;
    private String citta;
    private String provincia;
    private String telefono;
    private int posti;


    public String getCodTeatro() {
        return codTeatro;
    }

    public void setCodTeatro(String codTeatro) {
        this.codTeatro = codTeatro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getPosti() {
        return posti;
    }

    public void setPosti(int posti) {
        this.posti = posti;
    }
}
