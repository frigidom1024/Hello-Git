import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Multiplication {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.print("请选择输入的数字位数n: ");
        int n = scanner.nextInt();
        System.out.println("手动录入请按1,随机生成请按2");
        int m = scanner.nextInt();
        while (true) {
            if (m == 2) {
                // 生成第一个 99 位数字字符串
                Random random = new Random();
                    sb1.append(random.nextInt(9)+1);
                for (int i = 1; i < n; i++) {
                    sb1.append(random.nextInt(10));
                }
                // 生成第二个 99 位数字字符串
                    sb2.append(random.nextInt(9)+1);
                for (int i = 1; i < n; i++) {
                    sb2.append(random.nextInt(10));
                }
                String x = sb1.toString();
                String y = sb2.toString();
                System.out.println("第一个" + n + " 位数字字符串: " + x);
                System.out.println("第二个" + n + "位数字字符串: " + y);
                System.out.println(multiply(x,y));
                return;
            }
            if (m == 1) {
                Scanner sc= new Scanner(System.in);
                System.out.println("请输入第一个数字");
                String x = sc.nextLine();
                System.out.println("请输入第二个数字");
                String y = sc.nextLine();
                System.out.println(multiply(x,y));
                return;
            }
            System.out.println("请重新选择" );
        }
    }
    static String multiply(String x, String y) {
        BigInteger b1=new BigInteger(x);
        BigInteger b2=new BigInteger(y);
        return b1.multiply(b2).toString();
        }
    }
