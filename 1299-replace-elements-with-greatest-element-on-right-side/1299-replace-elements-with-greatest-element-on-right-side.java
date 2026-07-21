class Solution {
    public int[] replaceElements(int[] arr) {

        int n = arr.length;
        int ans[] = new int[n];
        int greater = arr[n-1];
        Arrays.fill(ans,-1);

        for (int i = n - 2; i >= 0; i--) {
         
          ans[i] = greater;
          if(greater<arr[i] && i>=0){
             greater = arr[i];
          }
           
        }

    return ans;
    }
}
