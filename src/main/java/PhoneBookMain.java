import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookMain {
    public static void main(String[] args) {
        PhoneBook myBook= new PhoneBook();

        myBook.fillDefaultValue();

        String fio;
        ArrayList<String> numbers ;
        int i=1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        fio = scanner.nextLine();




        if (myBook.hasContact(fio)){
            numbers=myBook.getContact(fio);
            for (String number:numbers) {
                System.out.println(i+". "+number);
                i++;
            }
        }
        else {
            System.out.println("Такого ФИО в БД нет");
        }


    }
}
