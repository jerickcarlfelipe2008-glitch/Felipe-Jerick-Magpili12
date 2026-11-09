
import java.util.Scanner;

public class CustomerTransactionManager {
    static String[] ids;
    static double[] amounts;
    static double[][] items;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of customers: ");
        int n = sc.nextInt();

        ids = new String[n];
        amounts = new double[n];
        items = new double[n][3];

        for (int i = 0; i < n; i++) {
            System.out.println("\nCustomer " + (i + 1));
            System.out.print("Transaction ID: ");
            ids[i] = sc.next();

            for (int j = 0; j < 3; j++) {
                System.out.print("Item " + (j + 1) + " amount: ");
                items[i][j] = sc.nextDouble();
                amounts[i] += items[i][j];
            }
        }

        bubbleSort(n);

        System.out.println("\nSORTED CUSTOMER TRANSACTIONS");
        System.out.println("ID\tTotal\tItems");

        for (int i = 0; i < n; i++) {
            System.out.printf("%s\t%.2f\t%.2f, %.2f, %.2f%n",
                ids[i], amounts[i],
                items[i][0], items[i][1], items[i][2]);
        }

        sc.close();
    }

    static void bubbleSort(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (amounts[j] > amounts[j + 1]) {
                    double temp = amounts[j];
                    amounts[j] = amounts[j + 1];
                    amounts[j + 1] = temp;

                    String tempID = ids[j];
                    ids[j] = ids[j + 1];
                    ids[j + 1] = tempID;

                    double[] tempRow = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = tempRow;
                }
            }
        }
    }
}
