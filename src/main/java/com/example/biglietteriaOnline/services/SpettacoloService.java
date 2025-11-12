package com.example.biglietteriaOnline.services;

import com.example.biglietteriaOnline.model.Spettacolo;
import com.example.biglietteriaOnline.repository.SpettacoloRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SpettacoloService {

    private final SpettacoloRepository spettacoloRepo;

    public List<Spettacolo> getSpettacoli() {
        return spettacoloRepo.findAll();
    }

}