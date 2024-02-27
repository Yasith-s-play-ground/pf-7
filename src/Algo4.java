void main() {
    System.out.println(divide(4, 2));//2
    System.out.println(divide(8, 2));//4
    System.out.println(divide(9, 3));//3
    System.out.println(divide(12, 4));//3
    System.out.println(divide(5, 2));//3
}

int divide(int num1, int num2) {
    int count = 0;
    while (num1 >= num2) {
        num1 = num1 - num2;
        count++;
    }
    return count;
}