class ATM {
    long[] count;

    int[] money = {20,50,100,200,500};
    public ATM() {
        count = new long[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0;i < 5;i++){
            count[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] result = new int[5];
        for(int i = 4;i >=0;i--){
            long canTake = amount / money[i];

            long take = Math.min(count[i], canTake);

            result[i] = (int) take;

            amount-=take*money[i];
        }

        if(amount!=0){
            return new int[]{-1};
        }
        for(int i = 0;i<5;i++){
            count[i]-=result[i];
        }
        return result;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */