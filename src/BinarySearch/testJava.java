package BinarySearch;

import java.util.*;

/**
 * 二分查找
 */
public class testJava {

    public static void main(String[] args)
    {
        int[] nums1= {1, 2, 2, 1,6,5}, nums2 = {2, 2,5,2};
        System.out.println(Arrays.toString(intersect(nums1,nums2)));
    }
    /**
     * 题目：两个数组的交集
     *
     * 给定两个数组，写一个函数来计算它们的交集。

     例子:

     给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].

     提示:

     每个在结果中的元素必定是唯一的。
     我们可以不考虑输出结果的顺序。
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> integerSet = new TreeSet<>();
        //排序（时间复杂度为logn)
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int startA = 0,startB = 0;
        while (startA < nums1.length && startB < nums2.length)
        {
            if (nums1[startA] == nums2[startB])
            {
                integerSet.add(nums1[startA]);
                startA++;
                startB++;
            }
            else if (nums1[startA] >  nums2[startB])
                startB++;
            else
                startA++;
        }
        int[] index = new int[integerSet.size()];
        int count = 0;
        Iterator<Integer> integerIterator = integerSet.iterator();
        while (integerIterator.hasNext())
        {
            index[count++] = integerIterator.next();
        }
        return index;
    }
    /**
     * 题目：两个数组的交集 II
     * 给定两个数组，写一个方法来计算它们的交集。

     例如:
     给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].

     注意：

     输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     我们可以不考虑输出结果的顺序。
     跟进:

     如果给定的数组已经排好序呢？你将如何优化你的算法？
     如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     如果nums2的元素存储在磁盘上，内存是有限的，你不能一次加载所有的元素到内存中，你该怎么办？
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> integerList = new LinkedList<>();
        //排序（时间复杂度为logn)
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int startA = 0, startB = 0;
        while (startA < nums1.length && startB < nums2.length) {
            if (nums1[startA] == nums2[startB]) {
                integerList.add(nums1[startA]);
                startA++;
                startB++;
            } else if (nums1[startA] > nums2[startB])
                startB++;
            else
                startA++;
        }
        int[] index = new int[integerList.size()];
        int count = 0;
        Iterator<Integer> integerIterator = integerList.iterator();
        while (integerIterator.hasNext()) {
            index[count++] = integerIterator.next();
        }
        return index;
    }
}
