package stdiagnosticos.preco;


public class GestorDePreco {
    private PoliticaDesconto politica;
    public void definirPolitica(PoliticaDesconto politica) { 
        this.politica = politica; 
    }
    public double calcularPreco(double precoBase) {
        if (politica == null) 
            return precoBase;
        return politica.aplicar(precoBase);
    }
}