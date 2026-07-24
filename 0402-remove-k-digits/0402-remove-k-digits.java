



class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();
        int n = num.length();

        // Build a monotonic increasing stack
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
        }

        // Remove remaining digits from the end if k > 0
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Convert stack to string
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        // Reverse because stack gives characters in reverse order
        ans.reverse();

        // Remove leading zeros
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }

        // If all digits were removed
        if (ans.length() == 0) {
            return "0";
        }

        return ans.toString();
    }
}