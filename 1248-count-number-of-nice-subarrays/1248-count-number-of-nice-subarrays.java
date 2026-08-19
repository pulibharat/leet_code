class Solution {
    public int atmost(int[] nums, int k) {
        
     int n = nums.length;
     int left = 0;
     int right = 0;
     int cnt = 0;

     while(right < n){
      
      if(nums[right]%2 != 0){
        k--;
      }

      while(k < 0){
        
        if(nums[left]%2 != 0){
          k++;
        }

        left++;

      }

      cnt += right - left +1;
      right++;
     }

     return  cnt;

    }

    public int numberOfSubarrays(int[] nums, int k){
   
      return atmost(nums,k) - atmost(nums,k-1);

   }

}



// class Solution {
//     public int countSubarrays(int[] arr, int k) {
//         // code here
        
//         int n = arr.length;
//         int cnt = 0;
        
        
//         for(int i =0; i<n ;i++){
            
//             int oddcnt = 0;
            
//             for(int j =i;j<n;j++){
                
//                 if(arr[j]%2 != 0){
//                     oddcnt++;
//                 }
                
//                 if(oddcnt > k){
//                     break;
//                 }
                
//                 if( oddcnt == k){
//                     cnt++;
//                 }
//             }
//         }
        
//         return cnt;
//     }
// }
