package br.com.conversormoedas.api;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static br.com.conversormoedas.api.ConfiguracoesApi.getApiKey;
import static br.com.conversormoedas.api.ConfiguracoesApi.getUrlBase;

public class ClienteHttpCotacao {
    private final HttpClient cliente = HttpClient.newHttpClient();

    public RespostaCotacaoCompleta consultarTodasAsTaxas(){
        String url = getUrlBase()  + "?apikey=" + getApiKey();
        HttpRequest requisicao = RequisicaoCotacao.construirRequisicao(url);

        try{
            HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());

            if(resposta.statusCode() != 200){
                throw new RuntimeException("Erro ao consultar API" + resposta.statusCode());
            }

            return RespostaCotacaoParser.parse(resposta.body());

        }catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
