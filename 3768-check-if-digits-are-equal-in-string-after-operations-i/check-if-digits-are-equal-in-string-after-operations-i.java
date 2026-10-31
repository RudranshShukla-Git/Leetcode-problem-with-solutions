class Solution {
    public boolean hasSameDigits(String s) {
        char[] d = s.toCharArray();
        int n = d.length;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                int a = d[j] - '0', b = d[j + 1] - '0';
                d[j] = (char) ((a + b) % 10 + '0');
            }
        }
        return d[0] == d[1];
    }
}