class RideSharingSystem {
    private int time;

    private TreeSet<int[]> riders;

    private TreeSet<int[]> drivers;

    private Map<Integer, Integer> riderTime;
    public RideSharingSystem() {
        time = 0;

        riders = new TreeSet<>(
            (a,b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0],b[0]);

                return Integer.compare(a[1],b[1]);
            }
        );
        drivers = new TreeSet<>(
            (a,b) -> {
                if(a[0] != b[0]) return Integer.compare(a[0], b[0]);

                return Integer.compare(a[1],b[1]);
            }
        );
        riderTime = new HashMap<>();
    }
    
    public void addRider(int riderId) {
        riderTime.put(riderId, time);

        riders.add(new int[]{time, riderId});

        time++;
    }
    
    public void addDriver(int driverId) {
        drivers.add(new int[]{time, driverId});
        time++;
    }
    
    public int[] matchDriverWithRider() {
        if(riders.isEmpty() || drivers.isEmpty()) {
            return new int[]{-1,-1};
        }
        int[] driver = drivers.pollFirst();

        int[] rider = riders.pollFirst();

        return new int[]{driver[1], rider[1]};
    }

    
    public void cancelRider(int riderId) {
        Integer t = riderTime.get(riderId);

        if(t == null){
            return;
        }
        riders.remove(new int[]{t, riderId});
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */