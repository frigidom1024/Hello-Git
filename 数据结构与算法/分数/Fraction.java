import java.util.Random;
import java.util.Scanner;
import java.util.Random;


public class Fraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("分子,分母的长度 ");
        int n = sc.nextInt();
        System.out.println("生成个数");
        int m = sc.nextInt();
        for (int k = 0; k < m; k++) {  //控制生成个数


            StringBuilder numberator = generator(n);
            StringBuilder denominator = generator(n);
            String fraction = numberator + "/" + denominator;
            System.out.print(fraction);//生成分数


            for (int i = numberator.length(); i > 0; i--) {
                for (int j = denominator.length(); j > 0; j--) {
                    if (numberator.charAt(i - 1) == denominator.charAt(j - 1)) {
                        numberator.deleteCharAt(i - 1);
                        denominator.deleteCharAt(j - 1);
                    }
                }

            }//进行约分
            fraction = numberator + "/" + denominator;
            System.out.println("  约分后：" + fraction);
        }
    }



    static StringBuilder generator(int n){  //返回一个作为分子或分母的数字
         Random rd = new Random();
         StringBuilder sb = new StringBuilder(n);
         sb.append(rd.nextInt(9)+1);
         for (int i = 1; i <n; i++){
             sb.append(rd.nextInt(10));
         }
         return sb;
    }
}

