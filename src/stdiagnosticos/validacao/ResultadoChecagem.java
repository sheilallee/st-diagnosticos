package stdiagnosticos.validacao;


public record ResultadoChecagem(boolean aprovado, String mensagem) {
    public static ResultadoChecagem ok() { return new ResultadoChecagem(true, "OK"); }
    public static ResultadoChecagem erro(String msg) { return new ResultadoChecagem(false, msg); }
    @Override public String toString() { return (aprovado?"APROVADO":"REPROVADO") + (mensagem==null?"":" — "+mensagem); }
}