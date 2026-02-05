import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandLineInterface {
    private Map<String,Object> objects = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Skriv ett kommando: ");

        while (true) {
            String command = scanner.nextLine();
            System.out.println(handleCommand(command));

            switch (command) {

                case "load" :

            }
        }

    }

    public static String handleCommand(String command) {

    }

}