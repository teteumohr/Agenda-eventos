package Evento;

import java.util.ArrayList;
import java.util.List;

class GerenciadorEventos {
    private List<Evento> eventos;

    public GerenciadorEventos() {
        eventos = new ArrayList<>();
        eventos.add(new Evento("Green Valley", 3000, "SC", 14));
        eventos.add(new Evento("P12", 1500, "SC", 14));
        eventos.add(new Evento("Musik Parck", 1000, "SC", 22));
    }

    public void adicionarEvento(String nome, int vagasDisponiveis, String estado, int horario) {
        if (eventos == null) {
            eventos = new ArrayList<>();
        }
        Evento novoEvento = new Evento(nome, vagasDisponiveis, estado, horario);
        eventos.add(novoEvento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    public List<Evento> getEventos() {
        return eventos;
    }
}
