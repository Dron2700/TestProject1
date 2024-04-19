import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookMainFile {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String fio;
        PhoneBook myBook= new PhoneBook();

        myBook.fillFromFile(".\\src\\main\\java\\PhoneNumber");

        try {
            myBook.savePhoneBookToFile(".\\src\\main\\java\\person.dat");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        PhoneBook myBook2= new PhoneBook(".\\src\\main\\java\\person.dat");

//        try {
//              myBook2=  new PhoneBook(".\\src\\main\\java\\person.dat");
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } catch (ClassNotFoundException e) {
//            System.out.println(e.getMessage());
//        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        fio = scanner.nextLine();

        myBook2.printContact(fio);

    scanner.close();







    }






}
