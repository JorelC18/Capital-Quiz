package com.example.caps;

import java.util.List;
import java.util.Map;

import ca.roumani.i2c.*;

public class Game {

    private CountryDB db;

    public Game() {
        this.db = new CountryDB();
    }

    public String qa() {
        List<String> capitals = db.getCapitals();
        int n = capitals.size();
        int index = (int) (n * Math.random()); //Random Index
        String c = capitals.get(index);
        Map<String, Country> data = db.getData();
        Country ref = data.get(c); //Holds Country, Capital & Population
        String s = "";

        if (Math.random() < 0.5) {
            s += "What is the capital of " + ref.getName() + "?";
            s += "\n";
            s += ref.getCapital();
            return s;
        } else {
            s += ref.getCapital() + " is the capital of?";
            s += "\n";
            s += ref.getName();
            return s;
        }
    }

}
