#clear bit
public class clearbitmanupilation {
    public static void main(String[] args) {
        // clear bit
        // Q. clear the 3rd bit (pos = 2 from right to left in num 5) of number n , n= 0101 i.e 5
        int n = 5;  // given number 5 i.e 0101
        int pos = 2; // position upto which we will left shift 1 i.e 0001 
        int bitMask = 1<<pos; // left shit 1 
        int notBitMask = ~(bitMask); // not operation 

        int newNumber = notBitMask &  n;  // and of n and bitmask gives bit on that pos , and of n and not of bitmask will change
                                           // that bit , 1 to 0 and viceversa so bit will be clear
        System.err.println(newNumber);
    }
}
