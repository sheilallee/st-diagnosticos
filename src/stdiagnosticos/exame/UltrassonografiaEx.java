package stdiagnosticos.exame;


import stdiagnosticos.modelo.*;
import stdiagnosticos.servico.BancoDeDoencasReal;


public class UltrassonografiaEx extends ExameClinico {
    private String orgao;
    private String achados;
    private String medidas;

    public UltrassonografiaEx(Paciente p, Medico m, double precoBase) {
    super(p, m, precoBase);
    }


    @Override public String getTipo() { return "ULTRASSONOGRAFIA"; }

    public String getOrgao() { return orgao; }
    public void setOrgao(String orgao) { this.orgao = orgao; }

    public String getAchados() { return achados; }
    public void setAchados(String achados) { this.achados = achados; }

    public String getMedidas() { return medidas; }
    public void setMedidas(String medidas) { this.medidas = medidas; }

    public String getLaudo() {
        return "Lesão Tecidual";
    }
}