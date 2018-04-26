package SimpleCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class first {
    public static void main(String[] args)
    {
         int[] nums = {1,2,6,3,4,5,6};
         ListNode headNode = createListNode(nums,0);
         removeElements(headNode,6);
        }

    /**
     * 题目：删除链表中的节点
     *
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾的）节点，您将只被给予要求被删除的节点。

     比如：假设该链表为 1 -> 2 -> 3 -> 4  ，给定您的为该链表中值为 3 的第三个节点，那么在调用了您的函数之后，该链表则应变成 1 -> 2 -> 4 。
      */
    //node为给定的值
    public void deleteNode(ListNode node) {
         node.val = node.next.val;
         node.next = node.next.next;
    }


    /**
     * 题目：删除链表中的元素
     *
     * 删除链表中等于给定值 val 的所有元素。

     示例
     给定: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     返回: 1 --> 2 --> 3 --> 4 --> 5
     */

    public static ListNode removeElements(ListNode head, int val) {
         if(head == null)
             return null;
         while (head.val == val)
         {
             head = head.next;
             if (head == null)
                 return null;
         }

         ListNode tmpNode = head;
         while (tmpNode.next != null)
         {
             if (tmpNode.next.val == val)
                 tmpNode.next = tmpNode.next.next;
             else
                 tmpNode = tmpNode.next;
         }
         return head;
    }


    /**
     * 题目：给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

     示例 1:

     给定 nums = [3,2,2,3], val = 3,

     函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

     你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {
       if (nums.length == 0)
           return 0;
       if (nums.length == 1)
           return nums[0] == val ? 0 : 1;
       int count = 0 ;
       for (int  i = 0 ; i < nums.length ; i++)
       {
          if (nums[i] != val)
          {
              nums[count] = nums[i];
              count++;
          }
       }
       return count;
    }





    /**
     * 题目：删除排序数组中的重复项
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

     示例 1:

     给定数组 nums = [1,1,2],

     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

     你不需要考虑数组中超出新长度后面的元素。

     */
    public int removeDuplicates(int[] nums) {
       if (nums.length == 1)
           return 1;
       int count = 0;
       for (int i = 0 ; i < nums.length;i++)
       {
           int j = i + 1;
           count ++;
           while ( j < nums.length && nums[i] == nums[j])
           {
               j++;
           }
           if (j < nums.length)
               nums[count] = nums[j];
           i = j - 1;
       }
       return count;
    }


    /**
     * 题目：合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

     示例:

     输入:
     [
     1->4->5,
     1->3->4,
     2->6
     ]
     输出: 1->1->2->3->4->4->5->6
     */
    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0)
          return null;
      if (lists.length == 1)
          return lists[0];
     while (lists.length > 1)
     {
         List<ListNode> listNodeList = new ArrayList<ListNode>();
         for (int i = 0; i + 1 < lists.length;i = i + 2)
         {
             ListNode mergeNode = mergeTwoLists(lists[i],lists[i + 1]);
             listNodeList.add(mergeNode);
         }
         if (lists.length % 2 != 0)
             listNodeList.add(lists[lists.length - 1]);

         lists = listNodeList.toArray(new ListNode[0]);
     }
     return lists[0];
    }


    /**
     * 利用递归创建单链表
     * @param nums
     * @param index
     * @return
     */
    public static ListNode createListNode(int[] nums, int index)
    {
        if (index >= nums.length)
            return null;
        ListNode newListNode = new ListNode(nums[index]);
        newListNode.next = createListNode(nums,index + 1);
        return newListNode;
    }

    /**
     * 题目：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

     示例：

     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
     */

    //利用递归解决
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //第一个链表为空
        if (l1 == null) return l2;
        //第二个链表为空
        if (l2 == null) return l1;
        ListNode newNode = null;

        if (l1.val <= l2.val)
        {
            newNode = new ListNode(l1.val);
            newNode.next = mergeTwoLists(l1.next,l2);
        }
        else
        {
            newNode = new ListNode(l2.val);
            newNode.next = mergeTwoLists(l1,l2.next);
        }

        return newNode;
    }

    /**
     * 题目：有效的括号
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     有效字符串需满足：
     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。

     示例 1:

     输入: "()"
     输出: true
     */
    public static boolean isValid(String s) {
        //栈，用于存放"(","{","["
        Stack<Character> stackLeft = new Stack<Character>();
        //栈用于存放 ")","}","]"
        Stack<Character> stackRight = new Stack<Character>();
        for (char symbol:s.toCharArray())
        {
            if (symbol == '(' || symbol == '{' || symbol == '[')
                stackLeft.push(symbol);
            else
                stackRight.add(symbol);
        }
      while (!stackRight.isEmpty()&& !stackLeft.isEmpty())
      {
          char symbol = stackLeft.pop();
          switch (symbol)
          {
              case '(':
                  if (stackRight.pop() != ')')
                      return false;
                  break;
              case '{':
                  if (stackRight.pop() != '}')
                      return false;
                  break;
              case '[':
                  if (stackRight.pop() != ']')
                      return false;
                  break;
              default:
                  break;
          }
      }
      return true;
    }

    /**
     * 题目：最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。

     示例 1:

     输入: ["flower","flow","flight"]
     输出: "fl"
     */
    public  String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String pre = strs[0];
        int  i = 0;
        while (i < strs.length)
        {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length() - 1);
            i++;
        }
        return pre;
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
