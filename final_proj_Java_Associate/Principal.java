import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal{

    public static void main(String[] args) {
            Scoala scoala = Scoala.getInstance();
            Scanner sc = new Scanner(System.in);

            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            executor.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    System.out.println("Numarul total de cursuri la 2 minute: " + scoala.listaCursuri.size());
                }
            }, 0, 2, TimeUnit.MINUTES);

            //Folosid acest while pot sa adaug o instante pana cand introduc exit
            while (true) {
                System.out.println("Introduceti tipul cursului si datele: ");
                String s = sc.nextLine();
                String[] s1 = s.split(" ");//sau "\\s+"


                if (s1[0].equals("exit")) {
                    System.out.println("iesim din aplicatie");
                    System.exit(0);
                    break;
                }

                if (s1[0].equals("adauga_curs")) {
                    if (s1[1].equals("cursProgramare")) {
                        CursProgramare cursp = new CursProgramare(scoala.listaCursuri.size() + 1, "denumire_curs_programare", 100);
                        cursp.nume = s1[2];//denumire curs
                        cursp.pret = Double.parseDouble(s1[3]);//pretul
                        try {
                            scoala.adaugaCurs(cursp);
                        } catch (PreaMulteCursuriException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (s1[1].equals("cursLimba")) {
                        CursLimba cursl = new CursLimba(scoala.listaCursuri.size() + 1, "denumire_curs_limba", 50);
                        // cursl.id= Integer.parseInt(s1[2]);//id curs
                        cursl.nume = s1[2];//denumire curs
                        cursl.pret = Double.parseDouble(s1[3]);//pretul

                        try {
                            scoala.adaugaCurs(cursl);
                        } catch (PreaMulteCursuriException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                } else if (s1[0].equals("afisare")) {
                    //- afișare – afișează toate cursurile din instituție; (2p)
                    scoala.afiseazaCursuri();
                } else if (s1[0].equals("afisare_cursuri_programare")) {
                    scoala.afiseazaCursuriProgramare();
                } else if (s1[0].equals("sterge_curs")) {
                    scoala.stergeCurs(Integer.parseInt(s1[1]) - 1);
                } else {
                    System.out.println("Comanda gresita");
                }
            }
        }
}
               
      
