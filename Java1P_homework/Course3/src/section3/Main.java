package section3;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) throws ParseException {
        // localeExamples();

        // formatExamples();

        /*ResourceBundle bundle = ResourceBundle.getBundle("example", new Locale("ro", "RO"));
        System.out.println(bundle.getObject("hello"));
        System.out.println(bundle.keySet());

        ResourceBundle bundle2 = ResourceBundle.getBundle("example", Locale.US);
        System.out.println(bundle2.getObject("hello"));
        System.out.println(bundle2.keySet());*/

        ResourceBundle bundle = ResourceBundle.getBundle("example", Locale.US);
        String helloWithName = bundle.getString("hello");
        String result = MessageFormat.format(helloWithName, "Alex");
        System.out.println(result);

    }

    private static void formatExamples() throws ParseException {
        NumberFormat usNumberFormat = NumberFormat.getInstance(Locale.US);
        NumberFormat frNumberFormat = NumberFormat.getInstance(Locale.FRANCE);

        NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat frCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        double price= 2.15;
        System.out.println(usNumberFormat.format(price));
        System.out.println(frNumberFormat.format(price));
        System.out.println(usCurrencyFormat.format(price));
        System.out.println(frCurrencyFormat.format(price));

        String s = "40,45";
        System.out.println(usNumberFormat.parse(s));
        System.out.println(frNumberFormat.parse(s));

        String income = "$400.99";
        System.out.println(usCurrencyFormat.parse(income));
        //   System.out.println(frCurrencyFormat.parse(income)); //exception parse

        DateTimeFormatter roDateTimePattern = DateTimeFormatter.ofPattern("dd-MMMM-yyyy", new Locale("ro", "RO"));
        DateTimeFormatter ukDateTimePattern = DateTimeFormatter.ofPattern("dd-MMMM-yyyy", Locale.UK );
        LocalDate birthDate = LocalDate.of(1998, Month.FEBRUARY, 24);

        System.out.println(roDateTimePattern.format(birthDate));
        System.out.println(ukDateTimePattern.format(birthDate));
    }

    private static void localeExamples() {
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale);
        Locale usLocale = Locale.US;
        Locale ukLocale = Locale.UK;
        System.out.println(usLocale);
        System.out.println(ukLocale);

        Locale frFr = new Locale("fr", "FR");
        System.out.println(frFr);

        Locale enLocale= new Locale("en");
        System.out.println(enLocale);

        Locale esEs = new Locale.Builder()
                .setLanguage("es")
                .setRegion("ES")
                .build();
        System.out.println(esEs);
    }
}
