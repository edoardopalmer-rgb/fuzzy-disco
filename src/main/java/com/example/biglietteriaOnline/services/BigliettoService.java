package com.example.biglietteriaOnline.services;

import com.example.biglietteriaOnline.model.Biglietto;
import com.example.biglietteriaOnline.model.Cliente;
import com.example.biglietteriaOnline.model.Replica;
import com.example.biglietteriaOnline.repository.BigliettoRepository;
import com.example.biglietteriaOnline.repository.ClienteRepository;
import com.example.biglietteriaOnline.repository.ReplicaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BigliettoService {

    private final ClienteRepository clienteRepo;
    private final BigliettoRepository bigliettoRepo;
    private final ReplicaRepository replicaRepo;

    public boolean insertPrenotazione (Integer codCliente, String codReplica, Integer quantita, String tipoPagamento) {

        Cliente cliente = clienteRepo.findByCodCliente(codCliente);
        Replica replica = replicaRepo.findByCodReplica(codReplica);

        if(cliente == null || replica == null)
            return false;

        int prenotati = bigliettoRepo.sumQuantitaByCodReplica(replica.getCodReplica());
        int postiTeatro = replica.getSpettacolo().getTeatro().getPosti();

        if(prenotati + quantita > postiTeatro)
            return false;

        // controlla se è già presente una prenotazione per l'utente e la replica indicate
        if(bigliettoRepo.existsByCodClienteAndCodReplica(codCliente, codReplica)) {

            // se è già presente, aggiorno solo la quantità
            Biglietto b = bigliettoRepo.getByCodClienteAndCodReplica(codCliente, codReplica);
            b.setQuantita(b.getQuantita() + quantita);
            bigliettoRepo.save(b);

        } else {

            // se non è già presente, creo un biglietto con i dati relativi
            Biglietto b = new Biglietto();
            b.setCodCliente(cliente.getCodCliente());
            b.setCodReplica(replica.getCodReplica());
            b.setQuantita(quantita);
            b.setTipoPagamento(tipoPagamento);
            b.setDataOra(replica.getDataReplica().atTime(21, 0));
            bigliettoRepo.save(b);
        }

        return true;
    }

    public List<Biglietto> getBigiettiByUser(int codCliente) {
        return bigliettoRepo.findByCodCliente(codCliente);
    }

}