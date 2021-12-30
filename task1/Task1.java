package task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        outer: while (true){
            System.out.println("");
            System.out.println("Введите значение n");
            String nStr = scanner.nextLine();
            int n = Integer.parseInt(nStr);

            System.out.println("Введите значение m");
            String mStr = scanner.nextLine();
            int m = Integer.parseInt(mStr);

            GetPath(n, m);
        }
    }

    public static void GetPath (int n, int m) {
        int endpoint = 0;

        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = (i + 1);
        }

        int[] array2 = new int[m];
        do {
        for (int i = 0; i < m; i++) {
            array2[i] = array1[endpoint];
            if (i != (m - 1)){
                endpoint++;
            }
            if (i == (m - 1)){
                System.out.print(array2[0]);
            }
            if (endpoint == n) {
                endpoint = 0;
            }
        }
    } while (array2[(m-1)] != 1);
}
}

