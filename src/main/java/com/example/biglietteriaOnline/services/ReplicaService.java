package com.example.biglietteriaOnline.services;

import com.example.biglietteriaOnline.model.Replica;
import com.example.biglietteriaOnline.repository.ReplicaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReplicaService {

    private final ReplicaRepository replicaRepo;

    public List<Replica> getReplicheBySpettacolo(String codSpettacolo) {
        return replicaRepo.findByCodSpettacolo(codSpettacolo);
    }
}
