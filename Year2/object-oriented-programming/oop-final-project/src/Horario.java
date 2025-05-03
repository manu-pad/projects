import java.io.Serializable;
import java.util.*;

class Horario implements Serializable {
    Map<String, Map<String, Aula>> horarioSemanal;

    Horario() {
        horarioSemanal = new HashMap<>();
        String[] diasDaSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        for (String dia : diasDaSemana) {
            Map<String, Aula> aulasDoDia = new HashMap<>();
            for (int i = 8; i <= 22; i++) {
                aulasDoDia.put(i + ":00", null);
            }
            horarioSemanal.put(dia, aulasDoDia);
        }
    }

    void adicionarAula(Aula aula) {
        String dia = aula.getDia();
        String hora = aula.getHora();

        if (horarioSemanal.containsKey(dia) && horarioSemanal.get(dia).containsKey(hora)) {
            horarioSemanal.get(dia).put(hora, aula);
        } else {
            System.out.println("Horário inválido!");
        }
    }

    void removerAula(String dia, String hora) {
        if (horarioSemanal.containsKey(dia) && horarioSemanal.get(dia).containsKey(hora)) {
            horarioSemanal.get(dia).put(hora, null);
        } else {
            System.out.println("Horário inválido!");
        }
    }

    void imprimirHorario() {
        System.out.println("____________________________________________________________________\n");
        String[] diasDaSemana = {"Segunda", "Terça", "Quarta", "Quinta", "Sexta"};
        String[] horasDoDia = new String[15];
        for (int i = 0; i < 15; i++) {
            horasDoDia[i] = (i + 8) + ":00";
        }

        String[][] tabelaHorario = new String[15][5];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                Aula aula = horarioSemanal.get(diasDaSemana[j]).get(horasDoDia[i]);
                if (aula != null) {
                    tabelaHorario[i][j] = aula.getNome();
                } else {
                    tabelaHorario[i][j] = "";
                }
            }
        }

        System.out.printf("%-10s|%-20s|%-20s|%-20s|%-20s|%-20s|\n", "Hora", "Segunda", "Terça", "Quarta", "Quinta", "Sexta");
        System.out.println(new String(new char[115]).replace("\0", "-"));
        for (int i = 0; i < 15; i++) {
            System.out.printf("%-10s|", horasDoDia[i]);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-20s|", tabelaHorario[i][j]);
            }
            System.out.println();
            System.out.println(new String(new char[115]).replace("\0", "-"));
        }
    }
}
