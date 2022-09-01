import java.util.ArrayList;


public class Composicao{
    private ArrayList<Vagao> vagoes;
    private ArrayList<Locomotiva> locomotivas;
    private int id;
    private int quantVagoes=0;
    private int quantLocomotivas=0;
    private double pesoMaxLocomotivas=0; //peso suportado por todas locomotivas juntas
    private double pesoVagoes=0;  //peso de todos vagoes juntos
    private int maximoDeVagoes=0; //quantidade maxima de vagoes suportados pelas locomotivas

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

    /**
     * Metodo para inserir uma locomotiva no final do trem caso não tenha nenhum vagão.
     * @param locomotiva
     * @return true se inserir, false se não for possível.
     */
    public void insereLocomotiva(Locomotiva locomotiva) {
        if (quantVagoes>0) System.out.println("Não é possível adicionar uma locomotiva após um vagão.");
        else {
            locomotivas.add(locomotiva);
            quantLocomotivas++;
            pesoMaxLocomotivas += locomotiva.getPesoMaximo();
            maximoDeVagoes += locomotiva.getNumeroMaximoVagoes();
        }
    }


    public int getIdentificador(){
        return 0;
    }
    public int getQtdadeLocomomtivas(){
        return 0;
    }

    public void getLocomotiva(){
    //??????????????????????????????????????
    }

    public int getQtadadeVagoes(){
        return quantVagoes;
    }

    public void getVagao(){
    //??????????????????????????????????????
    }


    public boolean engataVagao(Vagao vagao){
        return true;
    }

    public boolean desengataLocomotiva(){
        return true;
    }

    public boolean desengataVagao(){
        return true;
    }
}
