 public class Vagao {
    private int id;
    private double capacidade;
    private Composicao composicao=null;


     public Vagao(int id, double capacidade) {
         this.id = id;
         this.capacidade = capacidade;
     }

     public int getId(){
        return id;
    }

    public double getCapacidade(){
        return capacidade;
    }

    public Composicao getComposicao(){
        return composicao;
    }

    
}
