package stdiagnosticos.io;


import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import stdiagnosticos.modelo.*;
import stdiagnosticos.seq.GeradorSequencial;


public final class LoaderDados {
    private LoaderDados() {}


    public static void criarArquivosExemploSeNecessario(Path pastaDados) throws IOException {
        String pacientes = String.join("\n",
            "Nome;Nascimento;Telefone;Email;PossuiConvenio",
            "Alberto Lima;1981-05-11;(83) 98888-1111;alberto.lima@gmail.com;true",
            "Beatriz Rocha;1950-02-02;(83) 97777-2222;beatriz.rocha@gmail.com;false",
            "Caio Nogueira;1999-11-23;(83) 96666-3333;caio.ng@gmail.com;true",
            "Diana Almeida;1963-07-07;(83) 95555-4444;diana.almeida@gmail.com;true",
            "Eurico Farias;2002-04-30;(83) 94444-5555;eurico.farias@gmail.com;false",
            "Daniel Soares;2001-01-12;(83) 98888-8888;daniel.soares@gmail.com;false"
        );
        String medicos = String.join("\n",
            "Nome;CRM;Especialidade",
            "Dra. Helena Prado;1001;Hematologia",
            "Dr. Renato Azevedo;1002;Radiologia",
            "Dra. Soraia Matos;1003;Clínica Geral",
            "Dr. Ícaro Teles;1004;Ultrassonografia",
            "Dra. Paula Vieira;1005;Cardiologia",
            "Dra. Daniela Lima;1007;Cardiologia"
        );
        CsvUtils.escreverSeNaoExiste(pastaDados.resolve("pacientes.csv"), pacientes + "\n");
        CsvUtils.escreverSeNaoExiste(pastaDados.resolve("medicos.csv"), medicos + "\n");
        // reinicia contador para reproduzir numeração sempre que criar de novo
        GeradorSequencial.getInstancia().reiniciar(1);
    }


    public static List<Paciente> carregarPacientes(Path arquivo) throws IOException {
        List<Paciente> lista = new ArrayList<>();
        List<String[]> linhas = CsvUtils.lerCSV(arquivo, ";");
        long id = 1;
        for (String[] c : linhas) {
            String nome = c[0];
            LocalDate nasc = LocalDate.parse(c[1]);
            String fone = c[2];
            String email = c[3];
            boolean conv = Boolean.parseBoolean(c[4]);
            lista.add(new Paciente(id++, nome, nasc, fone, email, conv));
        }
        return lista;
    }


    public static List<Medico> carregarMedicos(Path arquivo) throws IOException {
        List<Medico> lista = new ArrayList<>();
        List<String[]> linhas = CsvUtils.lerCSV(arquivo, ";");
        for (String[] c : linhas) {
            lista.add(new Medico(c[0], c[1], c[2]));
        }
        return lista;
    }
}