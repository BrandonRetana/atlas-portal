package com.atlas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "KeyWord")
public class KeyWord{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String keyWord;

    public KeyWord(String keyword){
        this.keyWord = keyWord;
    }

    public KeyWord (){}

    public String getkeyWord() {
        return keyWord;
    }

    public void setkeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    
}


