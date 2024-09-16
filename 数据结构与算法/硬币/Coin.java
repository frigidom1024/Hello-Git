import java.util.Scanner;
public class Coin {
    public static void main(String[] args) {
        int count =0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int z=n*20;
        for (int i = 0; i <= z; i++) {
            int y=(100*n-5*i)/2;
            count=count+y+1;
        }
        System.out.println(count);
    }
}
