import java.util.*;
import java.io.*;

public class Day6_ofDsaChallenge {

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        Map<String, Integer> freq = new HashMap<>();
        for (String s : strings) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();

        for (String q : queries) {
            result.add(freq.getOrDefault(q, 0));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); 
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strings.add(sc.nextLine());
        }

        int q = sc.nextInt();
        sc.nextLine(); 

        List<String> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            queries.add(sc.nextLine());
        }

        List<Integer> result = matchingStrings(strings, queries);

        for (int res : result) {
            System.out.println(res);
        }

        sc.close();
    }
}