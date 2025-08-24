package stdiagnosticos.seq;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GeradorSequencial {
    private static GeradorSequencial instancia;
    private long atual;
    private final String ARQUIVO_SEQUENCIA = "src/stdiagnosticos/seq/sequencia.txt";
    
    private GeradorSequencial() {
        carregarSequencia();
    }
    
    public static synchronized GeradorSequencial getInstancia() {
        if (instancia == null) {
            instancia = new GeradorSequencial();
        }
        return instancia;
    }
    
    public synchronized long proximoNumero() {
        long numero = atual++;
        salvarSequencia();
        return numero;
    }
    
    public synchronized void reiniciar(long inicio) {
        this.atual = inicio;
        salvarSequencia();
    }
    
    private void carregarSequencia() {
        try {
            Path caminho = Paths.get(ARQUIVO_SEQUENCIA);
            if (Files.exists(caminho)) {
                try (BufferedReader reader = Files.newBufferedReader(caminho)) {
                    String linha = reader.readLine();
                    if (linha != null && !linha.trim().isEmpty()) {
                        atual = Long.parseLong(linha.trim());
                        System.out.println("Sequência carregada: " + atual);
                    } else {
                        atual = 1L;
                    }
                }
            } else {
                atual = 1L; // valor padrão
                salvarSequencia(); // cria o arquivo inicial
                System.out.println("Arquivo de sequência criado com valor inicial: " + atual);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao carregar sequência: " + e.getMessage());
            atual = 1L; // fallback para valor padrão
        }
    }
    
    private void salvarSequencia() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_SEQUENCIA))) {
            writer.println(atual);
        } catch (IOException e) {
            System.err.println("Erro ao salvar sequência: " + e.getMessage());
        }
    }
    
    // Método para obter o número atual sem incrementar
    public synchronized long getAtual() {
        return atual;
    }
    
    // Método para forçar salvamento (útil em shutdown hooks)
    public synchronized void salvar() {
        salvarSequencia();
    }
}