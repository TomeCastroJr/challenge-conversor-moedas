package br.com.conversormoedas.utils;

import java.util.Map;

public class ConversorMoeda {
    public static double converter(String origem, String destino, double valor, Map<String, String> taxas){
        if(!taxas.containsKey(origem) || !taxas.containsKey(destino)){
            throw new IllegalArgumentException("Moeda não encontrada no mapa de taxas");
        }

        double taxaOrigem = Double.parseDouble(taxas.get(origem));
        double taxadestino = Double.parseDouble(taxas.get(destino));

        return valor * (taxadestino / taxaOrigem);
    }
}
