package br.com.conversormoedas.api;

import java.util.Map;

public record RespostaCotacaoCompleta(String date, String base, Map<String, String> rates) {

}
