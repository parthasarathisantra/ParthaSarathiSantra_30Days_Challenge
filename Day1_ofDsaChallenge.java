import java.util.*;


public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int d = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        d = d % n ;
            
            for(int j = 0; j<n;j++){
                System.out.print(arr[(j+d)%n]+ " ");
            }
    }
}
