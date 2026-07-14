// bruite force TLE
// class Solution {
//     public double myPow(double x, int n) {

//         if (x == 1 || n == 0)
//             return 1;

//         long temp = n;

//         if (n < 0) {
//             temp = -1L * n;
//             x = 1 / x;
//         }

//         double ans = 1;
//         for (long i = 1; i <= temp; i++) {
//             ans *= x;
//         }

//         return ans;
//     }
// }

class Solution {
    public double myPow(double x, int n) {
     

    if( x ==1 || n ==0) return 1;
    
    long temp = n;
    if(n < 0){
       temp = -temp;
       x = 1/x;
    }
   
   double ans = 1;
    while(temp > 0){
     
     if(temp % 2 ==1){
        ans = x* ans;
        temp --;
     }

     else {
        x = x*x;
        temp /= 2;
     }

    }
return ans;

    }
}