import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookMainFile {

    public static void main(String[] args) throws FileNotFoundException {

        PhoneBook myBook= new PhoneBook();

        myBook.fillFromFile("c:\\Users\\Dron2\\IdeaProjects\\TestProjects1\\src\\main\\java\\PhoneNumber");


        String fio;
        ArrayList<String> numbers ;
        int i=1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        fio = scanner.nextLine();




        if (myBook.numbersOfBook.containsKey(fio)){
//            System.out.println("contact true");
//            numbers = myBook.numbersOfBook.get(fio);
            numbers = myBook.getContact(fio);
//            System.out.println(numbers.toString());
            for (String number:numbers) {
                System.out.println(i+". "+number);
                i++;
            }
        }
        else {
            System.out.println("Такого ФИО в БД нет");
        }

    scanner.close();

    }
}
