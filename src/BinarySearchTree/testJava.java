package BinarySearchTree;

import SimpleCode.TreeNode;

import java.util.LinkedList;

/**
 * 二叉搜索树
 */
public class testJava {
    public static void main(String[] args) {

        System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,2147483647}, 1, 2147483647));
    }
    /**
     * 题目：
     *  存在重复元素 III
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0 ; i < nums.length;i++)
        {
            for (int j = i + 1 ; j < nums.length && j <= i + k;j++)
            {
                if (Math.abs(Long.valueOf(nums[i])- Long.valueOf(nums[j])) <= t )
                    return true;
            }
        }
        return false;
    }
    /**
     * 题目：
     * 二叉搜索树结点最小距离
     */
    public int minDiffInBST(TreeNode root) {
       if (root == null)
           return Integer.MAX_VALUE;
       if (root.right == null && root.left == null)
           return Integer.MAX_VALUE;
       if (root.left == null)
       {
           return Math.min(Math.abs(root.val - root.right.val),minDiffInBST(root.right));
       }
        if (root.right == null)
        {
            return Math.min(Math.abs(root.val - root.left.val),minDiffInBST(root.left));
        }
        return Math.min(Math.min(Math.abs(root.val - root.right.val),minDiffInBST(root.right)),Math.min(Math.abs(root.val - root.left.val),minDiffInBST(root.left)));

    }
    /**
     * 题目：
     *  二叉搜索树的最小绝对差(优化)
     */
    private int min = Integer.MAX_VALUE;
    private int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        midSort(root);
      return min;
    }
    /**
     * 中序遍历二叉树
     */
    public void midSort(TreeNode root)
    {
        if (root == null)
            return;
        if (root.left != null)
            midSort(root.left);
        if (pre != -1)
            min = Math.min(min,root.val - pre);
         pre = root.val;
        if (root.right != null)
            midSort(root.right);
    }
//    /**
//     * 题目：
//     *  二叉搜索树的最小绝对差()
//     */
//    public int getMinimumDifference(TreeNode root) {
//      LinkedList<Integer> linkedList = new LinkedList<Integer>();
//      int min = Integer.MAX_VALUE;
//      //中序遍历二叉树
//        midSort(root,linkedList);
//        for (int i = 1; i < linkedList.size();i++)
//        {
//           min = Math.min(min,Math.abs(linkedList.get(i) - linkedList.get(i - 1)));
//        }
//        return min;
//    }
//    /**
//     * 中序遍历二叉树
//     */
//    public void midSort(TreeNode root, LinkedList linkedList)
//    {
//        if (root == null)
//          return;
//       if (root.left != null)
//           midSort(root.left,linkedList);
//       linkedList.add(root.val);
//       if (root.right != null)
//           midSort(root.right,linkedList);
//    }
}
