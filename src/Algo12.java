import java.util.Arrays;

void main() {
    int[] nums = {6, 4, 9, 5, -2, 3, 8, 0, 11};
    System.out.println(Arrays.toString(nums));
    mergeSort(nums);
    System.out.println(Arrays.toString(nums));
}

void mergeSort(int[] nums) {
    sort(nums, 0, nums.length);
}

void sort(int[] nums, int start, int end) {
    int length = (end - start) / 2;
    if (length == 0) return;
    int[] arr1 = new int[length];
    int[] arr2 = new int[nums.length - arr1.length];

    for (int i = 0; i < arr1.length; i++) arr1[i] = nums[i];
    for (int i = 0; i < arr2.length; i++) arr2[i] = nums[i + arr1.length];
    System.out.println(Arrays.toString(arr1) + "," + Arrays.toString(arr2));
    sort(arr1, start, end / 2);
    sort(arr2, start, end / 2);
    System.out.println("********************");
    System.out.println(Arrays.toString(nums));
    int k = 0, m = 0;
    int i = 0;
    while (k < arr1.length && m < arr2.length) {
        if (arr1[k] < arr2[m]) {
            nums[i] = arr1[k++];
        } else {
            nums[i] = arr2[m++];
        }
        i++;
    }
    while (k < arr1.length) {
        nums[i] = arr1[k++];
        i++;
    }
    while (m < arr2.length) {
        nums[i] = arr2[m++];
        i++;
    }

    System.out.println(Arrays.toString(nums));
    System.out.println("============");
}