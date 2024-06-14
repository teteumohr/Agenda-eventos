package Evento;

class Evento {
    private String nome;
    private int vagasDisponiveis;
    private String estado;
    private int horario;

    public Evento(String nome, int vagasDisponiveis, String estado, int horario) {
        this.nome = nome;
        this.vagasDisponiveis = vagasDisponiveis;
        this.estado = estado;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public String getEstado() {
        return estado;
    }

    public int getHorario() {
        return horario;
    }

    public void decrementarVagas() {
        vagasDisponiveis--;
    }
}
