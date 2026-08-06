class Solution {
    public int lengthOfLongestSubstring(String s) {
        
     int n = s.length();

     int len =0;
     for(int i=0;i<n;i++){
        HashMap<Character,Integer> map = new HashMap<>();

        for(int j=i;j<n;j++){
          
          if (map.containsKey(s.charAt(j)))
             break;

          len = Math.max(len, j-i+1);
          map.put(s.charAt(j), 1);
        }
     }

return len;
    }
}