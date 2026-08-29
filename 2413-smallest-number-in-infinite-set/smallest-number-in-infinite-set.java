class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    HashSet<Integer> set;
    int next; 
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        set = new HashSet<>();
        next = 1;
    }
    
    public int popSmallest() {
        if(!pq.isEmpty()) {
            int num = pq.poll();
            set.remove(num);
            return num;
        }
        return next++;
    }
    
    public void addBack(int num) {
        if(num < next && !set.contains(num)) {
            pq.add(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */