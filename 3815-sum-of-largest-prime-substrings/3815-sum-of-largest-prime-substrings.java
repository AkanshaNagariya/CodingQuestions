class Solution {
    private static boolean checkprime(long n){
        if(n <= 1) return false;
        if(n == 2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        long k=5;
        while(k*k <= n){
            if(n % k==0 || n % (k+2) ==0)
                return false;
            k += 6;
        }
        return true;
    }
    public long sumOfLargestPrimes(String s) {
        Set<Long> set = new HashSet<>();
        int l = s.length();
        for(int i=0;i<l;i++){
            for(int j=i+1; j<=l && j-i<=10;j++){
                String part = s.substring(i,j);
                if(part.length()> 1 && part.charAt(0) == '0'){
                   continue;                                         
                } 
                long n = Long.parseLong(part);
                if(checkprime(n)){
                    set.add(n);
                }
            }
        }
        List<Long> prime = new ArrayList<>(set);
        Collections.sort(prime, Collections.reverseOrder());
        long ans = 0;
        for(int i=0;i<Math.min(3,prime.size());i++){
            ans += prime.get(i);
        }
        return ans;
    }
}