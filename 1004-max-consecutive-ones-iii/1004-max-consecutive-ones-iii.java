// brute force solution
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l =0;
        int r =0;
        int max =0;
        int zcnt =0;

        while(r<n){
        
        if(nums[r] == 0){
            zcnt++;
        }
        
        while( zcnt > k){
            if( nums[l] == 0){
                zcnt--;
            }
            l++;
        }
        
        int len = r - l +1;
        max = Math.max(len,max);
        r++;
        }
   
    return max;
    }
}


//   int n = nums.length;
//         // finding the max sub array with the max zeores]
       
//         int max = 0;
//         for(int i=0; i<n; i++){
//              int zcnt =0;
//             for(int j=i; j<n; j++){
//                 if(nums[j] == 0){
//                   zcnt++;
//                 }

//                 if(zcnt > k){
//                     break;
//                 }

//                 int len = j -i +1;
//                 max = Math.max(max,len);
//             }
           
//         }
//     return max;

