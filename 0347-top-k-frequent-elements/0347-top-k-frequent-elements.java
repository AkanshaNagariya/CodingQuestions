class Number implements Comparable<Number> {
    int element;
    int freq;
    Number(int element, int freq){
        this.element = element;
        this.freq = freq;
    }
    public int compareTo(Number that){
        // min heap
        return this.freq - that.freq; // inc
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int element : nums){
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : freqMap.entrySet()) {
            Number number = new Number(entry.getKey(), entry.getValue());
            pq.offer(number);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int res [] = new int[k];
        int idx = 0;
        while(idx < k){
            Number number = pq.poll();
            res[idx] = number.element;
            idx++;
        }
        return res;
   }
}