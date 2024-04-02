
/**
 * Write a description of class CursLimba here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CursLimba extends Curs
{
     String nume;
    double pret;
    CursLimba(int id, String nume, double pret){
        super(id);
        this.nume = nume;
        this.pret = pret;
    }

  @Override
    public String toString(){
        return "Cursul numarul " + id + " de limba cu numele " + nume + " si pretul "+pret; 
    }
}

