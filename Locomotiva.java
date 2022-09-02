public class Locomotiva {
    private int id;
    private double pesoMaximo;
    private double numeroMaximoVagoes;
    private double numeroVagoes;
    private Composicao composicao=null;

    public Locomotiva(int id, double pesoMaximo, double numeroMaximoVagoes) {
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

    public double getNumeroMaximoVagoes() {
      /*
      if(Locomotiva == 1){
        return numeroMaximoVagoes;
      }
      double j = 0;
      for(int i = 0; i < Locomotiva; i++){
        numeroMaximoVagoesn = (numeroVagoes * Locomotiva) - (j/10 * (numeroMaximoVagoes * Locomotiva));
        if(i == Locomotiva - 1){
          System.out.println(numeroMaximoVagoes);
        }
        j++;
      }*/
      //numero de vagoes de acordo com a quantidade de locomotivas
        return numeroMaximoVagoes;
    }

    public Composicao getComposicao() {
        return composicao;
    }
}
