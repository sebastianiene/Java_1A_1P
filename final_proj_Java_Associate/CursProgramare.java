
/**
 * Write a description of class CursProgramare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CursProgramare extends Curs
{
    String nume;
    double pret;

    /**
     * Constructor for objects of class CursProgramare
     */
   
    CursProgramare(int id, String nume, double pret){
        super(id);
        this.nume = nume;
        this.pret = pret;
    }   
    
    @Override
    public String toString(){
        return "Cursul numarul " + id + " de programare cu numele " + nume + " si pretul "+pret; 
    }
    
}
