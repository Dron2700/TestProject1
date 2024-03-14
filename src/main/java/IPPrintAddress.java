import java.util.Scanner;
import java.util.regex.Pattern;

public class IPPrintAddress {
    String addressFrom;
    String addressTo;
    int[]  addressArrayFrom= new int[4];
    int[]  addressArrayTo= new int[4];

    private static Boolean compareIp  (IPPrintAddress ip){
        if (ip.addressFrom.equals(ip.addressTo)){
            return true;}
        else {
            return false;}
    }


    private static void fillIpAddressNumber (String str, int[] intArray ){
        String[] strArray = str.split(Pattern.quote("."));
        int valueOfString=0;
        if (strArray.length!=4){
            System.out.println("Не корректный адрес IP, не соответствует количество октетов");
            System.exit(0);
        }

        for (int i=0; i< strArray.length;i++){
            try{
                valueOfString=Integer.valueOf(strArray[i]);}
            catch (NumberFormatException e) {
                System.err.println("Неправильный формат строки!");
            }

            if (valueOfString>=0 && valueOfString<256){
                intArray[i]= valueOfString;
            }
            else {
                System.out.println("Не корректный адрес IP2");
                System.exit(0);
            }

        }
    }


    private static Boolean compareRangeIP (IPPrintAddress ipAddress){
        if (ipAddress.addressArrayTo[0]<=ipAddress.addressArrayFrom[0] & ipAddress.addressArrayTo[1]<=ipAddress.addressArrayFrom[1] &
                ipAddress.addressArrayTo[2]<=ipAddress.addressArrayFrom[2] & ipAddress.addressArrayTo[3]<=ipAddress.addressArrayFrom[3]) {
            return true;
        } else {
            return false;
        }
    }



    private static void printIp (IPPrintAddress ipAddress){
        int from3=ipAddress.addressArrayFrom[3]+1;
        int to1,to2,to3 ;//=ipAddress.addressArrayTo[3];

        System.out.println("Вывод диапазона:");

        while (ipAddress.addressArrayFrom[0]<=ipAddress.addressArrayTo[0] && ipAddress.addressArrayFrom[0]<256){

            if (ipAddress.addressArrayFrom[0]==ipAddress.addressArrayTo[0]){
                to1 =ipAddress.addressArrayTo[1];
            } else {
                to1=256;
            }

            while (ipAddress.addressArrayFrom[1]<=to1 && ipAddress.addressArrayFrom[1]<256 ){

                if (ipAddress.addressArrayFrom[1]==ipAddress.addressArrayTo[1]){
                    to2 =ipAddress.addressArrayTo[2];
                } else {
                    to2=256;
                }

                while (ipAddress.addressArrayFrom[2]<=to2 && ipAddress.addressArrayFrom[2]<256){

                    if (ipAddress.addressArrayFrom[2]==ipAddress.addressArrayTo[2]){
                        to3 =ipAddress.addressArrayTo[3];
                    } else {
                        to3=256;
                    }
                    while (from3<to3 && from3<256){

                        System.out.println(ipAddress.addressArrayFrom[0]+"."+ipAddress.addressArrayFrom[1]+"."+ipAddress.addressArrayFrom[2]+"."+from3);
                        from3++;

                    }
                    ipAddress.addressArrayFrom[2]++;
                    from3=0;

                }
                ipAddress.addressArrayFrom[1]++;
                ipAddress.addressArrayFrom[2]=0;

            }
            ipAddress.addressArrayFrom[0]++;
            ipAddress.addressArrayFrom[1]=0;
        }


    }

    public static void main(String[] args) {

        IPPrintAddress ipAddress = new IPPrintAddress();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начало диапазона:");
        ipAddress.addressFrom = scanner.nextLine();
        System.out.println("Введите конец диапазона:");
        ipAddress.addressTo = scanner.nextLine();

        //  ipAddress.addressFrom = "192.168.254.52";
        //  ipAddress.addressTo = "192.169.1.2";

        System.out.println("Введены значения диапазона:");
        System.out.println(ipAddress.addressFrom);
        System.out.println(ipAddress.addressTo);


        if ( compareIp(ipAddress)){
            System.out.println("Введены одинаковые значения");
            System.exit(0);
        }


        fillIpAddressNumber(ipAddress.addressFrom,ipAddress.addressArrayFrom);
        fillIpAddressNumber(ipAddress.addressTo,ipAddress.addressArrayTo);

        if (compareRangeIP(ipAddress)) {
            System.out.println("Введен не корректный диапазон");
            System.exit(0);
        }

        printIp(ipAddress);



    }

}