import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        int [] marks = new int[3];
        marks[0] = 98;
        marks[1] = 78;
        marks[2] = 90;
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        // another way to print
        System.out.println();
        int n=3;
        for(int i=0; i<n; i++){
            System.out.println(marks[i]);
        }

      //   int [] newmarks = {1,2,3,5,6}; another way to make array
      System.out.println();
      // user input for array
       Scanner sc = new Scanner(System.in);
      int size = sc.nextInt();
      int [] userarr = new int[size];
      for(int i=0; i<size; i++){
        userarr[i] = sc.nextInt();
      }
      System.out.println();
      for(int i=0; i<size; i++){
        System.out.println(userarr[i]);
    }

    }
}
