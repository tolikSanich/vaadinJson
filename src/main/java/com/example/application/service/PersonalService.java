package com.example.application.service;

import com.example.application.model.Personal;
import com.example.application.repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonalService {
    private final PersonalRepository personalRepository;

    public Personal save(Personal personal){
       return personalRepository.persist(personal);
    }
    public Personal update(Personal personal){
        return personalRepository.update(personal);
    }
}
