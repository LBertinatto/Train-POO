import java.util.Scanner;

public class App {

    public static void menu(){

        System.out.println("Opções: ");
        System.out.println("1: Criar um trem");
        System.out.println("2: Editar um trem");
        System.out.println("3: Listar todos os trem criados");
        System.out.println("4: Desfazer um trem");
        System.out.println("5: Finalizar o programa");
    }

    public static void opcoesTrem(){

        System.out.println("Opcoes: ");
        System.out.println("1: Inserir uma locomotiva");
        System.out.println("2: Inserir um vagao");
        System.out.println("3: Remover o ultimo elemento do trem");
        System.out.println("4: Listar locomotivas livres");
        System.out.println("5: Listar vagoes livres");
        System.out.println("6: Encerrar a ediçao do trem");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GaragemLocomotivas garagemLoco = new GaragemLocomotivas();
        GaragemVagoes garagemVagoes = new GaragemVagoes();

        //criar objeto composicao (entra em conflito com outro)
        while (true) {
            System.out.println();
            menu();
            if (!sc.hasNextInt()) {
                System.out.println("Entrada Inválida. Por favor selecione uma das opções apresentadas");
                sc.next();
            }
            else {
                int op = sc.nextInt();

                switch (op) {
                    case 1:
                        System.out.println("\f   \t\t Criar um Trem:");
                        System.out.println("Indique o Identificador do Trem:");
                        if (!sc.hasNextInt()) {
                            System.out.println("Entrada Inválida. O identificador deve ser um número inteiro");
                            sc.next();
                            break;
                        }
                        int idTremCriar = sc.nextInt();
                        if (PatioComposicoes.getComposicao(idTremCriar) != null) {
                            System.out.println("Já existe um trem com este identificador.");
                            break;
                        }

                        System.out.println("Agora, Indique a primeira Locomotiva:");
                        garagemLoco.imprimirLocomotivasLivres();
                        try {
                            int idLoco1 = sc.nextInt();
                            PatioComposicoes.criaTrem(idTremCriar, garagemLoco.buscarLocomotivaLivre(idLoco1));
                        } catch (Exception e) {
                            System.out.println("Entrada Inválida. Por favor selecione uma das locomotivas listadas");
                        }
                        break;


                    case 2:
                        System.out.println("\f   \t\t Editar um Trem:");
                        System.out.println("\n");

                        System.out.println("Qual trem você deseja editar? Indique o identificador:");
                        if (!sc.hasNextInt()) {
                            System.out.println("Entrada Inválida. O identificador deve ser um número inteiro");
                            sc.next();
                            break;
                        }
                        int id = sc.nextInt();
                        Composicao editTrem = PatioComposicoes.getComposicao(id);
                        if (editTrem == null) {
                            System.out.println("Não existe um trem com esse identificador");
                            break;
                        }
                        System.out.println("O que você deseja editar no trem?");
                        opcoesTrem();
                        if (!sc.hasNextInt()) {
                            System.out.println("Entrada Inválida. Por favor selecione uma das opções apresentadas");
                            sc.next();
                            break;
                        }
                        int op2 = sc.nextInt();

                        switch (op2) {
                            case 1:
                                System.out.println("Informe o identificador da locomotiva a ser inserida:");
                                garagemLoco.imprimirLocomotivasLivres();
                                if (!sc.hasNextInt()) {
                                    System.out.println("Entrada Inválida. O identificador deve ser um número inteiro");
                                    sc.next();
                                    break;
                                }
                                int idLocInserir = sc.nextInt();
                                Locomotiva locoInserir = garagemLoco.buscarLocomotivaLivre(idLocInserir);
                                if (locoInserir == null) {
                                    System.out.println("Não há uma locomotiva livre com esse identificador");
                                    break;
                                }
                                if(editTrem.engataLocomotiva(locoInserir)) {
                                    System.out.println("Locomotiva " + idLocInserir + " engatada com sucesso");
                                }

                                break;

                            case 2:
                                System.out.println("Informe o identificador do vagão a ser inserido:");
                                garagemVagoes.imprimirVagoesLivres();
                                if (!sc.hasNextInt()) {
                                    System.out.println("Entrada Inválida. O identificador deve ser um número inteiro");
                                    sc.next();
                                    break;
                                }

                                int idVagaoInserir = sc.nextInt();
                                Vagao vagaoInserir = garagemVagoes.buscarVagaoLivre(idVagaoInserir);

                                if (vagaoInserir == null) {
                                    System.out.println("Não há um vagão livre com esse identificador");
                                    break;
                                }

                                if (editTrem.engataVagao(vagaoInserir)) {
                                    System.out.println("Vagão " + idVagaoInserir + " engatado com sucesso");
                                }
                                break;

                            case 3:
                                editTrem.removerUltimoElemento();
                                break;

                            case 4:
                                System.out.println("Estas são as locomotivas livre:");
                                garagemLoco.imprimirLocomotivasLivres();
                                break;

                            case 5:
                                System.out.println("Estes são os vagões livres:");
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
                        PatioComposicoes.listarTrensCriados();
                        break;

                    case 4:
                        System.out.println("\f   \t\t Desfazer um Trem:");

                        System.out.println("Indique o Trem que você deseja desfazer:");
                        if (!sc.hasNextInt()) {
                            System.out.println("Entrada Inválida. O identificador deve ser um número inteiro");
                            sc.next();
                            break;
                        }
                        int idTremDesfazer = sc.nextInt();

                        if (PatioComposicoes.getComposicao(idTremDesfazer)==null) {
                            System.out.println("Não é possível desfazer um trem inexistente");
                            break;
                        }
                        PatioComposicoes.desfazerTrem(idTremDesfazer);
                        System.out.println("Trem número " + idTremDesfazer + " foi removido. Seu(s) vagão(ões) e locomotiva(s) já estão disponíveis na garagem.");
                        break;

                    case 5:
                        System.out.println("\f   \t\t Finalizando Programa....");
                        System.exit(0);
                    default:
                        System.out.println("Opção Indisponível. Selecione um número de 1 à 5.");
                        break;
                }
            }
        }
    }
}
