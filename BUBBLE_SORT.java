import java.util.Scanner;

public class BUBBLE_SORT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ENTER NUMBER OF ELEMENTS: ");
        int n = scanner.nextInt();

        int[] A = new int[100];

        System.out.println("ENTER NUMBERS INTO ARRAY:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        System.out.print("UPDATED BUBBLE SORT IS: ");
        for (int i = 0; i < n; i++) {
            System.out.print("--->" + A[i] + "\n");
        }

        scanner.close();
    }
}
