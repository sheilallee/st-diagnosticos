package stdiagnosticos.validacao;


import stdiagnosticos.exame.*;


public abstract class ValidadorEncadeado implements RegraValidadora {
    private RegraValidadora proxima;
    @Override public void encadear(RegraValidadora proxima) { this.proxima = proxima; }


    @Override public ResultadoChecagem validar(ExameClinico exame) {
        ResultadoChecagem atual = checar(exame);
        if (!atual.aprovado()) return atual;
        return (proxima != null) ? proxima.validar(exame) : atual;
    }


    protected abstract ResultadoChecagem checar(ExameClinico exame);
}