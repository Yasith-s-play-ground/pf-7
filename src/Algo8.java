import java.util.Scanner;

// linear search, not suitable when searching through a large number of elements
void main() {
    int[] nums = {50, 20, 3, -2, 7, 8};
    final var SCANNER = new Scanner(System.in);
    outer:
    do {
        System.out.print("Enter a number to search : ");
        int input = SCANNER.nextInt();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == input) {
                System.out.println(STR."Found at : \{i}");
                continue outer;
            }
        }
        System.out.println("Not found");
    } while (true);


}