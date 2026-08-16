class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();

        int l = 0;
        int r = 0;

        int HashLen = 256;
        int[] hash = new int[HashLen];
        Arrays.fill(hash, -1);

        int maxLen = 0;

        while (r < n) {

            // Character already exists in current/previous window
            if (hash[s.charAt(r)] != -1) {

                if (hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }

            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);

            hash[s.charAt(r)] = r; // hash[s.charAt(r)] -> gives number inside 

            r++;
        }

        return maxLen;
    }
}