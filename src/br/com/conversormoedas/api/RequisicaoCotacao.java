package br.com.conversormoedas.api;

import java.net.URI;
import java.net.http.HttpRequest;

public class RequisicaoCotacao {
    public HttpRequest construirRequisicao(String url){
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }
}
