# Leetcode做题总结

## 数组相关

| 题号 | 题目名                   | 题目大概内容                                                 | 知识点                   | 适合拆出来的算法       |
| ---- | ------------------------ | ------------------------------------------------------------ | ------------------------ | ---------------------- |
| 1    | 两数之和                 | 给定一个整数数组 `nums` 和一个目标值 `target`，请你在该数组中找出和为目标值的那 **两个** 整数，并返回他们的数组下标。 | 数组、哈希表             | 无                     |
| 4    | 寻找两个有序数组的中位数 | 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。<br/>请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。<br/>你可以假设 nums1 和 nums2 不会同时为空。 | 数组、二分查找、分治算法 | 两个有序数组的二分查找 |

## 链表相关

| 题号 | 题目名   | 题目大概内容                                                 | 知识点 | 适合拆出来的算法                             |
| ---- | -------- | ------------------------------------------------------------ | ------ | -------------------------------------------- |
| 2    | 两数相加 | 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。<br/>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。<br/>您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 | 链表   | 思考题（链表存储正序）：链表倒序执行特定操作 |

## 字符串相关

| 题号 | 题目名                 | 题目大概内容                                                 | 知识点                           | 适合拆出来的算法       |
| ---- | ---------------------- | ------------------------------------------------------------ | -------------------------------- | ---------------------- |
| 3    | 无重复字符的最长子串   | 给定一个字符串，请你找出其中不含有重复字符的 **最长子串** 的长度。 | 哈希表、双指针、字符串、滑动窗口 | 滑动窗口算法           |
|      | 最长回文子串           | 给定一个字符串 `s`，找到 `s` 中最长的回文子串。你可以假设 `s` 的最大长度为 1000。 | 字符串、动态规划                 | 马拉车算法（Manacher） |
| 6    | Z字形变换              | 略                                                           | 字符串                           | 无                     |
| 8    | 字符串转换整数（atoi） | 略                                                           | 字符串、数学                     | 无                     |
| 10   | 正则表达式匹配 | 给你一个字符串 `s` 和一个字符规律 `p`，请你来实现一个支持 `'.'` 和 `'*'` 的正则表达式匹配。'.' 匹配任意单个字符， '*' 匹配零个或多个前面的那一个元素 | 字符串、动态规划、回溯算法 | 回溯算法？动态规划？ |

## 其他

| 题号 | 题目名         | 题目大概内容                                                 | 知识点                     | 适合拆出来的算法     |
| ---- | -------------- | ------------------------------------------------------------ | -------------------------- | -------------------- |
| 7    | 整数反转       | 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。<br/>假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 | 数学                       | 无                   |
| 9    | 回文数         | 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 | 数学                       | 无                   |
