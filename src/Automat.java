import java.io.*;
import java.io.BufferedReader;

public class Automat{
    private String st_init;
    private String st_finale[];
    private ListaTranzitie lt= new ListaTranzitie();

    Automat(String nume_fis) throws Exception{
        BufferedReader buf = new BufferedReader(new FileReader(nume_fis));
        this.st_init = buf.readLine();
        String st_finale_str = buf.readLine();
        this.st_finale = st_finale_str.split(" ");

        while(true){
            String linie = buf.readLine();
            if(linie == null)
                break;
            else{
                String tbl[]= linie.split(" ");
                Tranzitie tr = new Tranzitie(tbl[0], tbl[1].charAt(0), tbl[2]);
                this.lt.adaugaTranzitie(tr);
            }
        }
        buf.close();
    }
    boolean analizeazaCuvant(String sir_intrare){
            String CT = st_init;
            char[] arr= sir_intrare.toCharArray();
            for(int i=0;i<arr.length;i++){
                System.out.println(CT);
             if(lt.gasesteTranzitie(CT, arr[i])!= null){
                CT=lt.gasesteTranzitie(CT, arr[i]).SpuneFinal();
             }
             else 
                return false;   
             }
                System.out.println(CT);
             for(int i=0;i<st_finale.length;i++){
                if(CT.equals(st_finale[i]))
                    return true;
                }
                return false;
            }
    void Determinist(){
        if(lt.determinist()== true)
            System.out.println("Automatul este determinist!");
        else
            System.out.println("Automatul este nedeterminist!");
    }

    
}