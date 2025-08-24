package stdiagnosticos.preco;

import java.util.List;

public class PoliticaDescontoComposta implements PoliticaDesconto {
    private final List<PoliticaDesconto> politicas;

    public PoliticaDescontoComposta(List<PoliticaDesconto> politicas) {
        this.politicas = politicas;
    }

    @Override
    public double aplicar(double precoBase) {
        double valor = precoBase;
        for (PoliticaDesconto p : politicas) {
            valor = p.aplicar(valor);
        }
        return valor;
    }
}
