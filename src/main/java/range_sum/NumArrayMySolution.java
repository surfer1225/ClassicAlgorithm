package main.java.range_sum;

/*
Range Sum Query - Mutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
 */

class NumArrayMySolution {

    private int[] nums;
    private int[] sum;
    private int updateidx = -1;
    private int updateDiff = 0;

    public NumArrayMySolution(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length+1];
        sum[0]=0;
        for (int i=1;i<=nums.length;i++) {
            sum[i]=sum[i-1]+nums[i-1];
        }
    }

    public void update(int i, int val) {
        if (updateidx!=-1) {
            for (int idx=updateidx+1;idx<sum.length;idx++) sum[idx]+=updateDiff;
        }
        updateidx = i;
        updateDiff = val - nums[i];
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        if (updateidx!=-1) {
            for (int idx=updateidx+1;idx<sum.length;idx++) sum[idx]+=updateDiff;
            updateidx = -1;
        }
        return sum[j+1]-sum[i];
    }

    public static void main(String[] args) {
        NumArrayMySolution obj = new NumArrayMySolution(new int[]{1,3,5});
        System.out.println(obj.sumRange(0,2));
        obj.update(1,2);
        System.out.println(obj.sumRange(0,2));
    }
}

/**
 * Your NumArrayMySolution object will be instantiated and called as such:
 * NumArrayMySolution obj = new NumArrayMySolution(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
