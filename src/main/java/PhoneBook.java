import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PhoneBook implements Serializable {

private    HashMap <String, ArrayList> numbersOfBook= new HashMap<>() ;

    public ArrayList<String> getContact (String fio){
        return  this.numbersOfBook.get(fio);
    }

   public boolean hasContact (String fio){
       return this.numbersOfBook.containsKey(fio) ;

   }

   public void fillDefaultValue (){
//       String fio;
//       ArrayList<String> numbers ;
//       int i=1;

       ArrayList<String> phoneNumbers1=new ArrayList<>();
       phoneNumbers1.add("+8 800 2000 500");
       phoneNumbers1.add("+8 800 200 600");
       this.numbersOfBook.put("Иванов И.И.", phoneNumbers1);

       ArrayList<String> phoneNumbers2=new ArrayList<>();
       phoneNumbers2.add("+8 800 2000 500");
       this.numbersOfBook.put("Петров П.П.", phoneNumbers2);

       ArrayList<String> phoneNumbers3=new ArrayList<>();
       phoneNumbers3.add("+8 800 2000 800");
       phoneNumbers3.add("+8 800 2000 900");
       phoneNumbers3.add("+8 800 2000 000");
       this.numbersOfBook.put("Сидоров С.С.", phoneNumbers3);

   }

   public void addContact (String fio, ArrayList<String> phoneNumbers) {

       this.numbersOfBook.put(fio,phoneNumbers);

   }

    public void printContact (String fio){

        ArrayList<String> numbers ;
        int i=1;
        if (this.hasContact(fio)){

            numbers = this.getContact(fio);

            for (String number:numbers) {
                System.out.println(i+". "+number);
                i++;
            }
        }
        else {
            System.out.println("Такого ФИО в БД нет");
        }
    }

   public void fillFromFile (String  path) throws FileNotFoundException {
       File file = new File ( path);
       Scanner scanner = new Scanner (file);
       int endFIOposition;

       while ( scanner.hasNextLine() ) {
           String lineFile = scanner.nextLine();
           endFIOposition = lineFile.indexOf("+");
           String fio = lineFile.substring(0, endFIOposition).trim();
           ArrayList<String> phoneNumbers=new ArrayList<>();
           String []  phoneNumber= lineFile.substring(endFIOposition,lineFile.length()).split(Pattern.quote("+"));
           for (String number:phoneNumber){

               if (!number.equals("")){
               phoneNumbers.add("+"+number.trim());}
           }
           this.addContact(fio,phoneNumbers);

       }
       scanner.close();

   }


   public void savePhoneBookToFile (String fileName) throws IOException {


       File fileToSave = new File(fileName);
       FileOutputStream fileOuputStream = new FileOutputStream( fileToSave );
       ObjectOutputStream objectSave = new ObjectOutputStream(fileOuputStream);
       objectSave.writeObject(this);
       objectSave.close();

   }

   public Object loadPhoneBookFromFile (String fileName) throws IOException, ClassNotFoundException {

        File fileToSave = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(fileToSave);
        ObjectInputStream objectLoad = new ObjectInputStream(fileInputStream);
        PhoneBook pb = (PhoneBook) objectLoad.readObject();
        objectLoad.close();
        return pb;

   }

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


