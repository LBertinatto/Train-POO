
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GaragemLocomotivas garagemLoco = new GaragemLocomotivas();
        GaragemVagoes garagemVagoes = new GaragemVagoes();
        PatioComposicoes patioDeComp = new PatioComposicoes();

        patioDeComp.criaTrem(1, garagemLoco.buscarLocomotivaLivre(1));

        //fazer menu de opções, cada opção deve chamar os métodos já prontos nas outras classes, pegando
        // os parametros pelo scanner
        //ex opção 2 (editar um trem)
        System.out.println("Identificador do trem: ");
        int id = sc.nextInt();
        Composicao trem = patioDeComp.getComposicao(id);
        System.out.println("Opções: ");
        System.out.println("1: Inserir uma locomotiva");
        System.out.println("2: Inserir um vagão");
        System.out.println("3: Remover o último elemento do trem");
        System.out.println("4: Listar locomotivas livres");
        System.out.println("5: Listar vagões livres");
        System.out.println("6: Encerrar a edição do trem");
        int escolha = sc.nextInt();



    }
}
