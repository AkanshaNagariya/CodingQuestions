// calculating power in logn height of stack 
//       x^n 
//      /   \
//    x^n/2  x^n/2

import java.util.Scanner;
public class cal_power {
    public static int calpower(int x, int n){
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        // n is even
        if(n % 2 == 0){
            return calpower(x, n/2) * calpower(x, n/2);
        }
        else{
            return calpower(x, n/2) * calpower(x, n/2) * x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter value of x and n: ");
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("x^n is " + calpower(x, n));
    }
}
