import java.util.ArrayList;

public class PatioComposicoes {
    private static ArrayList<Composicao> composicoes = new ArrayList<>();

    public static void criaTrem (int id, Locomotiva locomotiva) {
        composicoes.add(new Composicao(id, locomotiva));
        System.out.println("Trem " + id + " criado.");
    }

    public static Composicao getComposicao(int id) {
        for (Composicao x: composicoes) {
            if (x.getId()==id) return x;
        }
        return null;
    }

    public static void desfazerTrem(int id) {
        Composicao trem = getComposicao(id);
        if (trem != null) {
            trem.desfazTrem();
            composicoes.remove(trem);
            trem = null;
        }
    }

    public static void listarTrensCriados() {
        if (composicoes.isEmpty()) {
            System.out.println("Não há nenhum trem no pátio");
        } else {
            System.out.println("\f   \t\t Trens Criados:");
            for (Composicao x : composicoes) {
                System.out.println(x.getId());
            }
        }

    }
}
