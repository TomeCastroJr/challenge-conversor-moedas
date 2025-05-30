package br.com.conversormoedas.historico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoConversao {

    private static final String ARQUIVO_HISTORICO = "historico_conversoes.txt";

    public static void registrar(String moedaOrigem, String moedaDestino, double valor, double valorConvertido) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_HISTORICO, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            writer.printf("[%s] %.2f %s → %.2f %s\n", timestamp, valor, moedaOrigem, valorConvertido, moedaDestino);
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico de conversão: " + e.getMessage());
        }
    }
}
