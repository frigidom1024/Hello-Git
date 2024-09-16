import java.util.Scanner;

public class Test01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("第n号猴子,请输入n的值");
        int n = scanner.nextInt();
        System.out.println("剩下m个桃子，请输入m的值");
        int m = scanner.nextInt();


        int b=(m+1)*(int)Math.pow(2,n)-1;//计算原本桃子个数
        System.out.println("原本剩下的桃子"+b);


    }
}

