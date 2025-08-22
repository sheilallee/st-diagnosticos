package stdiagnosticos.fila;


import java.util.*;
import stdiagnosticos.exame.ExameClinico;
import stdiagnosticos.modelo.Prioridade;


public class FilaExames {
    private final PriorityQueue<ExamePrioritario> fila = new PriorityQueue<>();
    public void adicionar(ExameClinico e, Prioridade p) { fila.add(new ExamePrioritario(e, p)); }
    public ExamePrioritario proximo() { return fila.poll(); }
    public boolean vazia() { return fila.isEmpty(); }
}