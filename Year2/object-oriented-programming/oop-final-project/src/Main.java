import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Aula> aulas = new ArrayList<>();
    private static Horario horario = new Horario();
    private static ArrayList<Pessoa> pessoas_registadas = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gerenciador de Aulas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setAlwaysOnTop(true);

        JPanel panel = new JPanel();
        frame.add(panel);

        GridLayout layout = new GridLayout(4, 1);
        panel.setLayout(layout);

        JButton verHorarioButton = new JButton("Ver Horário");
        JButton adicionarDadosButton = new JButton("Adicionar Dados");
        JButton consultarAulasButton = new JButton("Consultar Aulas");
        JButton eliminarAulasButton = new JButton("Eliminar Aulas");

        panel.add(verHorarioButton);
        panel.add(adicionarDadosButton);
        panel.add(consultarAulasButton);
        panel.add(eliminarAulasButton);

        aulas = (ArrayList<Aula>) Ficheiro.verAula();
        for (Aula aula : aulas) {
            horario.adicionarAula(aula);
        }

        verHorarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                horario.imprimirHorario();
            }
        });

        adicionarDadosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para adicionar dados
                Scanner sc = new Scanner(System.in);
                System.out.println("____________________________________________________________________\n");

                System.out.println("Indique o dia da semana da Aula (Segunda, Terça, Quarta, Quinta, Sexta): ");
                String dia = sc.nextLine();

                System.out.println("Indique a Hora da Aula (no formato hh:00): ");
                String hora = sc.nextLine();

                System.out.println("____________________________________________________________________\n");

                System.out.println("Indique o nome do Trainer da Aula: ");
                String nomeTrainer = sc.nextLine();

                System.out.println("Indique a data de nascimento do Trainer (no formato dd/mm/aaaa): ");
                String dobTrainer = sc.nextLine();

                System.out.println("Indique o sexo do Trainer: ");
                String sexoTrainer = sc.nextLine();

                System.out.println("Indique a especialidade do Trainer: ");
                String especialidadeTrainer = sc.nextLine();

                System.out.println("Indique os anos de experiência do Trainer: ");
                int anosExperienciaTrainer = sc.nextInt();
                sc.nextLine(); // Consume newline left-over

                Trainer trainer = new Trainer(nomeTrainer, dobTrainer, sexoTrainer, especialidadeTrainer, anosExperienciaTrainer);

                System.out.println("____________________________________________________________________\n");

                System.out.println("Digite o nome da aula:");
                String nome = sc.nextLine();


                ArrayList<Aluno> participantes = new ArrayList<>();
                ArrayList<Pessoa> pessoas_registadas = new ArrayList<>();

                while (true) {
                    System.out.println("____________________________________________________________________\n");
                    System.out.println("Insira o(s) Nome(s) do(s) Participante(s), Quando concluido digite 'sair': ");
                    String nome_pessoa = sc.nextLine();
                    if (nome_pessoa.equalsIgnoreCase("sair")) {
                        break;
                    }
                    boolean alunoEncontrado = false;
                    for (int i=0; i<pessoas_registadas.size(); i++) {
                        if (pessoas_registadas.get(i).getNome().equals(nome_pessoa)) {
                            participantes.add((Aluno) pessoas_registadas.get(i));
                            alunoEncontrado = true;
                            break;
                        }
                    }
                    if (!alunoEncontrado) {

                        System.out.println("Digite a data de nascimento do aluno (no formato dd/mm/aaaa):");
                        String dob = sc.nextLine();

                        System.out.println("Digite o sexo do aluno:");
                        String sexo = sc.nextLine();

                        System.out.println("Digite o nível do aluno (por exemplo, Iniciante, Intermediário, Avançado):");
                        String nivel = sc.nextLine();

                        System.out.println("Digite o objetivo do aluno (por exemplo, Perda de peso, Ganho de massa muscular):");
                        String objetivo = sc.nextLine();

                        Aluno novoAluno = new Aluno(nome_pessoa, dob, sexo, nivel, objetivo);
                        participantes.add(novoAluno);

                    }
                }

                System.out.println("____________________________________________________________________\n");

                Aula aula = new Aula(hora, dia, trainer, nome, participantes);
                aula.setParticipantes(participantes);
                horario.adicionarAula(aula);
                Ficheiro.inserirAula(aula);

                System.out.println("Foi Criada a Aula. \nDia: "+dia+" às "+hora+"\nTrainer: "+trainer.getNome()
                        +"\n\n____________________________________________________________________\n|  Participantes  |\n"+aula.mostrarParticipantes());
            }
        });

        consultarAulasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("____________________________________________________________________\n");
                consultarAulas();
            }
        });


        eliminarAulasButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Scanner sc = new Scanner(System.in);
                System.out.println("____________________________________________________________________\n");

                System.out.println("Digite o nome do aula que deseja remover:");
                String nomeAula = sc.nextLine();

                Ficheiro.eliminarAula(nomeAula);
            }
        });
        frame.setVisible(true);
    }

    public static void consultarAulas() {
        Ficheiro.consultarAula();
    }


}
