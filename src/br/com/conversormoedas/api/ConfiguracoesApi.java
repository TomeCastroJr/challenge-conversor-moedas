package br.com.conversormoedas.api;

public class ConfiguracoesApi {
    private static String API_KEY = "5109ab11b9fb4000b934e328cced84dd";
    private static String URL_BASE = "https://api.currencyfreaks.com/v2.0/rates/latest";

    public static String getApiKey(){
        return API_KEY;
    }

    public static String getUrlBase(){
        return URL_BASE;
    }
}
