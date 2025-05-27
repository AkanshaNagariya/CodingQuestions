class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq = new int[26];
        for(char ch : tasks) {
            freq[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<26; i++){
            if(freq[i] > 0) {
                pq.add(freq[i]);
            }
        }
        int time = 0;
        while(!pq.isEmpty()){
            int interval = n + 1;
            List<Integer> ll = new ArrayList<>();
            int taskcnt = 0;
            while(interval-- > 0 && !pq.isEmpty()){
                int currfreq = pq.poll();
                if(currfreq > 1){
                    ll.add(currfreq -1);
                }
                taskcnt++;
            }
            ll.forEach(pq::add);
            time += (pq.isEmpty()? taskcnt : n+1);
        }
        return time;
    }
}