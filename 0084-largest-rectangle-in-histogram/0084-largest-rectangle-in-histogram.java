// class Solution {

//     public int findpsmallest(int arr[], int n) {

//         for (int i = n - 1; i >= 0; i--) {
//             if (arr[i] < arr[n]) {
//                 return i;      // return index
//             }
//         }

//         return -1;
//     }

//     public int findnsmallest(int arr[], int n) {

//         for (int i = n + 1; i < arr.length; i++) {
//             if (arr[i] < arr[n]) {
//                 return i;      // return index
//             }
//         }

//         return arr.length;
//     }

//     public int largestRectangleArea(int[] heights) {
//        int ans = 0;
//         for (int i = 0; i < heights.length; i++) {
//             int presmallest = findpsmallest(heights, i);
//             int nextsmallest = findnsmallest(heights, i);
//              int num = heights[i] * (nextsmallest - presmallest-1);
//              ans = Math.max(ans,num);
//         }
//         return ans;
//     }
// }

class Solution {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxarea = -1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && (heights[stack.peek()] > heights[i])) {
                int element = heights[stack.pop()];
                int prev = stack.isEmpty() ? -1 : stack.peek();
                int next = i;

                maxarea = Math.max(maxarea, element * (next - prev - 1));
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            // imaginary next n and prev -1
            int element = heights[stack.pop()];
            int next = n;
            int prev = stack.isEmpty() ? -1 : stack.peek();

            maxarea = Math.max(maxarea, element * (next - prev - 1));

        }
        return maxarea;
    }
}