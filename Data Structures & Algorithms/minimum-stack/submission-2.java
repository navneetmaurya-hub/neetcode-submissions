class MinStack {
     Stack<Integer>st=new Stack<>();
     Stack<Integer>minStack=new Stack<>();
    public MinStack() { 
    }
    
    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty() || minStack.peek()>val){
            minStack.push(val);
        }
        else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
       st.pop(); 
       minStack.pop();
    }
    
    public int top() {
        return st.peek(); 
    }
    
    public int getMin() {
       return minStack.peek(); 
    }
}
