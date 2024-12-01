import java.util.ArrayList;

public class Imballatore {
 private ArrayList<Mattone> mattoniDaImballareList; 
 public Imballatore(ArrayList<Mattone> mattoniDaImballareList){
     this.mattoniDaImballareList=mattoniDaImballareList;
 }
    public String imballaMattoni() {
        for(Mattone m: mattoniDaImballareList){
            m.setLotto("29nov2024");
            System.out.print(m.getString()+" ");          
    }
        return "Imballati e stoccati in magazzino tutti i 1600 mattoni";
    }
    
}
