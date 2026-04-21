package projeto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceSistema extends JFrame {
    // Componentes da tela (campos de digitar)
    private JTextField txtNome, txtCpf, txtCargo;
    private JTextArea areaLista;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public InterfaceSistema() {
        // Configurações da Janela
        setTitle("LogicTree - Cadastro de usários");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Organiza em áreas (Norte, Centro, Sul)

        // --- PAINEL DE ENTRADA (Cima) ---
        JPanel painelEntrada = new JPanel(new GridLayout(4, 2, 5, 5));
        painelEntrada.setBorder(BorderFactory.createTitledBorder("Dados do Usuário"));

        painelEntrada.add(new JLabel(" Nome Completo:"));
        txtNome = new JTextField();
        painelEntrada.add(txtNome);

        painelEntrada.add(new JLabel(" CPF:"));
        txtCpf = new JTextField();
        painelEntrada.add(txtCpf);

        painelEntrada.add(new JLabel(" Cargo/Função:"));
        txtCargo = new JTextField();
        painelEntrada.add(txtCargo);

        JButton btnSalvar = new JButton("Salvar Cadastro");
        painelEntrada.add(btnSalvar);

        JButton btnLimpar = new JButton("Limpar Campos");
        painelEntrada.add(btnLimpar);

        // --- PAINEL DE LISTAGEM (Centro) ---
        areaLista = new JTextArea();
        areaLista.setEditable(false); // Usuário não pode apagar o texto da lista
        JScrollPane scroll = new JScrollPane(areaLista); // Barra de rolagem se a lista crescer
        scroll.setBorder(BorderFactory.createTitledBorder("Usuários Cadastrados"));

        // Adicionando os painéis na janela principal
        add(painelEntrada, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // --- LÓGICA DOS BOTÕES ---

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText();
                String cpf = txtCpf.getText();
                String cargo = txtCargo.getText();

                // Validação simples (if/else)
                if (nome.isEmpty() || cpf.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha o Nome e o CPF!");
                } else {
                    // Cria o objeto usando a sua classe Usuario
                    Usuario novo = new Usuario(nome, cpf, "Colaborador");
                    novo.cargo = cargo; // Atribuindo o cargo digitado

                    listaUsuarios.add(novo);

                    // Atualiza a lista visual
                    areaLista.append("Nome: " + nome + " | CPF: " + cpf + " | Cargo: " + cargo + "\n");

                    // Limpa os campos para o próximo
                    txtNome.setText("");
                    txtCpf.setText("");
                    txtCargo.setText("");

                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtCpf.setText("");
                txtCargo.setText("");
                areaLista.setText("");
                listaUsuarios.clear();
            }
        });

        // Centralizar
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        // Tenta deixar o visual com a cara do Windows
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }

        new InterfaceSistema().setVisible(true);
    }

}


