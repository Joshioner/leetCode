package SimpleCode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;


public class first {
    public static void main(String[] args) {
        int[] m1 = new int[]{0,1,5,3,12};
        moveZeroes(m1);
        System.out.println(Arrays.toString(m1));

    }
    /**
     * 题目：移动零
     */
    public static void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0 ; i < nums.length;i++){
            if (nums[i] != 0 ){
              nums[count] = nums[i];
              if (count != i){
                  nums[i] = 0;
              }
              count++;
            }
        }
    }
//    public static void moveZeroes(int[] nums) {
//      for (int i = 0 ; i < nums.length;i++){
//          if (nums[i] == 0){
//              for (int j = i + 1 ; j < nums.length;j++){
//                  if (nums[j] != 0){
//                      int temp = nums[i];
//                      nums[i] = nums[j];
//                      nums[j] = temp;
//                      break;
//                  }
//              }
//          }
//      }
//    }
    /**
     * 题目：缺失数字
     */
    public int missingNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0] == 0 ? 1 : 0;
       Arrays.sort(nums);
       for (int index = 0; index < nums.length;index++){
           if (nums[index] != index)
               return index;
       }
       return nums.length;
    }
    /**
     * 题目：编写一个程序判断给定的数是否为丑数。

     丑数就是只包含质因数 2, 3, 5 的正整数。
     */
    public static boolean isUgly(int num) {
        if(num==0) return false;
        if(num==1) return true;
        if(num%2==0){
            num=num/2;
            return isUgly(num);
        }
        if(num%3==0){
            num=num/3;
            return isUgly(num);
        }
        if(num%5==0){
            num=num/5;
            return isUgly(num);
        }
        return false;
    }
    /**
     * 题目：各位相加(通过枚举发现有规律,即若数为9的倍数,则结果为9,若不是则各位相加的结果为对九取余.)
     */
    public int addDigits(int num) {
        if (num  == 0)
            return num;
       int result = num % 9;
       if (result == 0) return 9;
       return result;
    }
//    public int addDigits(int num) {
//        if (num < 10)
//            return num;
//        int sum = 0;
//        while ( num != 0){
//            sum += num % 10;
//            num = num / 10;
//        }
//        return addDigits(sum);
//    }
    /**
     * 题目： 同构字符串
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for (int i = 0 ; i < s.length();i++){
            if (m1[s.charAt(i)] != m2[t.charAt(i)]){
                return false;
            }
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1 ;
        }
        return true;
    }
    /**
     * 题目：
     *  二叉树的所有路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();

        // check corner case
        /* your code */
        if(root == null){
            return result;
        }
        // recursion
        String path = Integer.toString(root.val);
        helper(root, path , result);
        return result;
    }
    private void helper(TreeNode root, String path, List<String> result) {
        /* your code */
        //判断空
        if(root == null){
            return;
        }
        //到叶子节点加入result
        if(root.left == null && root.right == null){
            result.add(path);
            return;
        }
        //递归
        if(root.left != null)
        {
            helper(root.left ,path + "->" + root.left.val,result);
        }
        if(root.right != null)
        {
            helper(root.right ,path + "->" + root.right.val,result);
        }

    }
    /**
     * 题目：
     * 有效的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        int[] array = new int[26];
        for (int i = 0 ; i < s.length();i++)
        {
            array[s.charAt(i) - 'a']++;
        }
        for (int i = 0 ; i < t.length();i++)
        {
            array[t.charAt(i) - 'a']--;
        }
        for (int num:array)
        {
            if (num != 0)
                return false;
        }
        return true;
    }
    /**
     * 题目：二叉搜索树的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        if (p.val < root.val && q.val < root.val)
           return lowestCommonAncestor(root.left,p,q);
        else if (p.val> root.val && q.val > root.val)
            return lowestCommonAncestor(root.right,p,q);
        return root;
    }

    /**
     * 题目：统计所有小于非负数整数 n 的质数的数量。
     */
    public static int countPrimes(int n) {
        boolean[] flag = new boolean[n + 1];
        for (int  i = 0 ; i <= n ; i ++)
        {
            flag[i] = true;
        }
        int count = 0;
        for (int i = 2; i < n ;i++)
        {
            if (flag[i])
            {
                for (int j = i + i;j <n ;j += i)
                    flag[j] = false;
                count++;
            }

        }
        return count;
    }
    /**
     * 题目：翻转一棵二叉树。
     */
    public TreeNode invertTree(TreeNode root) {
         if (root == null)
             return root;
         if (root.left == null && root.right == null)
             return root;
         TreeNode leftRoot = root.left,rightRoot = root.right;
         root.left = invertTree(rightRoot);
         root.right = invertTree(leftRoot);
         return root;
    }
    /**
     * 题目：
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
     * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       HashMap<Integer,Integer> hashMap = new HashMap<>();
       for (int i = 0 ;i < nums.length;i++)
       {
           if (hashMap.containsKey(nums[i]))
           {
               int sub = i - hashMap.get(nums[i]);
               if (sub <= k)
                   return true;
               hashMap.put(nums[i],i);
           }
           else
               hashMap.put(nums[i],i);
       }
       return false;
    }
    /**
     * 题目：给定一个整数数组，判断是否存在重复元素。

     如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0)
            return false;
       Set<Integer> set = new HashSet<>();
       for (int num:nums)
       {
           if (set.contains(num))
            return true;
           else
               set.add(num);
       }
       return false;
    }
    /**
     * 题目：
     *
     编写一个算法来判断一个数是不是“快乐数”。

     一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，
     那么这个数就是快乐数。

      分析：任意一个数，最后会变成两个数字循环（89和1），如果为1，则为快乐数，否则则不是快乐数
     */
    public boolean isHappy(int n) {
      if(n < 1) return false;
      if (n == 1) return true;
      int s = n;
      while (s != 89 && s != 1)
      {
          s = sum(s);
          if (s == 89)
              return false;
          if (s == 1)
              return true;
      }
      return false;
    }
    public int sum(int n)
    {
        int num = 0;
        while (n != 0)
        {
            num = num + (n % 10) * (n % 10);
            n = n / 10;
        }
        return num;
    }

    /**
     * 题目：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     */
    public static int hammingWeight(int n) {
       int count = 0;
       while (n != 0)
       {
           count++;
           n = (n - 1) & n ;
       }
       return count;
    }
    /**
     * 题目：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     */
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
         k = k % length;
         int temp = 0;
        for (int i = 0 ; i < k;i++)
        {
            temp = nums[length - 1];
            for (int j = length - 2; j >= 0 ; j--)
            {
                nums[j + 1] = nums[j];
            }
            nums[0] = temp;
        }
    }
    /**
     * 题目：给定一个整数 n，返回 n! 结果尾数中零的数量
     */
    public static int trailingZeroes(int n) {
        int num = 0;
        while(n > 0) {
            num += (n/5);
            n /= 5;
        }
        return num;
    }
    /**
     * 题目：给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

     你可以假设数组是非空的，并且给定的数组总是存在众数。
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }
    /**
     * 题目：给定一个Excel表格中的列名称，返回其相应的列序号。
     *  A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     */
    public static int titleToNumber(String s) {
       int sum = 0;
       int length = s.length() - 1;
       int count = 0;
       while (length >= 0)
       {
           sum += (s.charAt(length) - 'A' + 1 ) * Math.pow(26,count);
           count++;
           length--;
       }
       return sum;
    }
    /**
     * 题目：给定一个正整数，返回它在 Excel 表中相对应的列名称。
     例如，
     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
     */
    public String convertToTitle(int n) {
       if (n < 1)
           return null;
       StringBuilder sb = new StringBuilder();
       while (n != 0)
       {
           char result = (char) (((n - 1) % 26 ) + 'A');
           sb.append(result);
           n = (n - 1) / 26;
       }
       return sb.reverse().toString();
    }
    /**
     * 题目：编写一个程序，找到两个单链表相交的起始节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if (headA == null || headB == null)
           return null;
       ListNode lA = headA;
       int lengthA = 0;
       while (lA != null)
       {
           lengthA++;
           lA = lA.next;
       }
       ListNode lB = headB;
       int lengthB = 0;
       while (lB != null)
       {
           lengthB++;
           lB = lB.next;
       }
       int diff = 0;
       if (lengthA > lengthB)
       {
           lA = headA;
           lB = headB;
           diff = lengthA - lengthB;
       }
       else
       {
           lA = headB;
           lB = headA;
           diff = lengthB - lengthA;
       }
       for (int i = 0 ; i < diff;i++)
       {
           lA = lA.next;
       }
       while (lA != null && lB != null)
       {
           if (lA == lB)
               return lA;
           lA = lA.next;
           lB = lB.next;
       }
       return null;

    }
    /**
     * 题目：给定一个链表，判断链表中是否有环。
     */
    public static boolean hasCycle(ListNode head) {
       if (head == null || head.next == null)
           return false;
       ListNode low = head,fast = head;
       while (low.next != null && fast.next!= null)
       {
          low = low.next;
          fast = fast.next.next;
          if (fast == null)
              return false;
          if (low == fast)
              return true;
       }
       return false;

    }
    /**
     * 题目：
     给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    public static int singleNumber(int[] nums) {
        int num = 0;
        for(int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
    /**
     * 题目：
     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

     如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

     注意你不能在买入股票前卖出股票。
     */
    public static int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int index = 0; index < prices.length;index++)
        {
            if (prices[index] < min)
            {
                min = prices[index];
                continue;
            }
            if (prices[index] - min > max)
            {
                max = prices[index] - min;
            }
        }
       return max;

    }
    /**
     * 题目：给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (rowIndex < 0  )
            return new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        resultList.add(firstList);
        for (int i = 1;i <= rowIndex;i++)
        {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);
            List<Integer> preList = resultList.get(i - 1);
            for (int j = 0 ; j + 1 < preList.size();j ++)
            {
                tempList.add(preList.get(j) + preList.get(j + 1));
            }
            tempList.add(1);
            resultList.add(tempList);
        }
        return resultList.get(rowIndex);
    }
    /**
     * 题目：给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (numRows == 0 )
            return resultList;
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        resultList.add(firstList);
      for (int i = 1;i < numRows;i++)
      {
          List<Integer> tempList = new ArrayList<>();
          tempList.add(1);
          List<Integer> preList = resultList.get(i - 1);
          for (int j = 0 ; j + 1 < preList.size();j ++)
          {
              tempList.add(preList.get(j) + preList.get(j + 1));
          }
          tempList.add(1);
          resultList.add(tempList);
      }
      return resultList;
    }
    /**
     * 题目：给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

     说明: 叶子节点是指没有子节点的节点。
     */
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
      if (root == null)
      {
          if (sum == 0 && flag)
              return true;
          else
          {
              flag = true;
              return false;
          }
      }
      flag = true;
      if (root.left == null)
      {
          return hasPathSum(root.right,sum - root.val);
      }
      if (root.right == null)
          return hasPathSum(root.left,sum - root.val);
      return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }
    /**
     * 题目: 将有序数组转换为二叉搜索树
     *
     */
    public TreeNode sortedArrayToBST(int[] nums) {
       return sortedArrayToBST(nums,0,nums.length - 1);
    }
    public TreeNode sortedArrayToBST(int[] nums,int begin,int end)
    {
        if (begin > end)
             return  null;
        int mid = (begin + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,begin,mid - 1);
        root.right = sortedArrayToBST(nums,mid + 1,end);
        return root;
    }
    /**
     * 题目：给定一个二叉树，找出其最小深度。

     最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

     说明: 叶子节点是指没有子节点的节点。
     */
    public static int minDepth(TreeNode root) {
       if (root == null)
            return 0;
        if (root.left == null)
            return minDepth( root.right) + 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
       return Math.min(minDepth(root.left),minDepth(root.right)) + 1 ;
    }
    /**
     * 题目：平衡二叉树
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     本题中，一棵高度平衡二叉树定义为：
     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     */
    public boolean isBalanced(TreeNode root) {
         if (root == null)
             return true;

         return Math.abs(maxDepth(root.left)-maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced((root.right));
    }

    /**
     * 题目：给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

       List<List<Integer>> treeNodeValList = new ArrayList<>();
        if (root == null)
            return treeNodeValList;
       Queue<TreeNode> queue = new LinkedBlockingDeque<>();
       queue.add(root);
       while (!queue.isEmpty())
       {
           int size = queue.size();
           List<Integer> tmpList = new ArrayList<>();
           for (int i = 0 ;i < size;i++)
           {
               TreeNode tmpNode =  queue.poll();
               if (tmpNode.left != null)
                   queue.add(tmpNode.left);
               if (tmpNode.right != null)
                   queue.add(tmpNode.right);
               tmpList.add(tmpNode.val);
           }
           treeNodeValList.add(tmpList);
       }
      int start = 0,end = treeNodeValList.size() - 1;
       while (start <= end)
       {
           List<Integer> tmpList = treeNodeValList.get(start);
           treeNodeValList.set(start,treeNodeValList.get(end));
           treeNodeValList.set(end,tmpList);
           end--;
           start++;
       }
       return treeNodeValList;
    }
    /**
     * 题目：二叉树的最大深度
     */
//    public int maxDepth(TreeNode root) {
//         if (root == null)
//             return 0;
//         int count = 1;
//         Queue<TreeNode> queue = new LinkedBlockingDeque<>();
//         queue.add(root);
//         while (!queue.isEmpty())
//         {
//             int size = queue.size();
//             for (int  i = 0;i < size;i++)
//             {
//                 TreeNode tmpNode = queue.poll();
//                 if (tmpNode.left != null)
//                     queue.add(tmpNode.left);
//                 if (tmpNode.right != null)
//                     queue.add(tmpNode.right);
//             }
//             count++;
//         }
//         return count-1;
//    }
    public int maxDepth(TreeNode root) {
       if (root == null)
           return 0;
       return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    /**
     * 题目：给定一个二叉树，检查它是否是镜像对称的。

     例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
         1
       / \
      2   2
     / \ / \
     3  4 4  3
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return symmetric(root.left,root.right);
    }
    public boolean symmetric(TreeNode p,TreeNode q)
    {
        if (p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        return p.val == q.val && symmetric(p.left,q.right) && symmetric(p.right,q.left);
    }
    /**
     * 题目：给定两个二叉树，编写一个函数来检验它们是否相同。

     如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
//       Queue<TreeNode> queueTreeA = new LinkedBlockingDeque<TreeNode>();
//       Queue<TreeNode> queueTreeB = new LinkedBlockingDeque<TreeNode>();
//       queueTreeA.add(p);
//       queueTreeB.add(q);
//       while (!queueTreeA.isEmpty() && !queueTreeB.isEmpty())
//       {
//           int sizeA = queueTreeA.size();
//           int sizeB = queueTreeB.size();
//           if (sizeA != sizeB)
//               return false;
//           for (int i = 0 ; i < sizeA;i++)
//           {
//              TreeNode rootA = queueTreeA.poll();
//              TreeNode rootB = queueTreeB.poll();
//              if (rootA != rootB)
//                  return false;
//              if (rootA.left != null)
//              {
//                  queueTreeA.add(rootA.left);
//              }
//               if (rootB.left != null)
//               {
//                   queueTreeB.add(rootB.left);
//               }
//              if (rootA.right!= null )
//              {
//                  queueTreeA.add(rootA.right);
//              }
//              if (rootB.right != null)
//              {
//                  queueTreeB.add(rootB.right);
//              }
//           }
//       }
//       if (!queueTreeA.isEmpty() || !queueTreeB.isEmpty())
//           return false;
       return (p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
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
