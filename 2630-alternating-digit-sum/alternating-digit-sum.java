class Solution {
    public int alternateDigitSum(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n!=0){
            int r=n%10;
            list.add(r);
            n=n/10;
        }
        int sum=0;
        int count=0;
        for(int i=list.size()-1;i>=0;i--){
            if(count%2==0){
                sum=sum+list.get(i);
            }
            else{
                sum=sum-list.get(i);
            }
            count++;
        }
        return sum;
    }
}