// class Solution {
//     public int totalFruit(int[] fruits) {

//         int n = fruits.length;
//         int max = 0;

//         int left = 0;
//         int right = 0;
//         HashMap<Integer, Integer> basket = new HashMap<>();
//         while (right < n) {

//             // putting inside basket
//             basket.put(fruits[j], basket.getOrDefault(fruits[j], 0) + 1);

//             // checking size
//             if (basket.size() > 2) {
//             // removibg the left fruit cnt
//              basket.put(fruits[left],basket.getOrtDefault(fruits[j],0)-1);
            
//             if(basket.get(fruits[j])==0){
//                 basket.remove(fruits[left]);
//             }
//             left++;
//             }
//             max = Math.max(max,right-left+1);
//         }
// return max;
//     }
// }


class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int max = 0;

        int left = 0;
        int right = 0;

        HashMap<Integer, Integer> basket = new HashMap<>();

        while (right < n) {

            // Add fruit at right
            basket.put(
                fruits[right],
                basket.getOrDefault(fruits[right], 0) + 1
            );

            // More than 2 types
            if (basket.size() > 2) {

                // Remove fruit at left
                basket.put(
                    fruits[left],
                    basket.getOrDefault(fruits[left], 0) - 1
                );

                // Completely remove the fruit type
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }
}