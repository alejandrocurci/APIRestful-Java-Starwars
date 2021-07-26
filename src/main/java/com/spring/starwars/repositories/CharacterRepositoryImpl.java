package com.spring.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.starwars.dtos.CharacterDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    @Override
    public List<CharacterDTO> loadCharacters() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeReference = new TypeReference<List<CharacterDTO>>() {};
        List<CharacterDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return characters;
    }
}
