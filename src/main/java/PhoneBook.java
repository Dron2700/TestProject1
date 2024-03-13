import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {

    HashMap <String, ArrayList> numbersOfBook= new HashMap<>() ;

    public static void main(String[] args) {

        String fio;
        ArrayList<String> numbers ;
        int i=1;

        PhoneBook myBook = new PhoneBook();

        ArrayList<String> phoneNumbers1=new ArrayList<>();
        phoneNumbers1.add("+8 800 2000 500");
        phoneNumbers1.add("+8 800 200 600");
        myBook.numbersOfBook.put("Иванов И.И.", phoneNumbers1);

        ArrayList<String> phoneNumbers2=new ArrayList<>();
        phoneNumbers2.add("+8 800 2000 500");
        myBook.numbersOfBook.put("Петров П.П.", phoneNumbers2);

        ArrayList<String> phoneNumbers3=new ArrayList<>();
        phoneNumbers3.add("+8 800 2000 800");
        phoneNumbers3.add("+8 800 2000 900");
        phoneNumbers3.add("+8 800 2000 000");
        myBook.numbersOfBook.put("Сидоров С.С.", phoneNumbers3);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ФИО: ");
        fio = scanner.nextLine();

        if (myBook.numbersOfBook.containsKey(fio)){
            numbers=myBook.numbersOfBook.get(fio);
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


