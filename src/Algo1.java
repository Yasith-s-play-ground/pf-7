import java.util.Arrays;

void main() {
    int[] nums = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    int[] reverseNums = reverseArray(nums);

    System.out.println(Arrays.toString(reverseNums));
    System.out.println(Arrays.toString(reverseArray(new int[]{1, 2, 3, 4, 5})));
}

int[] reverseArray(int[] nums) {
    int[] reverseNums = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
        reverseNums[reverseNums.length - 1 - i] = nums[i];
    }
    return reverseNums;
}