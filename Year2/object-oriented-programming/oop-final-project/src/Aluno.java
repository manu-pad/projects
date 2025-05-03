import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable{

    private String nivelDeCondicionamento;
    private String objetivo;

    public Aluno() {
        super("", "", "");
        this.nivelDeCondicionamento = "";
        this.objetivo = "";
    }

    public Aluno(String nome, String dob, String sexo, String nivelDeCondicionamento, String objetivo) {
        super(nome, dob, sexo);
        this.nivelDeCondicionamento = nivelDeCondicionamento;
        this.objetivo = objetivo;
    }

    public String getNivelDeCondicionamento() { return this.nivelDeCondicionamento; }
    public String getObjetivo() { return this.objetivo; }

    @Override
    public String toString() {
        return super.toString() +" "+ this.nivelDeCondicionamento + " " + this.objetivo;
    }
}

