import java.util.Arrays;
import java.util.Enumeration;

void main() {
    printDigits(100); //[1,0,0]
    printDigits(1250);
    printDigits(10);
}

//void printDigits(int number) {
//    String numberSt = STR."\{number}";
//    System.out.print("[");
//    for (int i = 0; i < numberSt.length(); i++) {
//        System.out.print(STR."\{numberSt.charAt(i)},");
//    }
//    System.out.println("\b]");
//
//}

void printDigits(int number) {

    int num = number;
    int count = 0;
    while (num != 0) {
        count++;
        num /= 10;
    }
    int[] numArray = new int[count];

    num = number;
    while (num != 0) {
        numArray[count - 1] = num % 10;
        num /= 10;
        count--;
    }

    System.out.println(Arrays.toString(numArray));


    System.out.println("=============");
    //second method
    int power = 1;
    count = 0;
    while ((number / (power *= 10)) != 0) count++;
    power /= 10;

    System.out.print("[");
    while (count-- >= 0) {
        System.out.print(number / power + ",");
        number %= power;
        power /= 10;
    }
    System.out.println("\b]");

//    count = numArray.length - 1;
//    while (num != 0) {
//        numArray[numArray.length - 1 - count] = num / (int) Math.pow(10, count);
//        num = num % (int) Math.pow(10, count);
//        count--;
//    }
//    System.out.println(Arrays.toString(numArray));

}