package com.dailystatusapi.service;

import com.dailystatusapi.model.MovItemTeste;
import com.dailystatusapi.repository.MovItemTesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovItemTesteService {

    @Autowired
    private MovItemTesteRepository movItemRepository;

    public void salvar(MovItemTeste movItem) {
        movItemRepository.save(movItem);
    }
}
