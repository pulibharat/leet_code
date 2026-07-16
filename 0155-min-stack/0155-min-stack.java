// class MinStack {

//     private Stack<int[]> st;

//     public MinStack() {
//         stack = new Stack<>();
//     }

//     public void push(int value) {
      
//       if(st.isEmpty()){
//         st.push(int [] {value,value});
//       }
//         int mini = Math.min(getMin(), value);
//       else{
//         st.push(int []{ value, mini);
//       }

//     }

//     public void pop() {
      
//       st.pop();

//     }

//     public int top() {
//       return st.pop()
//     }

//     public int getMin() {
//         return st.peek()[1];
//     }
// }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */



 class MinStack {

    private Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int value) {

        if (st.isEmpty()) {
            st.push(new int[]{value, value});
        } else {
            int mini = Math.min(getMin(), value);
            st.push(new int[]{value, mini});
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek()[0];
    }

    public int getMin() {
        return st.peek()[1];
    }
}