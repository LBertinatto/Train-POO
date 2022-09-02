import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;


public class Composicao{
    private ArrayList<Vagao> vagoes = new ArrayList<>();
    private ArrayList<Locomotiva> locomotivas = new ArrayList<>();
    private int id;
    private int quantVagoes=0;
    private int quantLocomotivas=0;
    private double pesoMaxLocomotivas=0;      //peso suportado por todas locomotivas juntas
    private double pesoVagoes=0;              //peso de todos vagoes juntos
    private double maximoDeVagoes=0;          //quantidade maxima de vagoes suportados pelas locomotivas sem redução

    /**
     * Construtor parar criar um trem com uma locomotiva.
     * @param id, id desejado para o trem criado
     * @param locomotiva, locomotiva escolhida para ser a primera
     */
    public Composicao(int id, Locomotiva locomotiva){
        this.id = id;
        locomotivas.add(locomotiva);
        quantLocomotivas++;
        pesoMaxLocomotivas+=locomotiva.getPesoMaximo();
        maximoDeVagoes+= locomotiva.getNumeroMaximoVagoes();
    }

    public int getId() {
        return id;
    }

    public int getQuantVagoes() {
        return quantVagoes;
    }


    public int getQuantLocomotivas() {
        return quantLocomotivas;
    }


    public Locomotiva getLocomotiva(int posicao) {
        try {
            return locomotivas.get(posicao);
        }
        catch (Exception e) {
            System.out.println("Não há uma locomotiva na posição solicitada");
        }
        return null;
    }

    public Vagao getVagao(int posicao) {
        try {
            return vagoes.get(posicao);
        }
        catch (Exception e) {
            System.out.println("Não há um vagão na posição solicitada");
        }
        return null;
    }

    /**
     * utiliza a formula fornecida para verificar o numero maximo de vagoes suportados.
     * @return numero de vagoes suportados pelas locomotivas
     */
    private double NumeroMaximoVagoes() {
        double perc = 0.1*(quantLocomotivas-1);     //percentual a ser reduzido de acordo com a quantidade de locomotivas.
        return maximoDeVagoes =(1-perc)*maximoDeVagoes;
    }
    /**
     * Metodo para engatar uma locomotiva no final do trem caso não tenha nenhum vagão.
     * @param locomotiva locomotiva que deve ser engatada, status da locomotiva muda de livre para ocupada
     * @return true se inserir, false se não for possível.
     */
    public boolean engataLocomotiva(Locomotiva locomotiva) {
        if (quantVagoes>0) {
            System.out.println("Não é possível adicionar uma locomotiva após um vagão.");
            return false;
        }
        else {
            locomotivas.add(locomotiva);
            quantLocomotivas++;
            pesoMaxLocomotivas += locomotiva.getPesoMaximo();
            maximoDeVagoes += locomotiva.getNumeroMaximoVagoes();
            locomotiva.setComposicao(id);
            return true;
        }
    }

    /**
     * Adiciona um vagão ao trem se possível
     * @param vagao vagão que deve ser engatado, status do vagao muda de livre para ocupado
     * @return true se foi possivel engatar, false se não foi
     */
    public boolean engataVagao(Vagao vagao) {
        if ((pesoVagoes + vagao.getCapacidade()) > pesoMaxLocomotivas || quantVagoes + 1 > NumeroMaximoVagoes()) {
            return false;
        } else {
            vagoes.add(vagao);
            quantVagoes++;
            pesoVagoes+=vagao.getCapacidade();
            vagao.setComposicao(id);       //marca o vagao como ocupado na lista de vagoes.
            return true;
        }
    }

    /**
     * remove o ultimo elemento do trem, podendo ser vagão ou locomotiva, e atualiza os dados
     * @return true se for possivel remover, false se o trem estiver vazio
     */
    public boolean removerUltimoElemento() {
        if (quantVagoes > 0) {      //se houver pelo menos 1 vagão, o ultimo elemento do trem deve ser um vagão
            Vagao vagao = vagoes.get(quantVagoes-1);     //vagão que deve ser removido
            vagao.setComposicao(null);                  //marca o vagao como livre na lista de vagoes
            vagoes.remove(vagao);
            quantVagoes--;
            pesoVagoes-=vagao.getCapacidade();
            return true;
        } else if (quantLocomotivas > 0) {
            Locomotiva locomotiva = locomotivas.get(quantLocomotivas-1);   //locomotiva que deve ser removida
            locomotiva.setComposicao(null);                             //marca locomotiva como livre na lista de locomotivas
            locomotivas.remove(locomotiva);
            quantLocomotivas--;
            pesoMaxLocomotivas-= locomotiva.getPesoMaximo();
            maximoDeVagoes-= locomotiva.getNumeroMaximoVagoes();
            return true;
        } else {
            System.out.println("Trem vazio, não há nada para remover");
            return false;
        }
    }

    /**
     * libera todos vagoes e locomotivas que estavam no trem
     */
    public void desfazTrem() {
        for (Locomotiva x : locomotivas) {
            x.setComposicao(null);
        }
        for (Vagao x : vagoes) {
            x.setComposicao(null);
        }
    }
}
