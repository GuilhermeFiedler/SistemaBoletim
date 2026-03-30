package instituicaoEnsino.dominio.aluno;

public class Nota {

    private String tipo;
    private double valor;
    private double peso;

    public Nota(String tipo, double valor, double peso) {
        this.tipo = tipo;
        this.valor = valor;
        this.peso = peso;
    }

    public String getTipo() { return tipo; }

    public double getValor() { return valor; }

    public double getPeso() { return peso; }

}
