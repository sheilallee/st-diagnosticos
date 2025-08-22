package stdiagnosticos.validacao;


import stdiagnosticos.exame.*;


public final class MontadorCadeiaValidacao {
    private MontadorCadeiaValidacao() {}
    public static RegraValidadora para(ExameClinico e) {
    if (e instanceof HemogramaEx) {
            return encadear(new ValidaLimitesHemograma());
        } else if (e instanceof RessonanciaEx) {
            return encadear(new ValidaImplantesRessonancia());
        } else if (e instanceof UltrassonografiaEx) {
            // poderia haver validações específicas
            return null; // sem validação obrigatória
        }
        return null;
    }
    private static RegraValidadora encadear(RegraValidadora v) { return v; }
}