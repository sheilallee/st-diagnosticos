package stdiagnosticos.modelo;


import java.time.*;
import java.time.temporal.ChronoUnit;


public class Paciente {
    private final long id;
    private final String nomeCompleto;
    private final LocalDate nascimento;
    private final String fone;
    private final String email;
    private final boolean possuiConvenio;


    public Paciente(long id, String nomeCompleto, LocalDate nascimento, String fone, String email, boolean possuiConvenio) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nascimento = nascimento;
        this.fone = fone;
        this.email = email;
        this.possuiConvenio = possuiConvenio;
    }


    public long getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }
    public LocalDate getNascimento() { return nascimento; }
    public String getFone() { return fone; }
    public String getEmail() { return email; }
    public boolean isPossuiConvenio() { return possuiConvenio; }


    public int getIdade() {
        return (int) ChronoUnit.YEARS.between(nascimento, LocalDate.now());
    }
}