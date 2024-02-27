import java.util.Arrays;

void main() {
    int[] array = {9, 8, 5, 10, -3, -56, 45};
    System.out.print("Starting array is : ");
    System.out.println(Arrays.toString(array));
    mergeSort(array);
    System.out.print("Sorted array is : ");
    System.out.println(Arrays.toString(array));
}

void mergeSort(int[] array) {
    int leftArraySize = array.length / 2;
    int rightArraySize = array.length - leftArraySize;

    if (array.length == 1) return;

    int[] leftArray = new int[leftArraySize];
    int[] rightArray = new int[rightArraySize];

    int leftArrayIndex = 0, rightArrayIndex = 0, arrayIndex = 0;

    while (arrayIndex < array.length) {
        if (leftArrayIndex < leftArraySize) {
            leftArray[leftArrayIndex++] = array[arrayIndex++];
        } else if (rightArrayIndex < rightArraySize) {
            rightArray[rightArrayIndex++] = array[arrayIndex++];
        }
    }
    mergeSort(leftArray);
    mergeSort(rightArray);
    merge(leftArray, rightArray, array);
}

void merge(int[] leftArray, int[] rightArray, int[] array) {
    int arrayIndex = 0, leftArrayIndex = 0, rightArrayIndex = 0;
    while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
        if (leftArray[leftArrayIndex] < rightArray[rightArrayIndex]) {
            array[arrayIndex++] = leftArray[leftArrayIndex++];
        } else {
            array[arrayIndex++] = rightArray[rightArrayIndex++];
        }
    }
    while (leftArrayIndex < leftArray.length) {
        array[arrayIndex++] = leftArray[leftArrayIndex++];
    }
    while (rightArrayIndex < rightArray.length) {
        array[arrayIndex++] = rightArray[rightArrayIndex++];
    }
}