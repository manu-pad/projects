import java.io.Serializable;
import java.util.*;

public class Aula implements Serializable {
    private String hora;
    private String dia;
    private Trainer trainer;
    private String nome;
    private ArrayList<Aluno> participantes;


    public Aula(String hora, String dia, Trainer trainer, String nome, ArrayList<Aluno> participantes) {
        this.hora = hora;
        this.dia = dia;
        this.trainer = trainer;
        this.nome = nome;
        this.participantes = new ArrayList<Aluno>();
    }

    public String getNome() {return nome;}
    public Trainer getTrainer() {return this.trainer;}

    public String getDia() {return dia;}

    public String getHora() {return hora;}

    public void setParticipantes(ArrayList<Aluno> participantes) {
        this.participantes.addAll(participantes);
    }

    public String mostrarTrainer() {
        StringBuilder s = new StringBuilder();
        Trainer trainer = this.trainer;
        s.append("Nome: ").append(trainer.getNome()).append("\n");
        s.append("Data de Nascimento: ").append(trainer.getDob()).append("\n");
        s.append("Sexo: ").append(trainer.getSexo()).append("\n");
        s.append("Especialidade: ").append(trainer.getEspecialidade()).append("\n");
        s.append("Anos de Experiência: ").append(trainer.getAnosDeExperiencia()).append("\n");
        return s.toString();
    }
    public String mostrarParticipantes() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.participantes.size(); i++) {
            Aluno aluno = this.participantes.get(i);
            s.append("\nParticipante ").append(i + 1).append(":\n");
            s.append("Nome: ").append(aluno.getNome()).append("\n");
            s.append("Data de Nascimento: ").append(aluno.getDob()).append("\n");
            s.append("Sexo: ").append(aluno.getSexo()).append("\n");
            s.append("Nível: ").append(aluno.getNivelDeCondicionamento()).append("\n");
            s.append("Objetivo: ").append(aluno.getObjetivo()).append("\n");
        }
        return s.toString();
    }
}
