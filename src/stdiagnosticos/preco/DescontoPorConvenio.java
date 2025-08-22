package stdiagnosticos.preco;


public class DescontoPorConvenio implements PoliticaDesconto {
    private final double percentual; // ex.: 0.15
    public DescontoPorConvenio(double percentual) { this.percentual = percentual; }
    @Override public double aplicar(double precoBase) { return precoBase * (1.0 - percentual); }
}