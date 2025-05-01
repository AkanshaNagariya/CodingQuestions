import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0); // to add elements in arraylist
        list.add(0);
        list.add(2);

        System.out.println(list);

        // get elements
        int a = list.get(0); 
        System.out.println(a);

        // add element in between list
        list.add(1,1); // add 1 on 1st position
        System.out.println(list);

        // change element of some index
        list.set(0,5);
        System.out.println(list);

        // remove element
        list.remove(2);   // remove this elemnt
        System.out.println(list);

        // size of arraylist
        int size = list.size();
        System.out.println(size);

        // loops
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println();
        
        // list in sorted ascending order , collection is a class
        Collections.sort(list);
        System.out.println(list);
    }
}
