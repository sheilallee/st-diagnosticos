package stdiagnosticos.laudo;


import stdiagnosticos.exame.*;


public interface FormatoLaudo {
    String gerar(ExameClinico exame);
}