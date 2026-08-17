// class Solution {
//     public int characterReplacement(String s, int k) {
        
//      int n = s.length();
//      int maxLenght = 0;

//      for(int i =0;i<n;i++){
        
//         // freq array
//         int[] freq = new int[26];
//         int maxfreq = 0;
//         for(int j=i;j<n;j++){
          
//           // Increase frequency of current character
//           freq[s.charAt(j) - 'A']++;
//           // updating maxfre cnt
//           maxfreq = Math.max(maxfreq, freq[s.charAt(j) - 'A']);
//           // window size
//           int windowSize = j - i + 1;
//           // Calculate replacements needed to make all characters same
//           int replacements = windowSize - maxfreq;

//                 // If replacements are within k, update maxLength
//                 if (replacements <= k) {
//                     maxLenght = Math.max(maxLenght, windowSize);
//                 }

//         }
//      }
// return maxLenght;
//     }
// }

class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            int index = s.charAt(right) - 'A';
            freq[index]++;

            // Highest frequency character in current window
            maxFreq = Math.max(maxFreq, freq[index]);

            // Number of characters we need to replace
            int windowSize = right - left + 1;
            int replacements = windowSize - maxFreq;

            // If too many replacements, shrink window
            while (replacements > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                windowSize = right - left + 1;
                replacements = windowSize - maxFreq;
            }

            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
}