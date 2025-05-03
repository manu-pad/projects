import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Ficheiro implements Serializable {

    private static final String FILE_NAME = "aula.dat";

    public static void inserirAula(Aula aula) {
        if (aula != null) {
            List<Aula> aulas = verAula();
            aulas.add(aula);

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                for (Aula a : aulas) {
                    outputStream.writeObject(a);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Erro: Tentativa de inserir um objeto nulo ou de tipo incorreto.");
        }
    }

    public static List<Aula> consultarAula() {
        List<Aula> aulas = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                try {
                    Aula aula = (Aula) inputStream.readObject();
                    aulas.add(aula);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (EOFException e) {
                    break;
                }
            }

            System.out.println("Aula carregadas:");
            for (Aula aula : aulas) {
                System.out.println("---------------------- Aula ----------------------");
                System.out.println("Nome: " + aula.getNome());
                System.out.println("Hora: " + aula.getHora());
                System.out.println("Dia: " + aula.getDia());
                System.out.println("\n|  Treinador  |\n" + aula.mostrarTrainer());
                System.out.println("\n|    Alunos   |\n" + aula.mostrarParticipantes());
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        return aulas;
    }



    public static void eliminarAula(String nomeAula) {
        List<Aula> aulas = verAula();
        List<Aula> aulasAtualizados = new ArrayList<>();

        boolean aulaRemovida = false;

        for (Aula aula : aulas) {
            if (!aula.getNome().equals(nomeAula)) {
                aulasAtualizados.add(aula);
            } else {
                aulaRemovida = true;
            }
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            for (Aula a : aulasAtualizados) {
                outputStream.writeObject(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (aulaRemovida) {
            System.out.println("Aula removida com sucesso!");
        } else {
            System.out.println("Nenhuma aula foi removido.");
        }
    }

    public static List<Aula> verAula() {
        List<Aula> aula = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                try {
                    Aula aulas = (Aula) inputStream.readObject();
                    aula.add(aulas);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

        return aula;
    }

}

