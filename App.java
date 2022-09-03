import java.util.Scanner;

public class App {
    
    public static String[] menu(){

        String[] options = new String[7];

        System.out.println(options[0] = "Opções: ");
        System.out.println(options[1] = "1: Criar um trem");
        System.out.println(options[2] = "2: Editar um trem");
        System.out.println(options[3] = "3: Listar todos os trem criados");
        System.out.println(options[4] = "4: Desfazer um trem");
        System.out.println(options[5] = "5: Finalizar o programa");
        return options;
    }

    public static String[] opcoesTrem(){

        String[] optionsEdicao = new String[7];

        System.out.println(optionsEdicao[0] = "Opcoes: ");
        System.out.println(optionsEdicao[1] = "1: Inserir uma locomotiva");
        System.out.println(optionsEdicao[2] = "2: Inserir um vagao");
        System.out.println(optionsEdicao[3] = "3: Remover o ultimo elemento do trem");
        System.out.println(optionsEdicao[4] = "4: Listar locomotivas livres");
        System.out.println(optionsEdicao[5] = "5: Listar vagoes livres");
        System.out.println(optionsEdicao[6] = "6: Encerrar a ediçao do trem");

        return optionsEdicao;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GaragemLocomotivas garagemLoco = new GaragemLocomotivas();
        GaragemVagoes garagemVagoes = new GaragemVagoes();
        PatioComposicoes patioDeComp = new PatioComposicoes();
        //criar objeto composicao (entra em conflito com outro)

        menu();
        int op = sc.nextInt();
        
        switch (op) {
            case 1:
                System.out.println("\f   \t\t Criar um Trem:");
                System.out.println("\n");

                System.out.println("Indique o Identificador do Trem:");
                int idTrem = sc.nextInt();

                System.out.println("Agora, Indique a primeira Locomotiva:");
                garagemLoco.imprimirLocomotivasLivres();
                //TODO: Printar todas as locomotivas disponíveis
                int idLoco = sc.nextInt();
                //CRIAR TREM COM METODO CRIAR TREM
                patioDeComp.criaTrem(idTrem,garagemLoco.buscarLocomotivaLivre(idLoco));
                //TODO: Mensagem se que indica se o trem foi criado ou não (usar isEmpty(), talvez)
                
                break;
            
            case 2:

                System.out.println("\f   \t\t Editar um Trem:");
                System.out.println("\n");
                
                System.out.println("Qual trem você deseja editar? Indique o identificador:");
                int id = sc.nextInt();

                System.out.println("O que você deseja editar no trem?");
                opcoesTrem();
                int op2 = sc.nextInt();
                
                    switch (op2) {
                        case 1:
                           System.out.println("Informe o identificador da locomotiva a ser inserida:");
                           int id3 = sc.nextInt();
                           //TODO:  Inserir uma locomotiva respeitando restrições
                            //verificar se o id é de uma locomotiva livre.
                            garagemLoco.buscarLocomotivaLivre(id3);
                            //engata locomotiva
                            break;
                        
                            case 2:
                            System.out.println("Informe o vagão a ser inserido:");
                            int id4 = sc.nextInt();
                            //TODO: Inserir um vagão respeitando restrições
                            //verifica se vagao e livre
                            garagemVagoes.buscarVagaoLivre(id4);
                            //engata vagao


                            break;

                        case 3:
                            System.out.println("Indique o trem do qual você quer remover o último elemento:");
                            int id5 = sc.nextInt();
                            //TODO: Remover o último elemento do trem indicado
                            //abrir objeto composicao e utilizar metodo removerUltimoElemento
                            break;

                        case 4:
                            System.out.println("Estas são as locomotivas livre:");
                            //TODO: Listar locomotivas livres
                            garagemLoco.imprimirLocomotivasLivres();
                            break;

                        case 5:
                            System.out.println("Estes são os vagões livres:");
                            //TODO: Listar vagões livres
                            garagemVagoes.imprimirVagoesLivres();
                            break;
                            
                        case 6:
                            System.out.println("Edição Encerrada!");
                            break;    
                        
                        default:
                            System.out.println("Opção Indisponível. Selecione um número de 1 à 6.");
                            break;
                    }
                
            break;

            case 3:
                System.out.println("\f   \t\t Trens Criados:");
                System.out.println("\n");

                //TODO: Printar todos os trens já criados
            break;
            
            case 4:
                System.out.println("\f   \t\t Desfazer um Trem:");
                System.out.println("\n");

                System.out.println("Indique o Trem que você deseja desfazer:");
                int id2 = sc.nextInt();

                PatioComposicoes.desfazerTrem(id2);
                System.out.println("Trem número %.0f foi removido. Seu(s) vagão(ões) e locomotiva(s) já estão disponíveis na garagem.");
            break;

            case 5: 
                System.out.println("\f   \t\t Finalizando Programa....");
                System.out.println("\n");
            break;
            
            default:
                System.out.println("Opção Indisponível. Selecione um número de 1 à 5.");
                break;
        }
        /* 
       

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
*/
    }
}
