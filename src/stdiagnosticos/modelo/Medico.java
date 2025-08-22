package stdiagnosticos.modelo;

public class Medico {
    private final String nome;
    private final String crm;
    private final String especialidade;

    public Medico(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return String.format("Dr(a). %s (CRM: %s) - %s", nome, crm, especialidade);
    }
}
