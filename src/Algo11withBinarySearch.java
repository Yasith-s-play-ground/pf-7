import java.util.Arrays;

void main() {
    int[] nums = {6, 4, 9, 5, -2, 7, 0,5};
    System.out.println(Arrays.toString(nums));
    insertionSort(nums);
    System.out.println(Arrays.toString(nums));
}

void insertionSort(int[] nums) {
    int num;
    int correctIndex;
    for (int i = 1; i < nums.length; i++) {
        //selection
        num = nums[i];
        if (num < nums[i - 1]) {// optimization logic
            System.out.println(STR."i is \{i} ");

            correctIndex = binarySearch(nums, num, 0, i - 1); // binary search for the correct position
            System.out.println(STR."i is \{i} Correct index for " + num + " is " + correctIndex);
            for (int k = i - 1; k >= correctIndex; k--) { // shifting other numbers
                nums[k + 1] = nums[k];
            }
            nums[correctIndex] = num; // insert value to the correct position
            System.out.println("Sorted array is " + Arrays.toString(nums));
        }
    }
}

int binarySearch(int[] nums, int target, int head, int tail) {
    int mid = (head + tail) / 2;
    if (target < nums[head]) return head;
    else if (head == tail - 1 && target < nums[tail] && target > nums[head]) return tail;
    else if (target == nums[head]) return head;
    else if (target == nums[tail]) return tail;
    else if (target == nums[mid]) return mid;
    else if (target < nums[mid]) {
        head = 0;
        tail = mid - 1;
    } else if (target > nums[mid]) {
        head = mid + 1;
        tail = tail - 1;
    }
    return binarySearch(nums, target, head, tail);
}
