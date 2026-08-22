class Solution {
    public boolean checkDivisibility(int n) {
        int num = n;
        int sum = 0;
       int prod = 1;
        while(n != 0){
            int rem = n % 10;
            sum = sum + rem;
            prod = prod * rem;
            n = n / 10;
        }
        int totalsum = sum + prod;
        return num%totalsum == 0;
    }
}