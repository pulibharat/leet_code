// brute force solution
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        // finding the max sub array with the max zeores]
       
        int max = 0;
        for(int i=0; i<n; i++){
             int zcnt =0;
            for(int j=i; j<n; j++){
                if(nums[j] == 0){
                  zcnt++;
                }

                if(zcnt > k){
                    break;
                }

                int len = j -i +1;
                max = Math.max(max,len);
            }
           
        }
    return max;
    }
}

