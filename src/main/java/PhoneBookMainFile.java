import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneBookMainFile {

    public static void main(String[] args) throws FileNotFoundException {

        String fio;
        PhoneBook myBook= new PhoneBook();

        myBook.fillFromFile("c:\\Users\\Dron2\\IdeaProjects\\TestProjects1\\src\\main\\java\\PhoneNumber");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        fio = scanner.nextLine();

        myBook.printContact(fio);

    scanner.close();

    }
}
