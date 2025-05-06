class Solution {
    static int count;
    public static void sortMerge(int[] arr){
        int n=arr.length;
        if (n<=1) return ;
        int[] rightSortArray=new int[n/2];
        int[] leftSortArray=new int[n-n/2];
        int x=0;
        for (int i = 0; i < rightSortArray.length; i++) {
            rightSortArray[i]=arr[x];
            x++; 
        }
        for (int i = 0; i < leftSortArray.length; i++) {
            leftSortArray[i]=arr[x];
            x++; 
        }

        
        sortMerge(rightSortArray);
        sortMerge(leftSortArray);
        int a=0,b=0;
        while (a<rightSortArray.length && b<leftSortArray.length) {
            if ((long)rightSortArray[a]>2*(long)leftSortArray[b]){
                count+=rightSortArray.length-a;
                b++;
            }else a++;


        }



        int i=0,j=0,k=0;
        while (i<rightSortArray.length && j<leftSortArray.length) {
            if (rightSortArray[i]<leftSortArray[j]) {
                arr[k]=rightSortArray[i];
                i++;
            }else if (rightSortArray[i]>leftSortArray[j]) {
                arr[k]=leftSortArray[j];
                j++;
            }else{
                arr[k]=rightSortArray[i];
                i++;
                k++;
                arr[k]=leftSortArray[j];
                j++;
            }
            k++;
        }
        if (i==rightSortArray.length) {
            while(j<leftSortArray.length){
                arr[k]=leftSortArray[j];
                j++;
                k++;
            }
        }
        if (j==leftSortArray.length) {
            while(i<rightSortArray.length){
                arr[k]=rightSortArray[i];
                k++;
                i++;
            }
        }
        rightSortArray=null;
        leftSortArray=null;

    }
    public int reversePairs(int[] nums) {
        count=0;
        sortMerge(nums);
        return count;
    }
}