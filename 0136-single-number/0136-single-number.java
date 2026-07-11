class Solution {
    public int singleNumber(int[] nums) {
//     int xorr=0;
//     for(int i=0;i<nums.length;i++){
//         xorr=xorr^nums[i];
//     }
// return xorr;

 HashMap<Integer,Integer> map = new HashMap<>();
 for(int x :nums){
    map.put(x,map.getOrDefault(x,0)+1);
 }
 
  for(int n : nums){
      if(map.get(n)==1){
              return n;
                  }
 }
 return -1;}
}