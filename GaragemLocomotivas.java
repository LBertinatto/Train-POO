import java.util.ArrayList;

public class GaragemLocomotivas {
    private static ArrayList<Locomotiva> locomotivas = new ArrayList<>();

    /**
     * construtor padrão que adiciona locomotivas livres na lista.
     */
    public GaragemLocomotivas() {
        locomotivas.add(new Locomotiva(1, 1000, 50));
        locomotivas.add(new Locomotiva(2, 1000, 50));
        locomotivas.add(new Locomotiva(3, 1000, 50));
        locomotivas.add(new Locomotiva(4, 1000, 50));
        locomotivas.add(new Locomotiva(5, 1000, 50));
        locomotivas.add(new Locomotiva(6, 1000, 50));
        locomotivas.add(new Locomotiva(7, 1000, 50));
        locomotivas.add(new Locomotiva(8, 1000, 50));
    }

    public Locomotiva buscarLocomotivaLivre(int id) {
        for (Locomotiva x : locomotivas) {
            if (id==x.getId() && x.getComposicao()==null) {
                return x;
            }
        }
        return null;
    }

    public void imprimirLocomotivasLivres()  {
        for (Locomotiva x : locomotivas)    {
            if (x.getComposicao()==null)    {
                System.out.println(x.getId());
            }
        }
    }

}
