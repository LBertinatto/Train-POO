public class Locomotiva {
    private int id;
    private double pesoMaximo;
    private int numeroMaximoVagoes;
    private Composicao composicao=null;

    public Locomotiva(int id, double pesoMaximo, int numeroMaximoVagoes) {
        this.id = id;
        this.pesoMaximo = pesoMaximo;
        this.numeroMaximoVagoes = numeroMaximoVagoes;
    }

    public int getId() {
        return id;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getNumeroMaximoVagoes() {
        return numeroMaximoVagoes;
    }

    public Composicao getComposicao() {
        return composicao;
    }
}
