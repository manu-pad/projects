public class Trainer extends Pessoa {
    private String especialidade;
    private int anosDeExperiencia;

    public Trainer(String nome, String dob, String sexo, String especialidade, int anosDeExperiencia) {
        super(nome, dob, sexo);
        this.especialidade = especialidade;
        this.anosDeExperiencia = anosDeExperiencia;
    }

    public String getEspecialidade() { return this.especialidade; }
    public int getAnosDeExperiencia() { return this.anosDeExperiencia; }

    @Override
    public String toString() {
        return super.toString() + ", Especialidade: " + this.especialidade + ", Anos de Experiência: " + this.anosDeExperiencia;
    }
}