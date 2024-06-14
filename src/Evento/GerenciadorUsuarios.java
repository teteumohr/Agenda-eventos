package Evento;

import java.util.ArrayList;
import java.util.List;

class GerenciadorUsuarios {
    private List<Usuario> usuarios;

    public GerenciadorUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(String nome, String email, String estado) {
        Usuario novoUsuario = new Usuario(nome, email, estado);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }
}
