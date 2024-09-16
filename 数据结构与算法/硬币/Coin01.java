
    import java.math.BigInteger;
    import java.util.Scanner;

    public class Coin01 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int count = 0;
            for (int i = 0; i <= n*100; i++) {
                for (int j = 0; j <= n*50; j++) {
                    for (int k = 0; k <= n*20; k++) {
                        if(i+j*2+k*5==n*100){
                            count++;
                        }
                    }
                }
            }
            System.out.println(count);


        }

    }
//时间复杂度为