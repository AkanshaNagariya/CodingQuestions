
// bit maupilation (0,1)
// get , srt , clear, update bit.
public class bitmanupilation {
    public static void main(String[] args) {
        // Get bit 
        // Q. get the 3rd bit (pos = 2 from right to left in num 5) of number n , n= 0101 i.e 5
        int n = 5;  // the number with which we want to check , 5 i.e 0101
        int pos = 2; // position upto which we will left shift 1 i.e 0001 
        int bitMask = 1<<pos;

        if((bitMask & n)== 0){  // after we left shift 1 by 2 pos in 5 we get bitmask = 0100. after this multiply original no 5 and 
                                  // bitmask , if the value is postive , bit is get on pos 2
            System.out.println("bit was zero");
        }
        else{
            System.out.println("bit was one");
        }
    }
}
