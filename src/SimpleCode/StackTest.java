package SimpleCode;

import java.util.*;

/**
 * 关于栈的练习
 */
public class StackTest {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f","y#f#o##f"));
    }
    /**
     * 题目：
     * 给定一个二叉树，返回它的中序 遍历。
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list =  new ArrayList<>();
      if (root == null)
          return list;
      if (root.left != null)
      {
          List<Integer> left = inorderTraversal(root.left);
          list.addAll(left);
      }
      list.add(root.val);
      if (root.right != null)
      {
          List<Integer> right = inorderTraversal(root.right);
          list.addAll(right);
      }
      return list;
    }
    /**
     * 题目：
     * 比较含退格的字符串
     */
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stackOne = new Stack<>();
        Stack<Character> stackTwo = new Stack<>();
        for (Character character:S.toCharArray()) {
            if ('#' == character )
            {
                if (!stackOne.isEmpty())
                    stackOne.pop();
            }
            else
                stackOne.push(character);

        }
        for (Character character:T.toCharArray()) {
            if ('#' == character )
            {
                if (!stackTwo.isEmpty())
                    stackTwo.pop();
            }
            else
                stackTwo.push(character);
        }
        while (!stackOne.isEmpty() && !stackTwo.isEmpty() && stackOne.peek() == stackTwo.peek())
        {
            stackOne.pop();
            stackTwo.pop();
        }
        if (stackOne.isEmpty() && stackTwo.isEmpty())
            return true;
        return false;
    }
    /**
     * 题目：
     * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。

     nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int index = 0; index < nums2.length;index++)
        {
            map.put(nums2[index],index);
        }
        for (int index = 0 ; index < nums1.length;index++)
        {
            int position = -1;
            for (int start = map.get(nums1[index]) + 1;start < nums2.length;start++)
            {
                if (nums2[start] > nums1[index])
                {
                    position = nums2[start];
                    break;
                }
            }
            nums1[index] = position;
        }
        return nums1;
    }
    /**
     * 题目：
     * 你现在是棒球比赛记录员。
     给定一个字符串列表，每个字符串可以是以下四种类型之一：
     1.整数（一轮的得分）：直接表示您在本轮中获得的积分数。
     2. "+"（一轮的得分）：表示本轮获得的得分是前两轮有效 回合得分的总和。
     3. "D"（一轮的得分）：表示本轮获得的得分是前一轮有效 回合得分的两倍。
     4. "C"（一个操作，这不是一个回合的分数）：表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
     */
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String string:ops)
        {

            switch (string)
            {
                case "+":
                    int top = stack.pop();
                    int num = top + stack.peek();
                    stack.push(top);
                    stack.push(num);
                    break;
                case "D":
                    if (!stack.isEmpty())
                        stack.push(stack.peek() * 2 );
                    break;
                case "C":
                    if (!stack.isEmpty())
                        stack.pop();
                    break;
                default:
                    stack.push(Integer.valueOf(string));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
