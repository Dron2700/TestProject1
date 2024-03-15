import java.util.Scanner;
import java.util.regex.Pattern;

public class IPAddressPrintRange {


    public static void main(String[] args) {

        String addressFrom,addressTo;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начало диапазона:");
        addressFrom = scanner.nextLine();
        System.out.println("Введите конец диапазона:");
        addressTo = scanner.nextLine();

        //  ipAddress.addressFrom = "192.168.254.52";
        //  ipAddress.addressTo = "192.169.1.2";

        IPAddressPrint( addressFrom , addressTo);

    }


    private static void IPAddressPrint ( String addressFrom, String addressTo){
        int[]  addressArrayFrom;
        int[]  addressArrayTo;

        System.out.println("Введены значения диапазона:");
        System.out.println(addressFrom);
        System.out.println(addressTo);

        try {
            compareIp(addressFrom,addressTo);

            addressArrayFrom = fillIpAddressNumber(addressFrom);
            addressArrayTo = fillIpAddressNumber(addressTo);

            compareRangeIP(addressArrayFrom,addressArrayTo);

            printIp(addressArrayFrom,addressArrayTo);

        } catch (Exception e ){
            System.out.println(printTrimException(e.toString()));
        }

    }

    private static void  compareIp  (String addressFrom, String addressTo) throws Exception {
        if (addressFrom.equals(addressTo)){
            throw new Exception("Введены одинаковые значения");}

    }


    private static  int[]  fillIpAddressNumber  (String str ) throws Exception {
        String[] strArray = str.split(Pattern.quote("."));
        int[] intArray= new int[4];
        int valueOfString=0;
        if (strArray.length!=4){
            throw new Exception("Не корректный адрес IP, не соответствует количество октетов");
        }

        for (int i=0; i< strArray.length;i++){
            valueOfString=Integer.valueOf(strArray[i]);

            if (valueOfString>=0 && valueOfString<256){
                intArray[i]= valueOfString;
            }
            else {
                throw new Exception("Не корректный адрес IP");
            }

        }
        return intArray;
    }


    private static  void compareRangeIP (int[] addressArrayFrom, int[] addressArrayTo ) throws Exception {
        if (addressArrayTo[0]<=addressArrayFrom[0] & addressArrayTo[1]<=addressArrayFrom[1] &
                addressArrayTo[2]<=addressArrayFrom[2] & addressArrayTo[3]<=addressArrayFrom[3]) {
            throw new Exception("Введен не корректный диапазон");
        }
        else { }
    }

    private static String printTrimException (String strError){
        if (strError.startsWith("java.lang.Exception:")){
            return "Ошибка: "+strError.substring(21,strError.length());
        } else {
            return strError;
        }
    }

    private static void printIp (int[] addressArrayFrom, int[] addressArrayTo){
        int from3=addressArrayFrom[3]+1;
        int to1,to2,to3 ;//=ipAddress.addressArrayTo[3];

        System.out.println("Вывод диапазона:");

        while (addressArrayFrom[0]<=addressArrayTo[0] && addressArrayFrom[0]<256){

            if (addressArrayFrom[0]==addressArrayTo[0]){
                to1 =addressArrayTo[1];
            } else {
                to1=256;
            }

            while (addressArrayFrom[1]<=to1 && addressArrayFrom[1]<256 ){

                if (addressArrayFrom[1]==addressArrayTo[1]){
                    to2 =addressArrayTo[2];
                } else {
                    to2=256;
                }

                while (addressArrayFrom[2]<=to2 && addressArrayFrom[2]<256){

                    if (addressArrayFrom[2]==addressArrayTo[2]){
                        to3 =addressArrayTo[3];
                    } else {
                        to3=256;
                    }
                    while (from3<to3 && from3<256){

                        System.out.println(addressArrayFrom[0]+"."+addressArrayFrom[1]+"."+addressArrayFrom[2]+"."+from3);
                        from3++;

                    }
                    addressArrayFrom[2]++;
                    from3=0;

                }
                addressArrayFrom[1]++;
                addressArrayFrom[2]=0;

            }
            addressArrayFrom[0]++;
            addressArrayFrom[1]=0;
        }


    }




}
