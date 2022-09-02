import java.util.ArrayList;

public class PatioComposicoes {
    private ArrayList<Composicao> composicoes = new ArrayList<>();

    public void criaTrem (int id, Locomotiva locomotiva) {
        composicoes.add(new Composicao(id, locomotiva));
    }

    public Composicao getComposicao(int id) {
        for (Composicao x: composicoes) {
            if (x.getId()==id) return x;
        }
        System.out.println("Não existe um trem com o identificador fornecido.");
        return null;
    }

    public void desfazerTrem(int id) {
        Composicao trem = getComposicao(id);
        if (trem != null) {
            trem.desfazTrem();
            composicoes.remove(trem);
            trem = null;
        }
    }
}
