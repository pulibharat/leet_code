// class Solution {
//     public int[] singleNumber(int[] nums) {

//         int n = nums.length;
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }

//         int arr[] = new int[2];
//         int index = 0;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if (entry.getValue() == 1)
//                 arr[index++] = entry.getKey();
//         }
      

//         return arr;
//     }
// }


// 1. Why do we find the rightmost set bit?

// Expected answer:

// It identifies a bit where the two unique numbers differ. Using that bit, we can separate them into different groups.

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        int n = xor&(xor-1);
        int mask =xor^n;
        int b1 =0;int b2=0;
        for(int ele : nums){
            if((ele&mask)==0) b1^=ele;
            else b2^=ele; 
        }    
        int[] ans ={b1,b2};
        return ans;
    }
}