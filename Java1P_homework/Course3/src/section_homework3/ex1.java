package section_homework3;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ex1 {
    /* Create a program with the functionality of a chatbot, interaction with it with the commands:

    START {<language>} {<country>} : the accolades specify that these are optional parameters
    HELLO : returns a greeting message in the local or default language
    I_AM <name> : gives the message: “I am happy to meet, <name>. I am MiniChat.”
    PURPOSE : returns a message with available commands, optionally with a message
    CHANGE <language> <country> : change the local settings
    EXIT : to exit the application
    */
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault(); // en_US
        Locale enUs = Locale.US; // en_US
        Locale frFr = new Locale("fr", "FR"); // fr_FR
        Locale en = new Locale("en"); // en
        Locale esEs = new Locale.Builder() // es_ES
                .setLanguage("es")
                .setRegion("ES")
                .build();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your name below!");
        String myName = keyboard.nextLine();
        System.out.println("Enter your language ex: en");
        String myLanguage = keyboard.nextLine();
        System.out.println("Enter your countryInitials, ex: US");
        String myCountry = keyboard.nextLine();

        ResourceBundle bundle = ResourceBundle.getBundle("example", new Locale("en", "US"));
        String helloWithName = bundle.getString("HELLO");
        String result_helloWithName = MessageFormat.format(helloWithName, myName);
        System.out.println(result_helloWithName);
        String iamWithName = bundle.getString("I_AM");
        String result_iamWithName = MessageFormat.format(iamWithName, myName);
        System.out.println(result_iamWithName);
        System.out.println("give command below:");
        String myCommand = keyboard.nextLine();
        Object[] twoargs = { myLanguage, myCountry};


        String words_arr[] = myCommand.split(" ", 3);
        while (!words_arr[0].equals("")) {
            String firstWord = words_arr[0];
            switch (firstWord) {
                case "HELLO":
                    helloWithName = bundle.getString("HELLO");
                    result_helloWithName = MessageFormat.format(helloWithName, myName);
                    System.out.println(result_helloWithName);
                    myCommand = keyboard.nextLine();
                    if (!myCommand.equals("HELLO"))
                    {
                        words_arr = myCommand.split(" ", 3);
                    }
                    if (!myCommand.equals("PURPOSE"))
                    {
                        words_arr = myCommand.split(" ", 3);
                    }
                    if (!myCommand.equals("START"))
                    {
                        words_arr = myCommand.split(" ", 3);
                    }
                    if (!myCommand.equals("EXIT"))
                    {
                        words_arr = myCommand.split(" ", 3);
                    }
                    break;
                case "START":
                    String startWithName = bundle.getString("START");
                    String result_startWithName = MessageFormat.format(startWithName, twoargs);
                    System.out.println(result_startWithName);
                    myCommand = keyboard.nextLine();
                    words_arr = myCommand.split(" ", 3);
                    break;
                case "I_AM":
                    System.out.println(result_iamWithName);
                    myCommand = keyboard.nextLine();
                    words_arr = myCommand.split(" ", 3);
                    break;
                case "PURPOSE":
                    String purpose = bundle.getString("PURPOSE");
                    String result_purpose = MessageFormat.format(purpose, "");
                    System.out.println(result_purpose);
                    myCommand = keyboard.nextLine();
                    words_arr = myCommand.split(" ", 3);
                    break;
                case "CHANGE":
                    String change = bundle.getString("CHANGE");
                   // String result_change = MessageFormat.format(change, twoargs);
                   // System.out.println(result_change);
                   // myCommand = keyboard.nextLine();
                    words_arr = myCommand.split(" ", 3);
                    myLanguage= words_arr[1];
                    myCountry= words_arr[2];
                    twoargs[0] = myLanguage;
                    twoargs[1] = myCountry;
                    String result_change = MessageFormat.format(change, twoargs);
                    System.out.println(result_change);
                    myCommand = keyboard.nextLine();
                    break;
                case "EXIT":
                    String exitDemand = bundle.getString("EXIT");
                    String result_exit = MessageFormat.format(exitDemand, "");
                    System.out.println(result_exit);
                    break;
                default:
                    // code block
            }
        }







    }

}
