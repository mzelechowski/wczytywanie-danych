package pl.mzelechowski;

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
        try {
            saveToFile("listaosob", users);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
        private static List<User> getUsers(){
            Scanner scanner = new Scanner(System.in);
            List<User> users = new ArrayList<>();
            System.out.println("Podaj dane klienta (imię, nazwisko, wiek oddzielając spacją): ");
            String input = scanner.nextLine();
            while(!input.equalsIgnoreCase("x") && !input.isEmpty()) {
                String[] inputs = input.split(" ");
                users.add(new User(fromUtilToString(new Date()), inputs[0], inputs[1], Integer.parseInt(inputs[2])));
                System.out.println("Podaj dane kolejnego klienta (imię, nazwisko, wiek oddzielając spacją): ");
                input = scanner.nextLine();
            }
            return users;
        }

        private static  String fromUtilToString(Date date){
         DateFormat newFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         return newFormat.format(date);
        }

        private static void saveToFile(String fileName, List<User> users) throws IOException {
            String folder = "C:\\Mike\\wczytywanie-danych\\src\\";
            String fileExtension=".csv";
            Path path = Paths.get(folder+fileName+fromUtilToString(new Date()).split(" ")[0]+fileExtension);
            if(Files.notExists(path)) {
                Files.createFile(path);
                String columns ="Date; Name; Last Name; Age\n";
                Files.write(path, columns.getBytes(), StandardOpenOption.APPEND);
            }
            for(User u:users){
                String sb=u.getDate()+";"+u.getName()+";"+u.getLastName()+";"+u.getAge()+"\n";
                Files.write(path, sb.getBytes(), StandardOpenOption.APPEND);
            }
        }
}
