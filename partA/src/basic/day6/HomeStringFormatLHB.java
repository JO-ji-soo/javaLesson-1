//<<<<<<< HEAD
package basic.day6;
//=======

//>>>>>>> 35cf5277f87f5edfd9e2a6e7456dd76859917aa7

public class HomeStringFormatLHB {
    public static void main(String[] args) {
        int start = 10;

        // String.format을 사용해서 10부터 20까지의 수들을 10진수, 8진수, 16진수로 표시

        // 10진수
        while (start <= 20) {
            System.out.print(String.format("%d ", start++));
        }
        System.out.println();
        start = 10;

        // 8진수
        while (start <= 20) {
            System.out.print(String.format("%o ", start++));
        }
        System.out.println();
        start = 10;

        // 16진수
        while (start <= 20) {
            System.out.print(String.format("%x ", start++));
        }

    }
}
//<<<<<<< HEAD
 
//=======
//>>>>>>> 35cf5277f87f5edfd9e2a6e7456dd76859917aa7
