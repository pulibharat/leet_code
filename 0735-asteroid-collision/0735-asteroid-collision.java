class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
        // array;ist acting as a stack
        ArrayList<Integer> st = new ArrayList<>();

        for (int i = 0; i < n; i++) {
         
         if(asteroids[i] > 0){
            st.add(asteroids[i]);
         }

         // if not > 0
         else{
            // stack has less el

           while (!st.isEmpty() &&
       st.get(st.size()-1) > 0 &&
       st.get(st.size()-1) < Math.abs(asteroids[i])) {
    st.remove(st.size()-1);
}
           // both were equal
           if (!st.isEmpty() && st.get(st.size()-1) == Math.abs(asteroids[i])) {
            st.remove(st.size()-1);
           }
           // when st aleardy has a neg and coming is also neg so no collision
           else if(st.isEmpty() || st.get(st.size()-1) < 0){
            st.add(asteroids[i]);
           }
           
         }

        }

        // Convert the list to an array
        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }
return result;
    }
}