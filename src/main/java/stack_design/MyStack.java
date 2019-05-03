package main.java.stack_design;

import java.util.LinkedList;
import java.util.Queue;

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
 */
class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    boolean isOne;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        isOne = true;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (isOne) q1.add(x);
        else q2.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int res;

        if (isOne) {
            while (q1.size()>1)
                q2.offer(q1.poll());
            res = q1.poll();
        }
        else {
            while (q2.size()>1)
                q1.offer(q2.poll());
            res = q2.poll();
        }

        isOne = !isOne;

        return res;
    }

    /** Get the top element. */
    public int top() {
        int cur = pop();
        if (isOne) q1.offer(cur);
        else q2.offer(cur);
        return cur;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return (isOne && q1.isEmpty()) || (!isOne && q2.isEmpty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
