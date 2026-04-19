import java.io.*;
import java.util.*;

class Solution {

    public static int simpleArraySum(List<Integer> ar) {
        int sum = 0;
        for (int num : ar) {
            sum += num;
        }
        return sum;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  
        List<Integer> ar = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ar.add(sc.nextInt());
        }

        int result = Solution.simpleArraySum(ar);
        System.out.println(result);

        sc.close();
    }
}