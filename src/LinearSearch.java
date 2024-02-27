void main() {
    int[] arr1 = {1, 56, 45, 89, 4};

    int num = 45;

    for (int i = 0; i < arr1.length; i++) {
        if (arr1[i] == num) {
            System.out.println(num + " found at index " + i);
            return;
        }
    }
}