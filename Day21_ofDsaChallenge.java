import java.io.*;
import java.util.*;

public class Solution {
    static void swapAtK(int[][] indexes, int node, int depth, int k) {
        if (node == -1) return;

        if (depth % k == 0) {
            int temp = indexes[node][0];
            indexes[node][0] = indexes[node][1];
            indexes[node][1] = temp;
        }

        swapAtK(indexes, indexes[node][0], depth + 1, k);
        swapAtK(indexes, indexes[node][1], depth + 1, k);
    }
    static void inorder(int[][] indexes, int node, List<Integer> res) {
        if (node == -1) return;

        inorder(indexes, indexes[node][0], res);
        res.add(node);
        inorder(indexes, indexes[node][1], res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] indexes = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            indexes[i][0] = sc.nextInt();
            indexes[i][1] = sc.nextInt();
        }

        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt();

            swapAtK(indexes, 1, 1, k);

            List<Integer> result = new ArrayList<>();
            inorder(indexes, 1, result);

            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}