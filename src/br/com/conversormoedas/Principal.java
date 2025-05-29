package br.com.conversormoedas;

import br.com.conversormoedas.api.ClienteHttpCotacao;
import br.com.conversormoedas.api.RequisicaoCotacao;
import br.com.conversormoedas.api.RespostaCotacaoCompleta;
import br.com.conversormoedas.utils.ConversorMoeda;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        ClienteHttpCotacao cliente = new ClienteHttpCotacao();

        while(true){
            System.out.println("\n===== CONVERSOR DE MOEDAS =====\n");

            System.out.println("Moedas disponíveis (sigla / nome):");
            System.out.println("USD - Dólar Americano");
            System.out.println("BRL - Real Brasileiro");
            System.out.println("ARS - Peso Argentino");
            System.out.println("COP - Peso Colombiano");
            System.out.println("EUR - Euro");
            System.out.println("GBP - Libra Esterlina");
            System.out.println("JPY - Iene Japonês");
            System.out.println("CAD - Dólar Canadense");
            System.out.println("BTC - Bitcoin");
            System.out.println("Digite 'SAIR' a qualquer momento para encerrar.\n");

            RespostaCotacaoCompleta resposta = cliente.consultarTodasAsTaxas();
            Map<String, String> taxas = resposta.rates();

            System.out.println("Digite a sigla da moeda de ORIGEM:");
            String moedaOrigem = scanner.next().trim().toUpperCase();
            if(moedaOrigem.equals("SAIR")) break;

            if(!taxas.containsKey(moedaOrigem)){
                System.out.println("Moeda inválida ou não suportada. Tente novamente");
                continue;
            }

            System.out.println("Digite a sigla da moeda de DESTINO:");
            String moedaDestino = scanner.next().trim().toUpperCase();
            if(moedaDestino.equals("SAIR")) break;

            if(!taxas.containsKey(moedaDestino)){
                System.out.println("Moeda inválida ou não suportada. Tente novamente");
                continue;
            }

            System.out.printf("Digite o valor em %s: ", moedaOrigem);
            if (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido. Use ponto como separador decimal.");
                scanner.next();
                continue;
            }

            double valor = scanner.nextDouble();
            double valorConvertido = ConversorMoeda.converter(moedaOrigem, moedaDestino, valor, taxas);

            System.out.println("\n**********************************************************");
            System.out.printf("Conversão de %s para %s:\n", moedaOrigem, moedaDestino);
            System.out.printf("Valor inserido: %.2f %s\n", valor, moedaOrigem);
            System.out.printf("Valor convertido: %.2f %s\n", valorConvertido, moedaDestino);
            System.out.println("**********************************************************\n");

        }
        System.out.println("Programa encerrado.");
    }
}
