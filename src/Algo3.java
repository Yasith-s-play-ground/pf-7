import java.util.Arrays;

void main() {
    System.out.println(Arrays.toString(checkTwoSum(1225, 7)));//[2,5]
    System.out.println(Arrays.toString(checkTwoSum(2508, 10)));//[2,8]
    System.out.println(Arrays.toString(checkTwoSum(123, 7)));//null
    System.out.println(Arrays.toString(checkTwoSum(4582, 13)));//[5,8]
    System.out.println(Arrays.toString(checkTwoSum(7214, 11)));//[7,4]
    System.out.println(Arrays.toString(checkTwoSum(888, 15)));//null
}

int[] checkTwoSum(int number, int target) {
    int[] numbers = returnNumArray(number);
    for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
            if ((numbers[j] + numbers[i]) == target) return new int[]{numbers[i], numbers[j]};
        }
    }
    return null;
}

int[] returnNumArray(int number) {
    int num = number;
    int count = 0;
    while (num != 0) {
        count++;
        num /= 10;
    }
    int[] numArray = new int[count];

    num = number;
    while (num != 0) {
        numArray[count - 1] = num % 10;
        num /= 10;
        count--;
    }
    return numArray;
}