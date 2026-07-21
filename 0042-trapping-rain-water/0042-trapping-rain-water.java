// class Solution {
//     public int trap(int[] height) {

//      int n = height.length;
        
//         // Variable to store total trapped water
//         int totalWater = 0;
        
//         // Iterate over each bar in the elevation map
//         for (int i = 0; i < n; i++) {
//             // Initialize max heights to the left and right of current bar
//             int maxLeft = 0;
//             int maxRight = 0;
            
//             // Find maximum height to the left of current bar
//             for (int j = 0; j <= i; j++) {
//                 if (height[j] > maxLeft) {
//                     maxLeft = height[j];
//                 }
//             }
            
//             // Find maximum height to the right of current bar
//             for (int j = i; j < n; j++) {
//                 if (height[j] > maxRight) {
//                     maxRight = height[j];
//                 }
//             }
            
//             // Water trapped on current bar is min of maxLeft and maxRight minus current height
//             totalWater += Math.min(maxLeft, maxRight) - height[i];
//         }
        
//         // Return total trapped water
//         return totalWater;

//     }
//     }


class Solution {
    public int trap(int[] height) {

        int n = height.length;
        if (n == 0) return 0;

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        // Build prefix max
        prefixMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }

        // Build suffix max
        suffixMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        int totalWater = 0;

        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            totalWater += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }

        return totalWater;
    }
}
