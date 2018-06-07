package SimpleCode;

import java.util.Stack;

/**
 * 题目：
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 */
public class MinStack {
    public Stack<Integer> elementStack = null;
    public Stack<Integer> minStack = null;
    public MinStack() {
       elementStack = new Stack<>();
       minStack = new Stack<>();
    }

    public void push(int x) {
        elementStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
       if (elementStack.isEmpty())
           throw new RuntimeException("stack is empty");
       int value = elementStack.peek();
       if (value == minStack.peek())
           minStack.pop();
       elementStack.pop();
    }

    public int top() {
      if (elementStack.isEmpty())
          throw new RuntimeException("stack is empty");
      return elementStack.peek();
    }

    public int getMin() {
      if (minStack.isEmpty())
          throw new RuntimeException("stack is empty");
      return minStack.peek();
    }
}
