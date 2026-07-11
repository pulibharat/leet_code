// class Solution {
//     public int divide(int dividend, int divisor) {
        

//        // checking basic condition

//        if(dividend == divisor) return 1;
//        if(divisor == 1) return dividend;
//        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // managing over flow condition

//        // checking the sign
     
//        boolean pos = true;

//        if(dividend < 0 && divisor > 0) pos = false;
//        if(dividend > 0 && divisor < 0) pos = false;

//        // storing abs values

//         long n = Math.abs((long) dividend);
//         long d = Math.abs((long) divisor);

//        int sum = 0, cnt = 0;

//        while(sum+d <= n){  // instead of mul,div we arte using the addition and cnt how many time it can occur
//        sum += d;
//        cnt++;
//        }


//        // overflow condition the can occur
//        if(cnt > Integer.MAX_VALUE && pos) return Integer.MAX_VALUE;
//        if(cnt > Integer.MAX_VALUE && !pos) return Integer.MIN_VALUE;


//         int val = pos?  (int)cnt : (int)(-1*cnt);


//   return val;
//     }
// }



class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Same numbers
        if (dividend == divisor)
            return 1;
        
        if( divisor == 1)
            return dividend;

        // Determine sign
        boolean positive = (dividend >= 0) == (divisor >= 0);

        // Convert to positive long values
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quotient = 0;

        while (n >= d) {

            int cnt = 0;

            // Find the largest power of 2 multiple of divisor
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            quotient += (1L << cnt);
            n -= (d << cnt);
        }

        if (!positive)
            quotient = -quotient;

        return (int) quotient;
    }
}