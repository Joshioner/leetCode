package BinarySearch;

import java.util.*;

/**
 * 二分查找
 */
public class testJava {

    public static void main(String[] args)
    {
        System.out.println(divide(10,-1));

    }
    /**
     * 题目：两数相除(方法一：结果超时)
     * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

     返回被除数 dividend 除以除数 divisor 得到的商。
     */
    public static int divide1(int dividend, int divisor) {
         if (divisor == 0)
             return -1;
         if (divisor == 1)
             return dividend;
         if (divisor == -1)
         {
             if (dividend <= Integer.MIN_VALUE)
                 return Integer.MAX_VALUE;
             return (int)(-dividend);
         }
         int i;
         Long dividendTemp = Long.valueOf(dividend > 0 ? dividend : - dividend);
         Long divisorTemp = Long.valueOf(divisor > 0 ? divisor : - divisor);
        for (i = 0;dividendTemp >= divisorTemp; i++)
         {
             dividendTemp -= divisorTemp;
         }
         return ((divisor > 0 && dividend > 0)||(dividend < 0 && divisor < 0)) ? i : -i;
    }

    public static int divide(int dividend, int divisor) {
        if (divisor == 0)
            return -1;
        if (divisor == 1)
            return dividend;
        if (divisor == -1)
        {
            if (dividend <= Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return (int)(-dividend);
        }
        long dividendTmp = Math.abs((long)dividend);
        long divisorTmp = Math.abs((long)divisor);
        int result = 0;
        while (divisorTmp <= dividendTmp)
        {
            long tmp = divisorTmp;
            long mul = 1;
            while (dividendTmp >= (tmp << 1))
            {
                tmp  <<= 1;
                mul <<= 1;
            }
            dividendTmp -= tmp;

            result += mul;
        }

        return (dividend < 0)^(divisor < 0) ? -result : result;

    }
    /**
     * 题目：寻找比目标字母大的最小字母
     * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。

     数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
     */
    public char nextGreatestLetter(char[] letters, char target) {
       for (int i = 0;i < letters.length;i++)
       {
           if (letters[i] > target)
               return letters[i];
       }
       return letters[0];
    }
    /**
     * 题目：排列硬币
     *
     * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。

     给定一个数字 n，找出可形成完整阶梯行的总行数。

     n 是一个非负整数，并且在32位有符号整型的范围内。
     */
    public static int arrangeCoins(int n) {
        int i ;
       for (i = 1; n >= i; i++)
       {
           n -= i;
       }
       return i - 1;

    }
    /**
     * 题目：猜数字大小
     */
    public  int guessNumber(int n) {
       int low = 1,high = n ,mid;
       while (low <= high)
       {
           mid = low + (high - low) / 2;
           if (guess(mid) == 0)
               return mid;
           else if (guess(mid) == 1)
               low = mid + 1;
           else
               high = mid -1;
       }
       return 0;
    }
    int guess(int num)
    {
        return 0;
    }
    /**
     * 题目：有效的完全平方数
     *
     * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

     注意：不要使用任何内置的库函数，如  sqrt。
     */
    public static boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0)
        {
            num -= i;
            i += 2;
        }
        return num == 0;
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
