import java.util.ArrayList;

public class GaragemVagoes {
    public ArrayList<Vagao> vagoes;
    public Vagao buscarVagaoLivre(int id) {
        for (Vagao x : vagoes) {
            if (id==x.getId() && x.getComposicao()==null) {
                return x;
            }
        }
        return null;
    }
}


