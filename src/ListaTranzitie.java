import java.util.*;

public class ListaTranzitie {
    private ArrayList <Tranzitie> list = new ArrayList <Tranzitie>();
    
    void adaugaTranzitie(Tranzitie tr){
        this.list.add(tr);
    }
    Tranzitie gasesteTranzitie(String stare, char simbol){
        for(int i = 0;i<this.list.size();i++){
            Tranzitie tr = this.list.get(i);
            if(tr.SpuneInceput().equals(stare) && tr.SpuneSimbol()==simbol)
                return tr;
        }
            return null;
    }
    public boolean determinist(){
        for(int i=0;i<this.list.size();i++){
            Tranzitie tr= this.list.get(i);
            for(int k=i+1;k<this.list.size();k++){
                if(tr.SpuneInceput().equals(this.list.get(k).SpuneInceput()) && tr.SpuneSimbol()== this.list.get(k).SpuneSimbol()){
                    return false;
                }
            }
        }
        return true;
   }
   //sa verific daca o stare are drum spre alta stare
   public void gasesteDrum(){

   }
}
