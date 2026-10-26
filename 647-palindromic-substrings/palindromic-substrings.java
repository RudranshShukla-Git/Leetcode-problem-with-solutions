class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int totPals = 0;
        
        for(int i=0; i<n; i++)
        totPals += expandOut(s, i, i);

        for(int i=0; i<n; i++)
        totPals += expandOut(s, i, i+1);
        return totPals;
    }
    
    private int expandOut(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--; 
            right++;
        }
        return count;
    }
}