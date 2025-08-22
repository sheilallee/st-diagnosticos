package stdiagnosticos.exame;


import stdiagnosticos.modelo.*;


public class HemogramaEx extends ExameClinico {
    private double hemoglobina; // g/dL
    private double hematocrito; // %
    private double leucocitos; // /mm³


    public HemogramaEx(Paciente p, Medico m, double precoBase) {
    super(p, m, precoBase);
    }


    @Override public String getTipo() { return "HEMOGRAMA"; }


    public double getHemoglobina() { return hemoglobina; }
    public void setHemoglobina(double hemoglobina) { this.hemoglobina = hemoglobina; }


    public double getHematocrito() { return hematocrito; }
    public void setHematocrito(double hematocrito) { this.hematocrito = hematocrito; }


    public double getLeucocitos() { return leucocitos; }
    public void setLeucocitos(double leucocitos) { this.leucocitos = leucocitos; }
}