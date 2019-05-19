package main.java.range_sum;

public class NumArraySqrt {

    int[] sums;
    int[] nums;
    int l;

    public NumArraySqrt(int[] nums) {
        this.nums = nums;
        this.l = (int) Math.ceil(Math.sqrt(nums.length));
        this.sums = new int[l];

        for (int i=0;i<nums.length;i++) {
            sums[i/l] += nums[i];
        }
    }

    public void update(int i, int val) {
        int b_l = i / l;
        sums[b_l] = sums[b_l] - nums[i] + val;
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        int startBlock = i / l;
        int endBlock = j / l;
        if (startBlock == endBlock) {
            for (int k = i; k <= j; k++)
                sum += nums[k];
        } else {
            for (int k = i; k <= (startBlock + 1) * l - 1; k++)
                sum += nums[k];
            for (int k = startBlock + 1; k <= endBlock - 1; k++)
                sum += sums[k];
            for (int k = endBlock * l; k <= j; k++)
                sum += nums[k];
        }
        return sum;
    }
}
