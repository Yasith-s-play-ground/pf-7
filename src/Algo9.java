import java.util.Arrays;

void main() {
    int[] nums1 = {3, 2, 5, -3, 0, 8};
    int[] nums2 = {3, 2, 5, -3, 0, 8};
    int[] nums3 = {3, 2, 5, -3, 0, 8};
    int[] nums4 = {3, 2, 5, -3, 0, 8};

    System.out.println(Arrays.toString(nums1));
    selectionSortMin(nums1);
    System.out.println(Arrays.toString(nums1));

    System.out.println("-----------------------");

    System.out.println(Arrays.toString(nums2));
    selectionSortMax(nums2);
    System.out.println(Arrays.toString(nums2));

    System.out.println("By Recursion -----------------------");

    System.out.println(Arrays.toString(nums3));
    selectionSortMinRecursion(nums3, 0, 1, 0, nums3[0]);
    System.out.println(Arrays.toString(nums3));

    System.out.println("-----------------------");

    System.out.println(Arrays.toString(nums4));
    selectionSortMaxRecursion(nums4, nums4.length - 1, nums4.length - 2, nums4.length - 1, nums4[nums4.length - 1]);
    System.out.println(Arrays.toString(nums3));

}

void selectionSortMin(int[] nums) {
    int temp, min, minIndex;
    for (int i = 0; i < nums.length; i++) {
        minIndex = i;
        min = nums[minIndex]; // select a value first
        for (int j = i + 1; j < nums.length; j++) {
            if (min > nums[j]) {
                minIndex = j;
                min = nums[j];   // check for rest of elements to find suitable element for position
            }
        }
        if (minIndex == i) continue;
        temp = nums[i];
        nums[i] = min;
        nums[minIndex] = temp;  // assign the lowest value found to current position
    }
}

void selectionSortMax(int[] nums) {
    int temp, max, maxIndex;
    for (int i = nums.length - 1; i >= 0; i--) {
        maxIndex = i;
        max = nums[maxIndex];
        for (int j = i - 1; j >= 0; j--) {
            if (max < nums[j]) {
                maxIndex = j;
                max = nums[j];
            }
        }
        if (maxIndex == i) continue;
        temp = nums[i];
        nums[i] = max;
        nums[maxIndex] = temp;
    }


}

void selectionSortMinRecursion(int[] nums, int i, int j, int minIndex, int min) {
    int temp;
    if (min > nums[j]) {
        minIndex = j;
        min = nums[j];

    }
    if (i < nums.length - 2) j++;

    if (j == nums.length - 1) {
        temp = nums[i];
        nums[i] = min;
        nums[minIndex] = temp;
        i++;
        j = i + 1;
        minIndex = i;
        min = nums[minIndex];
    }
    if (i == nums.length - 1) return;
    selectionSortMinRecursion(nums, i, j, minIndex, min);
}

void selectionSortMaxRecursion(int[] nums, int i, int j, int maxIndex, int max) {
    int temp;
    if (max < nums[j]) {
        maxIndex = j;
        max = nums[j];

    }
    if (i > 0) j--;

    if (j == 0) {
        temp = nums[i];
        nums[i] = max;
        nums[maxIndex] = temp;
        i--;
        j = i - 1;
        maxIndex = i;
        max = nums[maxIndex];
    }
    if (i == 1) return;
    selectionSortMinRecursion(nums, i, j, maxIndex, max);
}