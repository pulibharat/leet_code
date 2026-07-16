class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

         if (s.length() % 2 != 0){
            return false;
        }

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }
        
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Closing brackets
            else {

                if (stack.isEmpty())
                    return false;

                char opening = stack.peek();

                if (ch == ')' && opening == '(')
                    stack.pop();
                else if (ch == '}' && opening == '{')
                    stack.pop();
                else if (ch == ']' && opening == '[')
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty();
    }
}