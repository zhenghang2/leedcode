package problem1;

import java.util.Stack;

// use stack to achieve a queue
public class MyQueue {

  private Stack<Integer> stack;
  private Stack<Integer> helpStack;
  private int front;

  /** Initialize your data structure here. */
  public MyQueue() {
    stack = new Stack<Integer>();
    helpStack = new Stack<Integer>();
    front = -1;
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    if (stack.empty()) {
      front = x;
    }
    while (!stack.isEmpty()) {
      helpStack.push(stack.pop());
    }
    helpStack.push(x);
    while (!helpStack.isEmpty()) {
      stack.push(helpStack.pop());
    }
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    int pop = stack.pop();
    if (!stack.isEmpty()) {
      front = stack.peek();
    }
    return pop;
  }

  /** Get the front element. */
  public int peek() {
    return front;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack.isEmpty();
  }
}
