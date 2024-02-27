import java.util.Arrays;

void main() {
    int[] nums1 = {5, -1, 3, -2, 0, 8, 4};
    int[] nums2 = {5, -1, 3, -2, 0, 8, 4};
    int[] nums3 = {5, -1, 3, -2, 0, 8, 4};

    System.out.println(Arrays.toString(nums1));
    bubbleSortViaMin(nums1);
    System.out.println(Arrays.toString(nums1));

    System.out.println("-------------------------");

    System.out.println(Arrays.toString(nums2));
    bubbleSortViaMax(nums2);
    System.out.println(Arrays.toString(nums2));

    System.out.println("Recursion-------------------------");

    System.out.println(Arrays.toString(nums3));
    bubbleSortViaMinRecursion(nums3, 0, 0);
    System.out.println(Arrays.toString(nums3));
}

void bubbleSortViaMin(int nums[]) {
    int temp;
    for (int count = nums.length - 1; count >= 0; count--) {
        for (int i = 0; i < count; i++) {
            if (nums[i] > nums[i + 1]) {
                temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
}

void bubbleSortViaMax(int[] nums) {
//    int temp;
//    for (int i = nums.length - 1; i > 0; i--) {
//        for (int j = i - 1; j >= 0; j--) {
//            if (nums[i] < nums[j]) {
//                temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//            }
//        }
//    }

    int temp;
    for (int count = 0; count < nums.length - 1; count++) {
        for (int i = nums.length - 1; i > count; i--) {
            if (nums[i] < nums[i - 1]) {
                temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

}

void bubbleSortViaMinRecursion(int[] nums, int index, int count) {
    int temp;
    if (nums[index] > nums[index + 1]) {
        temp = nums[index];
        nums[index] = nums[index + 1];
        nums[index + 1] = temp;
    }
    index++;

    if (index == nums.length - 1) {
        count++;
        index = count;
    }
    if (count == nums.length-1) return;
    bubbleSortViaMinRecursion(nums, index, count);
}