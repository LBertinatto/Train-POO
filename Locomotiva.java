public class Locomotiva {
    private int id;
    private double pesoMaximo;
    private double numeroMaximoVagoes;
    private Integer idComposicao;

    public Locomotiva(int id, double pesoMaximo, double numeroMaximoVagoes) {
        this.id = id;
        this.pesoMaximo = pesoMaximo;
        this.numeroMaximoVagoes = numeroMaximoVagoes;
        idComposicao=null;
    }

    public int getId() {
        return id;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }


    public double getNumeroMaximoVagoes() {
        return numeroMaximoVagoes;
    }


    public Integer getComposicao() {
        return idComposicao;
    }

    public void setComposicao(Integer composicao) {
        this.idComposicao = composicao;
    }
}


