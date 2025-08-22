package stdiagnosticos.exame;


import stdiagnosticos.modelo.*;


public class RessonanciaEx extends ExameClinico {
    private String regiao;
    private boolean usoContraste;
    private boolean possuiImplanteMetalico;


    public RessonanciaEx(Paciente p, Medico m, double precoBase) {
        super(p, m, precoBase);
    }


    @Override public String getTipo() { return "RESSONANCIA"; }


    public String getRegiao() { return regiao; }
    public void setRegiao(String regiao) { this.regiao = regiao; }


    public boolean isUsoContraste() { return usoContraste; }
    public void setUsoContraste(boolean usoContraste) { this.usoContraste = usoContraste; }


    public boolean isPossuiImplanteMetalico() { return possuiImplanteMetalico; }
    public void setPossuiImplanteMetalico(boolean possuiImplanteMetalico) { this.possuiImplanteMetalico = possuiImplanteMetalico; }
}