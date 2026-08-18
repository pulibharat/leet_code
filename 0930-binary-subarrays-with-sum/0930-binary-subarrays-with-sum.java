class Solution {

      public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
      }

    public int atMost(int[] nums, int goal) {

      int n = nums.length;

      if(goal < 0) return 0;
        
        int left =0;
        int right =0;
        int cnt = 0;
        int sum = 0;

        while(right < n){
          
          sum += nums[right];

          while(sum > goal){
            sum -= nums[left];
            left++;
          }
          
          cnt += right - left + 1;
          right++;
        }
    return cnt; 
      }

    }














// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {

//         int n = nums.length;
//         int cnt = 0;

//         for(int i = 0; i < n; i++) {

//             int sum = 0;

//             for(int j = i; j < n; j++) {

//                 sum += nums[j];

//                 if(sum == goal) {
//                     cnt++;
//                 }

//                 if(sum > goal) {
//                     break;
//                 }
//             }
//         }

//         return cnt;
//     }
// }