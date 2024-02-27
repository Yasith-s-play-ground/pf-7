import java.util.Arrays;

void main() {
    int[] nums = {6, 4, 9, 5, 5, -2, 7, 0};
    System.out.println(Arrays.toString(nums));
    insertionSort(nums);
    System.out.println(Arrays.toString(nums));
}

void insertionSort(int[] nums) {
    int num;
    int correctIndex = -1;
    for (int i = 1; i < nums.length; i++) {
        //selection
        num = nums[i];
        if (num < nums[i - 1]) {// optimization logic
            for (int j = i - 1; j >= 0; j--) {  // linear search for the correct position
                if (nums[j] > num) correctIndex = j;
            }
            for (int k = i - 1; k >= correctIndex; k--) { // shifting other numbers
                nums[k + 1] = nums[k];
            }
            nums[correctIndex] = num; // insert value to the correct position
        }
    }
}