import java.util.List;

public class Composicao{
    private List<Vagao> vagao;
    private List<Locomotiva> locomotiva;
    private int id;
    private int qtdadeVagoes;

    public Composicao(Vagao vagao, Locomotiva locomotiva){
        
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
        return qtdadeVagoes;
    }

    public void getVagao(){
    //??????????????????????????????????????
    }

    public boolean engataLocomotiva(Locomotiva locomotiva){
        return true;
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
