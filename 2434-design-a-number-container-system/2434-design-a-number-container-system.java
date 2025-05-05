class NumberContainers {
       HashMap< Integer,Integer> idxtonum;
       Map<Integer, TreeSet<Integer>> numberToIndices;
    public NumberContainers() {
       idxtonum = new HashMap<>(); // index to num
       numberToIndices = new HashMap<>(); // num to index
    }
    public void change(int index, int number) {
        //delete old
        if(idxtonum.containsKey(index)){
            int oldnum = idxtonum.get(index);
            numberToIndices.get(oldnum).remove(index);
            }
        // insert new 
        idxtonum.put(index,number);
        if(!numberToIndices.containsKey(number)){
            numberToIndices.put(number, new TreeSet<>());
        }
        numberToIndices.get(number).add(index);
    }
    
    public int find(int number) {
        if(!numberToIndices.containsKey(number) || numberToIndices.get(number).isEmpty()){
            return -1;
        }
        return numberToIndices.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */