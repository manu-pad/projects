import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private String dob;
    private String sexo;

    public Pessoa() {
        this.nome = " ";
        this.dob = " ";
        this.sexo = " ";
    }

    public Pessoa(String nome, String dob, String sexo) {
        this.nome = nome;
        this.dob = dob;
        this.sexo = sexo;
    }

    public String getNome() { return this.nome; }
    public String getDob() { return this.dob; }
    public String getSexo() { return this.sexo; }

    @Override
    public String toString() {
        return this.nome;
    }
}