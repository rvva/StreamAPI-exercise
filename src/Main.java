import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        Path path = Paths.get("data.txt");
        try (Stream<String> stream = Files.lines(path)){

            List<String> valid = stream.filter(t -> t.matches("^(\\d+\\t){2}[mwMW](\\t+\\d+){5}$")).collect(Collectors.toList());
            List<Patient> patients = new ArrayList<>();

            valid.stream().forEach(t -> patients.add(new Patient(t)));

            System.out.println("Patients count: " + patients.size());
            System.out.println("Min age: " + patients.stream().mapToInt(t -> t.getAge()).min().getAsInt());
            System.out.println("Max age: " + patients.stream().mapToInt(t -> t.getAge()).max().getAsInt());

            System.out.println("Min age of men : " + patients.stream()
                    .filter(t -> String.valueOf(t.getGender()).matches("[mM]")).mapToInt(t -> t.getAge()).min().getAsInt());

            System.out.println("Min age of women : " + patients.stream().filter(t -> String.valueOf(t.getGender()).matches("[wW]")).mapToInt(t -> t.getAge()).min().getAsInt());

            System.out.println("Max age of men : " + patients.stream()
                    .filter(t -> String.valueOf(t.getGender()).matches("[mM]")).mapToInt(t -> t.getAge()).max().getAsInt());

            System.out.println("Max age of women : " + patients.stream()
                    .filter(t -> String.valueOf(t.getGender()).matches("[wW]")).mapToInt(t -> t.getAge()).max().getAsInt());

            System.out.println("Average age: " + patients.stream().mapToInt(t -> t.getAge()).sum()/patients.size());

            //wyswietlanie tylko mezczyzn
            patients.stream().filter(t -> String.valueOf(t.getGender()).matches("[mM]")).forEach(t -> System.out.println(t));

        } catch (IOException exception) {
            System.out.println("Błędna ścieżka!");
        }
    }
}
