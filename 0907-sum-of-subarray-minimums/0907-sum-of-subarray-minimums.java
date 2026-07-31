class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int mod = 1_000_000_007;

        int[] prev = new int[n];
        int[] next = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {

            long left = i - prev[i];
            long right = next[i] - i;

            ans = (ans + (left * right * arr[i]) % mod) % mod;
        }

        return (int) ans;
    }
}