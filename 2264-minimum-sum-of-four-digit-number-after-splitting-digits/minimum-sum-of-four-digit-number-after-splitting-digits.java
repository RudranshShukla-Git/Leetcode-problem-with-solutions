class Solution {
    public int minimumSum(int num) {
        int min1 = 10;
        int min2 = 10;
        int sum = 0;
        while(num>0){
            int x = num%10;
            sum+=x;
            if(x<min1) {
                min2 = min1;
                min1 = x;
            }else if(x<min2) {
                min2 = x;
            }
            num/=10;
        }
        int y = min1 + min2;
        int z = sum - y;
        return 10*y + z;
    }
}