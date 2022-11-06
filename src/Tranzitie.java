public class Tranzitie {
    private String st_inceput;
    private char simbol;
    private String st_final;

    Tranzitie(String st_inceput,char simbol, String st_final){
        this.st_inceput= st_inceput;
        this.simbol= simbol;
        this.st_final= st_final;
    }
    char SpuneSimbol(){
        return this.simbol;
    }
    String SpuneInceput(){
        return this.st_inceput;
    }
    String SpuneFinal(){
        return this.st_final;
    }
}