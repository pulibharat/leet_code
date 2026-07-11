class Solution {
    public int minBitFlips(int start, int goal) {

        // helps in converting the diff one to 1
        int ans = start ^ goal;

        // cnting the set
         int cnt = 0;
        for (int i = 0; i < 32; i++) {
           if((ans & (1<<i))!= 0){
            cnt++;
           }

        }
       return cnt;
    }
}