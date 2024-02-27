import java.util.Arrays;
import java.util.Scanner;

void main() {
    int[] nums = {5, 4, -3, 0, 7, 2, 1};
    final var SCANNER = new Scanner(System.in);

    insertionSort(nums);
    System.out.println(Arrays.toString(nums));
    do {
        System.out.print("Enter a number to search : ");
        int input = SCANNER.nextInt();

        int index = binarySearch(nums, input, 0, nums.length - 1);
        if (index != -1) System.out.println(STR."Found at index : \{index}");
        else System.out.println("\033[31mNot found\033[0m");

    } while (true);
}

int binarySearch(int[] nums, int target, int head, int tail) {
    int mid = (head + tail) / 2;
    if (target < nums[head] || target > nums[tail]) return -1;
    else if (nums[head] == target) return head;
    else if (nums[tail] == target) return tail;
    else if (nums[mid] == target) return mid;
    else {
        if (target < nums[mid]) {
            head = 0;
            tail = mid - 1;
        } else {
            head = mid + 1;
            tail = tail - 1;
        }
        return binarySearch(nums, target, head, tail);
    }
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