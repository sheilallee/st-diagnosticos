package stdiagnosticos.io;


import java.io.*;
import java.nio.file.*;
import java.util.*;


public final class CsvUtils {
    private CsvUtils() {}
    public static List<String[]> lerCSV(Path arquivo, String separador) throws IOException {
        List<String[]> linhas = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(arquivo)) {
            String line; boolean header = true;
            while ((line = br.readLine()) != null) {
                if (header) { header = false; continue; }
                String[] cols = line.split(separador);
                for (int i=0;i<cols.length;i++) cols[i] = cols[i].trim();
                linhas.add(cols);
            }
        }
        return linhas;
    }


    public static void escreverSeNaoExiste(Path arquivo, String conteudo) throws IOException {
        if (!Files.exists(arquivo)) {
            Files.createDirectories(arquivo.getParent());
            Files.writeString(arquivo, conteudo);
        }
    }
}