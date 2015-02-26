package com.st1x.placeautocomplete.lib.googleplaces.models;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Prediction  implements Serializable{

    private String id;
    private String description;
    private ArrayList<MatchedSubstring> matched_substrings;
    private String reference;
    private ArrayList<Term> terms;
    private ArrayList<String> types;


    public Prediction(JSONObject jsonObject) {
        Gson gson = new Gson();
        gson.fromJson(jsonObject.toString(), Prediction.class);
    }

    private class MatchedSubstring implements  Serializable {
        private int length;
        private int offset;
    }

    public static class Term implements  Serializable{
        public int offset;
        public String value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<MatchedSubstring> getMatchedSubstrings() {
        return matched_substrings;
    }

    public String getReference() {
        return reference;
    }

    public ArrayList<Term> getTerms() {
        return terms;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public boolean containTerm(String constraint){

        for(Term term :getTerms()){

            if(term.value.toLowerCase().equals(constraint.toLowerCase())){return true;}

        }

            return false;

    }

    @Override
    public String toString() {
        return description;
    }
}
