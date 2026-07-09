// class Solution {
//     public int hammingWeight(int n) {

//         String res = "";
//         int cnt = 0;

//         while (n > 0) {
//             if (n % 2 == 0) {
//                 res = "0" + res;
//             } else {
//                 res = "1" + res;
//                 cnt++;
//             }

//             n = n / 2;
//         }

//         return cnt;
//     }
// }

class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;

        while (n != 0) {
            cnt += (n & 1);
            n = n >> 1;      // Unsigned right shift
        }

        return cnt;
    }
}

// we can use n & n-1 continusly removing last 1 biit and get the cnt