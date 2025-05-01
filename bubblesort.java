public class bubblesort {
    public static void main(String[] args) {
        int [] arr = {7,8,3,1,2};
        int n = arr.length;

        for(int i=0; i<n-1; i++){  // n times
            for(int j=0; j<n-i-1 ; j++){  // n times then n-1 times then n-2 times, every times we are ignoring the sorted element we
                                             // get at last
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }                                 // time complexity O(n^2)
            }
        }
        System.out.println(" sorted array ");
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
        }
        }
    }
