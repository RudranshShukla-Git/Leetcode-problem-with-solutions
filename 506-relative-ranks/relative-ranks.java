class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < score.length; i++) {
            pq.offer(new int[]{score[i], i});
        }
        String[] result = new String[score.length];
        int cnt = 0;
        while(!pq.isEmpty()) {

            int[] pair = pq.poll();
            cnt++;

            if(cnt == 1)
                result[pair[1]] = "Gold Medal";
            else if(cnt == 2)
                result[pair[1]] = "Silver Medal";
            else if(cnt == 3)
                result[pair[1]] = "Bronze Medal";
            else
                result[pair[1]] = String.valueOf(cnt);
        }
        return result;
    }
}