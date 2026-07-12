class Solution {
    public int[] singleNumber(int[] nums) {

        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int arr[] = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                arr[index++] = entry.getKey();
        }
      

        return arr;
    }
}
