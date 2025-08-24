package stdiagnosticos.fila;


import java.util.concurrent.atomic.AtomicLong;
import stdiagnosticos.exame.ExameClinico;
import stdiagnosticos.modelo.Prioridade;


public class ExamePrioritario implements Comparable<ExamePrioritario> {
    private static final AtomicLong SEQ_FIFO = new AtomicLong(0);
    private final long ordemChegada = SEQ_FIFO.getAndIncrement();


    private final ExameClinico exame;
    private final Prioridade prioridade;


    public ExamePrioritario(ExameClinico exame, Prioridade prioridade) {
        this.exame = exame; this.prioridade = prioridade;
    }


    public ExameClinico getExame() { return exame; }
    public Prioridade getPrioridade() { return prioridade; }


    @Override public int compareTo(ExamePrioritario o) {
        // compara primeiro pela prioridade (urgência)
        int c = Integer.compare(this.prioridade.getOrdem(), o.prioridade.getOrdem());
        if (c != 0) return c;
        // se a prioridade for igual, mantém ordem de chegada (FIFO)
        return Long.compare(this.ordemChegada, o.ordemChegada);
    }
}