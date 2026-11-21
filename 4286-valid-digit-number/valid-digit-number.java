class Solution {
    public boolean validDigit(int n, int x) {
        int mod = 0;
        boolean check = false;
        while(n > 0) {
            mod = n % 10;
            if(mod == x) {
                check = true;
            }
            n = n / 10;
        }
       if (mod != x && check) return true;
       return false;
    }
}