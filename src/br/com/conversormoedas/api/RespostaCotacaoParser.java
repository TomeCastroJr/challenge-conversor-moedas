package br.com.conversormoedas.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RespostaCotacaoParser {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static RespostaCotacaoCompleta parse (String json){
        return gson.fromJson(json, RespostaCotacaoCompleta.class);
    }
}
