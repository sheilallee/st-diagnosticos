package stdiagnosticos.modelo;


public enum Prioridade {
URGENTE(0), POUCO_URGENTE(1), ROTINA(2);
private final int ordem;
Prioridade(int ordem) { this.ordem = ordem; }
public int getOrdem() { return ordem; }
}