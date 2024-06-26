package Evento;

import java.util.Scanner;

public class Main {
    private static final GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();
    private static final GerenciadorEventos gerenciadorEventos = new GerenciadorEventos();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema de cadastro de usuários!");
        System.out.println("Por favor, cadastre-se para continuar.");
        System.out.print("Digite seu nome: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String emailUsuario = scanner.nextLine();
        System.out.print("Digite o estado (UF) onde você está: ");
        String estadoUsuario = scanner.nextLine();
        gerenciadorUsuarios.cadastrarUsuario(nomeUsuario, emailUsuario, estadoUsuario);

        boolean eventosEncontrados = false;

        System.out.println("\nEventos que estão para acontecer em sua região (" + estadoUsuario + "):");
        for (Evento evento : gerenciadorEventos.getEventos()) {
            if (evento.getEstado().equalsIgnoreCase(estadoUsuario)) {
                eventosEncontrados = true;
                System.out.println("Nome: " + evento.getNome() + ", Vagas: " + evento.getVagasDisponiveis() + ", Estado: " + evento.getEstado() + ", Horário: " + evento.getHorario() + " horas");

            }
        }

        if (!eventosEncontrados) {
            System.out.println("Não temos eventos disponíveis em sua região");
        }

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1. Criar evento");
            System.out.println("2. Verificar eventos");
            System.out.println("3. Marcar presença em algum evento");
            System.out.println("4. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Criar evento
                    System.out.println("Digite o nome do evento (ou 'v' para voltar ao menu):");
                    String nomeEventoInput = scanner.nextLine();
                    if (nomeEventoInput.equalsIgnoreCase("v")) {
                        break;
                    }
                    int vagasEvento;
                    String estadoEvento;
                    int horarioEvento;
                    try {
                        System.out.println("Digite a quantidade de vagas disponíveis:");
                        vagasEvento = Integer.parseInt(scanner.nextLine());
                        System.out.println("Digite o estado do evento");
                        estadoEvento = scanner.nextLine();
                        System.out.println("Digite o horário do evento:");
                        horarioEvento = Integer.parseInt(scanner.nextLine());
                        gerenciadorEventos.adicionarEvento(nomeEventoInput, vagasEvento, estadoEvento, horarioEvento);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida. Certifique-se de inserir um número para vagas e horário.");
                    }
                    break;

                case 2:
                    // Exibir eventos cadastrados
                    System.out.println("\nEventos cadastrados:");
                    for (Evento evento : gerenciadorEventos.getEventos()) {
                        System.out.println("Nome: " + evento.getNome() + ", Vagas: " + evento.getVagasDisponiveis() +
                                ", Estado: " + evento.getEstado() + ", Horário: " + evento.getHorario());
                    }
                    break;

                case 3:
                    //Marcar presença em um evento
                    System.out.println("Digite o nome do evento que você deseja marcar presença:");
                    String nomeEventoPresenca = scanner.nextLine();
                    boolean eventoEncontrado = false;
                    for (Evento evento : gerenciadorEventos.getEventos()) {
                        if (evento.getNome().equalsIgnoreCase(nomeEventoPresenca)) {
                            eventoEncontrado = true;
                            if (evento.getVagasDisponiveis() > 0) {
                                evento.decrementarVagas();
                                System.out.println("Presença marcada com sucesso no evento: " + evento.getNome());
                            } else if (evento.getVagasDisponiveis() == 0) {
                                System.out.println("Não há vagas disponíveis para este evento.");
                            } else {
                                System.out.println("Não há vagas disponíveis para este evento.");
                            }
                            break;
                        }
                    }
                    if (!eventoEncontrado) {
                    System.out.println("Evento não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa. Até mais!");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
            }
        }
    }
}
