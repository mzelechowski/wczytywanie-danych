package pl.mzelechowski;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
// program odczytujący dane od użytkowania Imię, Nazwisko i zapisujący do pliku doddając date na początku każdej linii
    public static void main(String[] args) {
        List<User> users = getUsers();




    }
        private static List<User> getUsers(){
            Scanner scanner = new Scanner(System.in);
            List<User> users = new ArrayList<>();
            System.out.println("Podaj dane klienta (imię, nazwisko, wiek oddzielając spacją): ");
            String input = scanner.nextLine();
            while(!input.equalsIgnoreCase("x")) {
                String[] inputs = input.split(" ");
                users.add(new User(fromUtilToString(new Date()), inputs[0], inputs[1], Integer.valueOf(inputs[2])));
                System.out.println("Podaj dane kolejnego klienta (imię, nazwisko, wiek oddzielając spacją): ");
                input = scanner.nextLine();
            }
            return users;
        }

        private static  String fromUtilToString(Date date){
         DateFormat newFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         return newFormat.format(date);
        }

        private static void saveToFile(String filename, List<User> users) throws IOException {
            String folder = "C:\\Mike\\operacje-na-plokach\\src\\storage\\";
            String fileName = "jakisplik";
            String fileExtension="csv";
            Path path = Paths.get(folder+fileName+fromUtilToString(new Date())+fileExtension);
            if(Files.notExists(path)) Files.createFile(path);
            StringBuilder sb = new StringBuilder();
            for(User u:users){
                sb.append(u.getDate()).append(";")
                        .append(u.getName()).append(";")
                        .append(u.getLastName()).append(";")
                        .append(u.getAge()).append("\n");
                Files.write(path, sb.toString().getBytes(), StandardOpenOption.APPEND);
            }
        }
}
