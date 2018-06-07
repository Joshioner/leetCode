package SimpleCode;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class MyQueue {
    Stack<Integer> firstStack ;
    Stack<Integer> secondStack;

    public MyQueue() {
       firstStack = new Stack<>();
       secondStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
       firstStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (secondStack.isEmpty() && firstStack.isEmpty())
            throw new RuntimeException("queue is empty");
      if (secondStack.isEmpty())
      {
          while (!firstStack.isEmpty())
          {
              secondStack.push(firstStack.pop());
          }
      }
      return secondStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (secondStack.isEmpty() && firstStack.isEmpty())
            throw new RuntimeException("queue is empty");
       if (secondStack.isEmpty())
       {
           while (!firstStack.isEmpty())
           {
               secondStack.push(firstStack.pop());
           }
       }
       return secondStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return firstStack.isEmpty() && secondStack.isEmpty();
    }
}
