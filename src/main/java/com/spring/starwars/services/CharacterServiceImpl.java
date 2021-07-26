package com.spring.starwars.services;

import com.spring.starwars.dtos.CharacterDTO;
import com.spring.starwars.exceptions.CharacterException;
import com.spring.starwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository repository;

    @Override
    public List<CharacterDTO> findCharacters(String name) throws CharacterException {
        List<CharacterDTO> characters = repository.loadCharacters();
        List<CharacterDTO> charactersResult = new ArrayList<>();
        if (!characters.isEmpty()) {
            for (CharacterDTO p : characters) {
                if (p.getName().contains(name)) {
                    charactersResult.add(p);
                }
            }
        }
        if (charactersResult.isEmpty()) {
            throw new CharacterException("No characters were found");
        }
        return charactersResult;
    }
}
