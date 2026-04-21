package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Preparando as coisas
        Scanner leitor = new Scanner(System.in);
        ArrayList<Usuario> listaGeral = new ArrayList<>();
        ArrayList<Projeto> listaProjetos = new ArrayList<>();


        int opcao = -1;

        // MENU COM WHILE E SWITCH
        while (opcao != 0) {
            System.out.println("\n--- MENU DO SISTEMA ---");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Listar Usuarios");
            System.out.println("3 - Criar Projeto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpando o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Nome do usuario: ");
                    String n = leitor.nextLine();
                    System.out.print("Cargo: ");
                    String c = leitor.nextLine();

                    // IF e ELSE para validação simples
                    if (n.equals("")) {
                        System.out.println("Erro: O nome nao pode ser vazio!");
                    } else {
                        listaGeral.add(new Usuario(n, "000", c));
                        System.out.println("Usuario cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- LISTA DE USUARIOS ---");
                    // FOR tradicional para listar
                    for (int i = 0; i < listaGeral.size(); i++) {
                        System.out.println(i + " - " + listaGeral.get(i).nome);
                    }
                    break;

                case 3:
                    System.out.print("Nome do Projeto: ");
                    String nomeP = leitor.nextLine();

                    // IF para checar se tem gente no sistema antes de criar projeto
                    if (listaGeral.isEmpty()) {
                        System.out.println("Erro: Cadastre um usuario antes!");
                    } else {
                        // Pega o primeiro da lista como gerente por padrão
                        Projeto novoP = new Projeto(nomeP, listaGeral.get(0));
                        listaProjetos.add(novoP);
                        System.out.println("Projeto criado e vinculado ao gerente: " + listaGeral.get(0).nome);
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
        leitor.close();
    }
}
