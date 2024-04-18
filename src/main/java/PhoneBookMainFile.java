import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookMainFile {

    public static void main(String[] args) throws FileNotFoundException {

        String fio;
        PhoneBook myBook= new PhoneBook();

        myBook.fillFromFile("c:\\Users\\Dron2\\IdeaProjects\\TestProjects1\\src\\main\\java\\PhoneNumber");

        try {
            myBook.savePhoneBookToFile("c:\\Users\\Dron2\\IdeaProjects\\TestProjects1\\src\\main\\java\\person.dat");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        PhoneBook myBook2= new PhoneBook();

        try {
        myBook2= (PhoneBook) myBook2.loadPhoneBookFromFile("c:\\Users\\Dron2\\IdeaProjects\\TestProjects1\\src\\main\\java\\person.dat");

       //     myBook2.loadPhoneBookFromFile("c:\\Users\\Dron2\\IdeaProjects\\TestProjects1\\src\\main\\java\\person.dat");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        fio = scanner.nextLine();

        myBook2.printContact(fio);

    scanner.close();







    }






}
