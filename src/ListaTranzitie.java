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
   public boolean cale(String qp,String qd){
        HashSet<String> s= new HashSet<String>();
        int cap=0; boolean flag= false;
        ArrayList<String> stari1= new ArrayList<String>();    
        ArrayList<String> stari2= new ArrayList<String>();
        stari1.add(qp);
        s.add(qp);

        while(true){
            if(flag==false){
                stari2.clear();
                for(int i= 0;i<stari1.size();i++){
                    for(int j=0;j<list.size();j++)
                        if(stari1.get(i).equals(this.list.get(j).SpuneInceput())){
                            stari2.add(this.list.get(j).SpuneFinal());
                            s.add(this.list.get(j).SpuneFinal());
                    }
                }
                flag=true;
            }
            if(flag==true){
                stari1.clear();
                for(int i= 0;i<stari2.size();i++){
                    for(int j=0;j<list.size();j++)
                        if(stari2.get(i).equals(this.list.get(j).SpuneInceput())){
                            stari1.add(this.list.get(j).SpuneFinal());
                            s.add(this.list.get(j).SpuneFinal());
                        }
                    }
                flag=false;
            } 
                if(s.size()==cap)
                    break;
                else 
                    cap=s.size();
                    
        }
        System.out.println(s.toString());
        if(s.contains(qd)&& s.contains(qp))
            return true;
        return false;
    }
}
