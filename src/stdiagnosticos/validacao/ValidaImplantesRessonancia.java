package stdiagnosticos.validacao;


import stdiagnosticos.exame.*;


public class ValidaImplantesRessonancia extends ValidadorEncadeado {
    @Override protected ResultadoChecagem checar(ExameClinico exame) {
        if (exame instanceof RessonanciaEx r) {
            if (r.isPossuiImplanteMetalico())
                return ResultadoChecagem.erro("Ressonância contraindicada: implante metálico detectado");
        }
        return ResultadoChecagem.ok();
    }
}