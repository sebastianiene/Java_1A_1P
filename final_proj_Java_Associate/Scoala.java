import java.util.*;
/**
 * Write a description of class Scoala here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Scoala
{
    
    protected ArrayList<Curs> listaCursuri = new ArrayList<>();
    private ArrayList<CursProgramare> listaCursuriProgramare = new ArrayList<>();
    
    private Scoala(){}
    private static Scoala instance;
    public static final Scoala getInstance(){
        if(instance == null)
            instance = new Scoala();
            
        return instance;    
    }
    
  /*  adaugaCurs – care adaugă un nou curs în oferta de cursuri (daca mai exista spatiu, în caz contrar
se va arunca o excepție de tipul PreaMulteCursuriException – definită de programator);
*/
public void adaugaCurs(Curs c) throws PreaMulteCursuriException{

        if(listaCursuri.size() <30){
            listaCursuri.add(c);
            if(c instanceof CursProgramare){
                System.out.println("S-a adaugat un curs de programare");
            }else if (c instanceof CursLimba){
                System.out.println("S-a adaugat un curs de limba"); 
            }
                }
        else{
            throw new PreaMulteCursuriException();
        }    
    }


/*- afișeazăCursuri – afișează toată oferta de cursuri disponibile (cu toate detaliile acestora);*/
   public void afiseazaCursuri(){
        listaCursuri.forEach(System.out::println);
    }
    
    
/*- afișeazăCursuriProgramare – afișeaza doar cursurile de programare disponibile (cu toate caracteristicile acestora);*/
public void afiseazaCursuriProgramare(){

    for(Curs c:listaCursuri)
            {
                if (c instanceof CursProgramare)                
                   { listaCursuriProgramare.add((CursProgramare) c);
                    }
                else 
                    {
                    }
                }
    listaCursuriProgramare.forEach(System.out::println);
    }

/*- stergeCurs – sterge un curs identificat prin id-ul primit ca parametru*/
public void stergeCurs(int id){
    
        listaCursuri.remove(id);
        System.out.println("Cursul dorit a fost sters");
    }
    
    /*
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }*/
}
