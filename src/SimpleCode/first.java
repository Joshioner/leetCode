package SimpleCode;

import java.util.*;



public class first {
    public static void main(String[] args) {
        System.out.println("aaaaa".indexOf("bba"));
    }
    /**
     * 题目：给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    /**
     * 题目：合并两个有序数组(从后往前推)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
      int index = m + n - 1;
      int endNums1 = m - 1,endNums2 = n -  1;
      while (endNums1 >= 0 && endNums2 >= 0)
      {
          nums1[index--] = nums1[endNums1] > nums2[endNums2] ?nums1[endNums1--]:nums2[endNums2--];
      }
      while (endNums2 >= 0)
      {
          nums1[index--] = nums2[endNums2--];
      }
    }
    /**
     * 题目：给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     */
    public static boolean validPalindrome(String s) {
      if (s.trim().length() == 0)
          return false;
      boolean flag = true;
      int i = 0,j = s.length() -1;
      while (i <= j)
      {
          if (s.charAt(i) == s.charAt(j))
          {
              i++;
              j--;
          }
          else
          {
              if (flag)  //说明还可以删除一个字符
              {
                  int start = i+1,end = j-1;
                  if (s.charAt(start) == s.charAt(j) && s.charAt(start+1) == s.charAt(end))
                  {
                      i++;
                      flag = false;
                  }
                  else if (s.charAt(i) == s.charAt(end)&& s.charAt(start) == s.charAt(end-1))
                  {
                      j--;
                      flag = false;
                  }
                  else
                      return false;
              }
              else
                  return false;
          }
      }
      return true;
    }
    /**
     * 题目：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     */
    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.trim().length() == 0)
               return true;
        for (int i = 0 , j = s.length() - 1 ;i < j ;i++,j--)
        {
            while (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i)))
            {
                i++;
                if (i > s.length() - 1)
                    return true;
            }
            while (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j)))
            {
                j--;
                if (j < 0)
                    return true;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }
//    public static boolean isPalindrome(String s) {
//      if (s.length() == 0 || s.trim().length() == 0)
//          return true;
//      StringBuilder sb = new StringBuilder();
//      for (int i = 0 ; i < s.length();i++)
//      {
//          if (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))
//              sb.append(s.charAt(i));
//      }
//      return sb.toString().equalsIgnoreCase(sb.reverse().toString());
//    }
     /**
     * 题目：请判断一个链表是否为回文链表。
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode middleNode = findMinddle(head); //找到链表中点节点
        middleNode.next = ReverseList(middleNode.next);//链表节点反转
        ListNode p = head,q = middleNode.next;
        while ( p != null && q != null && p.val == q.val)
        {
            p = p.next;
            q = q.next;
        }
        return q == null;
    }
    //找到链表中点
    public static ListNode findMinddle(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode p = head,q = head;
        while (p != null && q.next != null && q.next.next != null)
        {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }
    //原地反转链表
    public static ListNode ReverseList(ListNode head){
        ListNode tmpNode = null;
        while (head != null)
        {
            ListNode nextNode = head.next;
            head.next = tmpNode;
            tmpNode = head;
            head = nextNode;
        }
        return tmpNode;
    }
        /**
         * 题目：删除排序链表中的重复元素 II
         * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
         */
    public ListNode deleteDuplicates(ListNode head) {
       if (head == null || head.next == null)
           return head;
       ListNode tmpNode = head.next;
       boolean flag = false;  //用于标志是否需要删除头部
       while (tmpNode != null && tmpNode.val == head.val)
       {
              tmpNode =  tmpNode.next;
              flag = true;
       }
       if (flag)
           return deleteDuplicates(tmpNode);
       head.next = deleteDuplicates(head.next);
       return head;
    }
    /**
     * 题目：删除排序链表中的重复元素
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     */
//    public ListNode deleteDuplicates(ListNode head) {
//         if (head == null || head.next == null)
//             return head;
//         ListNode targetNode = head;
//         ListNode tmpNode = targetNode.next;
//         while (tmpNode != null)
//         {
//             if (tmpNode.val == targetNode.val)
//             {
//                 targetNode.next = tmpNode.next;
//                 tmpNode = tmpNode.next;
//             }
//             else
//             {
//                 targetNode = tmpNode;
//                 tmpNode = targetNode.next;
//             }
//         }
//         return head;
//    }
    /**
     * 题目：爬楼梯
     * 假设你正在爬楼梯。需要 n 步你才能到达楼顶。

     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

     注意：给定 n 是一个正整数。
     */
    public int climbStairs(int n) {
        if(n == 1 || n == 2)
            return n;
        int f1 = 1,f2 = 2;
        int result = 0;
        for (int i = 3 ; i <= n;i++)
        {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }
    /**
     * 题目：两数相加
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

     你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0 , sum = 0;
        ListNode headNode = l1;
       while (l1 != null && l2 != null)
       {
          sum = l1.val + l2.val + carry;
          l1.val = sum % 10;
          carry = sum / 10;
          l1 = l1.next;
          l2 = l2.next;
       }
        ListNode tmpNode = new ListNode(1);
        tmpNode.next = null;
       if (l1 != null)
       {
           while (l1 != null)
           {
               if (l1.val + carry != 10)
               {
                   l1.val = l1.val + carry;
                   return headNode;
               }
               else
               {
                   l1.val = (l1.val + carry) % 10;
                   carry = (l1.val + carry) / 10;
               }
           }
           if (l1 == null)
               l1 = tmpNode;
       }

       if (l2 != null)
       {
           l1 = l2;
           while (l2 != null)
           {
               if (l2.val + carry != 10)
               {
                   l2.val = l2.val + carry;
                   return headNode;
               }
               else
               {
                   l2.val = (l2.val + carry) % 10;
                   carry = (l2.val + carry) / 10;
               }
           }
           if (l2 == null)
               l1 = tmpNode;
       }

       return headNode;
    }
    /**
     * 题目：二进制求和
     *
     * 给定两个二进制字符串，返回他们的和（用二进制表示）。

     输入为非空字符串且只包含数字 1 和 0。

     示例 1:

     输入: a = "11", b = "1"
     输出: "100"
     */
    /**
     * 题目：加一
     * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

     最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public String addBinary(String a, String b) {
       //创建临时数组，用于存储二进制和
        int[] result = new int[a.length() >= b.length() ? a.length() : b.length()];
        int index =  result.length - 1;
        int endA = a.length() - 1;
        int endB = b.length() - 1;
        int carry = 0;
        int sum = 0;
        while (endA >= 0 && endB >= 0)
        {
           sum = (Integer.valueOf(a.charAt(endA)) - 48) + (Integer.valueOf(b.charAt(endB)) - 48) + carry;
           result[index] = sum % 2;
           carry = sum / 2;
           endA--;
           endB--;
           index--;
        }
        while (endA >= 0)
        {
            if ((Integer.valueOf(a.charAt(endA))- 48) + carry == 2 )
            {
                result[index] = 0;
                carry = 1;
                endA--;
                index--;
            }
            else
            {
                result[index] = (Integer.valueOf(a.charAt(endA)) - 48) + carry;
                index--;
                endA--;
                carry = 0;
            }
        }
        while (endB >= 0)
        {
            if ((Integer.valueOf(b.charAt(endB))- 48) + carry == 2 )
            {
                result[index] = 0;
                carry = 1;
                endB--;
                index--;
            }
            else
            {
                result[index] = (Integer.valueOf(b.charAt(endB)) - 48) + carry;
                index--;
                endB--;
                carry = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (carry == 1)
        {
            int[] newindex = new int[result.length + 1];
            newindex[0] = 1;
            for (int i = 1 ; i < newindex.length;i++)
                newindex[i] = result[i - 1];
            for (int num : newindex)
                sb.append(num);
            return sb.toString();
        }
        for (int num : result)
            sb.append(num);
      return  sb.toString();
    }
    public static int[] plusOne(int[] digits) {
        int i ;
        for (i = digits.length - 1 ; i >= 0 ; i --)
        {
            if (digits[i] != 9)
            {
                digits[i]++;
                break;
            }
            else
                digits[i] = 0;
        }
        if ( i < 0 && digits[0] == 0)
        {
            int[] newIndex = new int[digits.length + 1];
            newIndex[0] = 1;
            return newIndex;
        }
        return digits;
    }



    /**
     * 题目：最后一个单词的长度
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

     如果不存在最后一个单词，请返回 0 。

     说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s == " ")
            return 0;
        String[] stringList = s.trim().split(" ");

        return stringList[stringList.length - 1].length();
    }

    /**
     * 题目：最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */
    public int maxSubArray(int[] nums) {
      if(nums.length == 0)
          return 0;
      int sum = 0;
      int result = Integer.MIN_VALUE;
      for (int value:nums)
      {
          if (sum < 0)
              sum = value;
          else
              sum +=  value;
          result = Math.max(result,sum);
      }
      return result;

    }


    /**
     * 题目：第一个错误的版本
     *
     * 你是产品经理，目前正在领导一个团队开发一个新产品。不幸的是，您的产品的最新版本没有通过质量检查。由于每个版本都是基于之前的版本开发的，所以错误版本之后的所有版本都是不好的。

     假设你有 n 个版本 [1, 2, ..., n]，你想找出第一个错误的版本，导致下面所有的错误。

     你可以通过 bool isBadVersion(version) 的接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。您应该尽量减少对 API 的调用次数。
     */
    boolean isBadVersion(int version){return false;}
    public int firstBadVersion(int n) {
        int low = 1,high = n ,mid;
        while (low <= high)
        {
            mid = low + (high - low)/2;
            if (isBadVersion(mid))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    /**
     * 题目：两数之和 II - 输入有序数组
     *
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

     函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

     说明:

     返回的下标值（index1 和 index2）不是从零开始的。
     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     示例:

     输入: numbers = [2, 7, 11, 15], target = 9
     输出: [1,2]
     解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2)
            return null;
       int[] index = new int[2];
       for (int start = 0 ,end = numbers.length - 1;start < end ;)
       {
           if (numbers[start] + numbers[end] == target)
           {
               index[0] = start + 1;
               index[1] = end + 1;
               break;
           }
           else if (numbers[start] + numbers[end] > target)
           {
               end--;
           }
           else
               start++;
       }
       return index;
    }
    /**
     * 题目：x 的平方根
     * 实现 int sqrt(int x) 函数。

     计算并返回 x 的平方根，其中 x 是非负整数。

     由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     */
    public static int mySqrt(int x) {
        int low = 0, high = 46341, mid = 0;

        while(low <= high) {
            if (mid == low + (high-low)/2) {
                break;
            }
            mid = low + (high-low)/2;
            int square = mid * mid;

            if(square == x) {
                return mid;
            }
            else if(x > square){
                low =  mid;
            }
            else {
                high = mid;
            }
        }
        return mid;
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
         if (s == null  || s.length() % 2 != 0)
             return false;
         Stack<Character > stack = new Stack<>();
         for (char symbol : s.toCharArray())
         {
             if (symbol == '(' || symbol == '{' || symbol == '[')
                 stack.push(symbol);
             else if (symbol == '}')
             {
                 if (!stack.empty() && stack.peek() == '{')
                     stack.pop();
                 else
                     return false;
             }
             else if (symbol == ')')
             {
                 if (!stack.empty() && stack.peek() == '(')
                     stack.pop();
                 else
                     return false;
             }
             else if (symbol == ']')
             {
                 if (!stack.empty() && stack.peek() == '[')
                     stack.pop();
                 else
                     return false;
             }
         }
         if (!stack.isEmpty())
             return false;
        return true;

    }


    /**
     * 题目：搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

     你可以假设数组中无重复元素。
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid ;
        while (left <= right)
        {
             mid = (left + right) / 2;
             if (nums[mid] == target)
                 return mid;
             else if (nums[mid] > target)
                 right = mid -1;
             else
                 left = mid + 1;
        }
        for (int i = 0; i < nums.length;i++)
        {
            if (nums[i] > target)
                return i;
        }

        return nums.length ;
    }

    /**
     * 题目：实现strStr()
     * 实现 strStr() 函数。

     给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     */
//    public static int strStr(String haystack, String needle) {
//        if (needle.trim() == "" || haystack.trim() == "")
//            return 0;
//        char target = needle.charAt(0);
//        for (int i = 0 ; i < haystack.toCharArray().length;i++)
//        {
//            if (haystack.charAt(i) == target)
//                return i;
//        }
//        return -1;
//    }



    /**
     * 反转链表
     */
    public ListNode reverseList(ListNode head) {
       if (head == null || head.next == null)
           return head;
       ListNode tmpNode = null;
       while (head != null)
       {
           ListNode nextNode = head.next;
           head.next = tmpNode;
           tmpNode = head;
           head = nextNode;
       }
       return tmpNode;
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
