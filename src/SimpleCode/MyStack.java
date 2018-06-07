package SimpleCode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyStack {
    Queue<Integer> queue1 = null;
    Queue<Integer> queue2 = null;
    /** Initialize your data structure here. */
    public MyStack() {
       queue1 = new LinkedBlockingDeque<>();
       queue2 = new LinkedBlockingDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (queue1.isEmpty())
            queue2.add(x);
        if (queue2.isEmpty())
            queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
      if (queue1.isEmpty() && queue2.isEmpty())
          throw new RuntimeException("Stack is empty");
      if (queue1.isEmpty())
      {
          while (queue2.size() > 1)
          {
              queue1.add(queue2.poll());
          }
          return queue2.poll();
      }
      if (queue2.isEmpty())
      {
          while (queue1.size() > 1)
          {
              queue2.add(queue1.poll());
          }
          return queue1.poll();
      }
      return 0;
    }

    /** Get the top element. */
    public int top() {
        if (queue1.isEmpty() && queue2.isEmpty())
            throw new RuntimeException("Stack is empty");
        if (queue1.isEmpty())
        {
            while (queue2.size() > 1)
            {
                queue1.add(queue2.poll());
            }
            int num = queue2.poll();
            queue1.add(num);
            return num;
        }
        if (queue2.isEmpty())
        {
            while (queue1.size() > 1)
            {
                queue2.add(queue1.poll());
            }
            int num = queue1.poll();
            queue2.add(num);
            return num;
        }
        return 0;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
         return queue1.isEmpty() && queue2.isEmpty();
    }
}
