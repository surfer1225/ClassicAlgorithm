package main.java.tree;

/*
303. Range Sum Query - Immutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
 */
public class NumArray {

    int[] tree;
    int l;

    public NumArray(int[] nums) {
        l = nums.length;
        tree = new int[l*2];

        for (int i=l;i<2*l;i++) tree[i]=nums[i-l];
        for (int i=l-1;i>=0;i--) tree[i]=tree[2*i]+tree[2*i+1];
    }

    public int sumRange(int i, int j) {
        i+=l;
        j+=l;

        int sum = 0;

        while (i<=j) {
            if ((i%2==1)) {
                sum+=tree[i];
                ++i;
            }
            if ((j%2==0)) {
                sum+=tree[j];
                --j;
            }
            i/=2;
            j/=2;
        }

        return sum;
    }
}
