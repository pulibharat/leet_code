// class Solution {
//     public int maxScore(int[] cardPoints, int k) {

//         int n = cardPoints.length;

//         // Invalid k cannot form a valid selection.
//         if (k < 0 || k > n) {
//             return -1;
//         }

//         // Picking no cards gives a score of zero.
//         if (k == 0) {
//             return 0;
//         }

//         // Picking all cards requires the complete array sum.
//         if (k == n) {
//             int total = 0;

//             for (int value : cardPoints) {
//                 total += value;
//             }

//             return total;
//         }

//         int sum = 0;
//         int max = 0;

//         for (int leftsum = 0; leftsum <= k; leftsum++) {

//             int rightsum = k - leftsum;
//             sum = 0;

//             // Picking cards from the left
//             for (int i = 0; i < leftsum; i++) {
//                 sum += cardPoints[i];
//             }

//             // Picking cards from the right
//             for (int j = 0; j < rightsum; j++) {
//                 sum += cardPoints[n - 1 - j];
//             }

//             max = Math.max(max, sum);
//         }

//         return max;
//     }
// }



class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int sum = 0;

        // Initially, take all k cards from the left
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }

        int max = sum;

        // Replace left cards with right cards, one by one
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[k - 1 - i]; // Remove a left card
            sum += cardPoints[n - 1 - i]; // Add a right card

            max = Math.max(max, sum);
        }

        return max;
    }
}