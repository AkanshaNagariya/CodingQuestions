public class Backtracking {
    public static void printpermutation(String str , String perm, int idx){
        if(str.length()==0){
            System.out.println(perm);
        }
        for(int i=0; i<str.length();i++){
            char currchar = str.charAt(i);   // initially A
            String newstr = str.substring(0, i)  + str.substring(i+1); // BC , 0 to i means 0 to i-1 , and i+1 til end
            printpermutation(newstr, perm + currchar, idx+1);  // (BC, A , 1) -> now this goes in func
                                                                // for this func runs for i = 0 , i = 1
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        printpermutation(str, " ", 0);   // this will go in func and loop runs for i = 0, i= 1 , i = 2 for this
    }                                                      // time complexity = n * n! 
}                                                          // n! are total combinations and it takes n steps to find 1 combinat
                                                        // ABC n = 3
