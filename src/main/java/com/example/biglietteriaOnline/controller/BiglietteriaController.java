package com.example.biglietteriaOnline.controller;

import com.example.biglietteriaOnline.model.*;
import com.example.biglietteriaOnline.services.BigliettoService;
import com.example.biglietteriaOnline.services.ReplicaService;
import com.example.biglietteriaOnline.services.SpettacoloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BiglietteriaController {

    private final BigliettoService bigliettoService;
    private final SpettacoloService spettacoloService;
    private final ReplicaService replicaService;

    @GetMapping("/spettacoli")
    public List<Spettacolo> getSpettacoli() {
        return spettacoloService.getSpettacoli();
    }

    @GetMapping("/repliche/{codSpettacolo}")
    public List<Replica> getRepliche(@PathVariable String codSpettacolo) {
        return replicaService.getReplicheBySpettacolo(codSpettacolo);
    }

    @PostMapping("/prenota")
    public ResponseEntity<String> prenota(
            @RequestParam Integer codCliente,
            @RequestParam String codReplica,
            @RequestParam Integer quantita,
            @RequestParam String tipoPagamento) {

        boolean bigliettoInserito = bigliettoService.insertPrenotazione(codCliente, codReplica, quantita, tipoPagamento);

        if(bigliettoInserito){
            return ResponseEntity.ok("Prenotazione effettuata");
        } else {
            return ResponseEntity.badRequest().body("Errore durante la prenotazione");

        }
    }

    @GetMapping("/prenotazioni/{codCliente}")
    public List<Biglietto> getPrenotazioni(@PathVariable Integer codCliente) {
        return bigliettoService.getBigiettiByUser(codCliente);
    }
}
