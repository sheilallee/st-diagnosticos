package stdiagnosticos.preco;


public class DescontoParaIdoso implements PoliticaDesconto {
    private final double percentual; // ex.: 0.08
    public DescontoParaIdoso(double percentual) { this.percentual = percentual; }
    @Override public double aplicar(double precoBase) { return precoBase * (1.0 - percentual); }
}