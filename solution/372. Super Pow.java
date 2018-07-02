class Solution {
    private final int base = 1337;
    public int superPow(int a, int[] b) {
        int result = 1;
        for (int i = b.length - 1; i >= 0; i--){
            result = result * getPow(a, b[i]) % base;
            a = getPow(a, 10);
        }
        return result;
        
    }
    public int getPow(int a, int b){
        a %= base;
        int result = 1;
        for (int i = 0; i < b; i++){
            result = (result * a) % base;
        }
        return result;
    }
}