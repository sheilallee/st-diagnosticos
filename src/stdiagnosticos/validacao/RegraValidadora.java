package stdiagnosticos.validacao;


import stdiagnosticos.exame.*;


public interface RegraValidadora {
    ResultadoChecagem validar(ExameClinico exame);
    void encadear(RegraValidadora proxima);
}