import java.util.ArrayList;

public class GaragemVagoes {
    private ArrayList<Vagao> vagoes = new ArrayList<>();

  /**
     * construtor padrão que adiciona vagões livres na lista.
     */
    public GaragemVagoes() {
        vagoes.add(new Vagao(1, 1000));
        vagoes.add(new Vagao(2, 1000));
        vagoes.add(new Vagao(3, 1000));
        vagoes.add(new Vagao(4, 1000));
        vagoes.add(new Vagao(5, 1000));
    }

    public Vagao buscarVagaoLivre(int id) {
        for (Vagao x : vagoes) {
            if (id==x.getId() && x.getComposicao()==null) {
                return x;
            }
        }
        return null;
    }


}


