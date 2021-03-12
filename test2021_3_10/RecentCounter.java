package test2021_3_10;

import java.util.Stack;

class RecentCounter {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        int ret = t-3000;
        int count=1;
        if(stack1.empty()){
            stack1.push(t);
            return count;
        }
        while(!stack1.empty() && stack1.peek()>=ret){
            count++;
            int n = stack1.pop();
            stack2.push(n);
        }
        while(!stack2.empty()){
            int n = stack2.pop();
            stack1.push(n);
        }
        stack1.push(t);
        return count;
    }

}
