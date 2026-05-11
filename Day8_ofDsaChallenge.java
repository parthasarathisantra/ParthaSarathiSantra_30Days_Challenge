import java.util.*;

public class Day8_ofDsaChallenge {

    public static int solve(String s1, String s2, int k) {
        int n = s1.length();
        int maxLen = 0;

        for (int shift = -n + 1; shift < n; shift++) {

            int i = Math.max(0, shift);
            int j = Math.max(0, -shift);

            int mismatch = 0;
            int left = 0;

            for (int right = 0; i + right < n && j + right < n; right++) {

                if (s1.charAt(i + right) != s2.charAt(j + right)) {
                    mismatch++;
                }

                while (mismatch > k) {
                    if (s1.charAt(i + left) != s2.charAt(j + left)) {
                        mismatch--;
                    }
                    left++;
                }

                int length = right - left + 1;
                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();

            System.out.println(solve(s1, s2, k));
        }

        sc.close();
    }
}