 public class Vagao {
    private int id;
    private double capacidade;
    private Integer composicao;


     public Vagao(int id, double capacidade) {
         this.id = id;
         this.capacidade = capacidade;
         composicao=null;
     }

     public int getId() {
         return id;
     }

     public double getCapacidade() {
         return capacidade;
     }

     public Integer getComposicao() {
         return composicao;
     }

     public void setComposicao(Integer composicao) {
         this.composicao = composicao;
     }
 }
