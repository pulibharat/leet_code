// class Solution {
//     public int maximalRectangle(char[][] matrix) {
        
//     // function to find the max area of an array
    
//     int function(int arr[], int n, int row =1){

//         Stack<Integer> stack = new Stack<>();
//         int maxarea = -1;
 
//         for(int i=0;i<n;i++){

//             while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
//                 int element = arr[satck.pop()];
//                 int next = i;
//                 int prev = stack.isEmpty? -1 : arr[i];
//                 int area = row * (next - prev -1)

//                 maxarea = Math.max(maxarea, area);
//             }
           
//            stack.push(arr[i]);
             
//         }

//         while(!stack.isEmpty){

//             int next = n;
//             int prev = satck.isEmpty()? -1 : satck.peek()
//             int area = row * (next - prev -1)
//             maxarea = Math.max(maxarea, area);
//         }

//         return maxarea;
//     }
    
//     int n = matrix.length[0];
//     int m = matrix.length[1];
//     int arr[] = new int[m];
//    for(int i =0;i<n;i++){
//     for(int j=0;j<m;j++){
        
//         arr[j] += matrix[i][j];
//     }
//    int ans =  fun(arr[j],m,i+1);
//    }
//    return ans;
//     }
// }


class Solution {

    // Function to find the largest rectangle in a histogram
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int next = i;
                int prev = stack.isEmpty() ? -1 : stack.peek();

                int width = next - prev - 1;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int next = n;
            int prev = stack.isEmpty() ? -1 : stack.peek();

            int width = next - prev - 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Build histogram for current row
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            ans = Math.max(ans, largestRectangleArea(heights));
        }

        return ans;
    }
}