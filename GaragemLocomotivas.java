import java.util.ArrayList;

public class GaragemLocomotivas {
    private ArrayList<Locomotiva> locomotivas;
    public Locomotiva buscarLocomotivaLivre(int id) {
        for (Locomotiva x : locomotivas) {
            if (id==x.getId() && x.getComposicao()==null) {
                return x;
            }
        }
        return null;
    }
}
