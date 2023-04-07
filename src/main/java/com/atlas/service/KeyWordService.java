package com.atlas.service;

import com.atlas.repository.KeyWordRepository;
import com.atlas.models.KeyWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeyWordService {

    private KeyWordRepository keyWordRepository;

    @Autowired
    public KeyWordService(KeyWordRepository keyWordRepository) {
        this.keyWordRepository = keyWordRepository;
    }

    public KeyWord getKeyWordById(long id) {
       Optional<KeyWord> keyWord = keyWordRepository.findById(id);
       if (keyWord.isPresent()) {
           return keyWord.get();
       } else {
           throw new RuntimeException("KeyWord not found");
       }
    }

    public Class getKeyWordByName(String name){ 
        Optional<KeyWord> keyWord = keyWordRepository.findByName(name);
           if (keyWord.isPresent()) {
           return keyWord.get();
       } else {
           throw new RuntimeException("KeyWord not found");
       }
    }

    public List<KeyWord> getAllKeyWords() {
        return keyWordRepository.findAll();
    }

    public KeyWord addKeyWord(KeyWord keyWord) {
        return keyWordRepository.save(keyWord);
    }

    public KeyWord updateKeyWord(KeyWord keyWord) {
        return keyWordRepository.save(keyWord);
    }

    public void deleteKeyWord(long id) {
        keyWordRepository.deleteById(id);
    }

}