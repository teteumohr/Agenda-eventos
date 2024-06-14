package Evento;

class Usuario {
    private String nome;
    private String email;
    private String estado;

    public Usuario(String nome, String email, String estado) {
        this.nome = nome;
        this.email = email;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getEstado() {
        return estado;
    }
}
