import java.util.Scanner;

public class Main{

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int seed=scanner.nextInt();
        if(seed*1234==0){
            System.out.println("请重新输入seed");
            seed=scanner.nextInt();
        }

        //第一轮
        int result=roll(seed);
        System.out.println("结果为:"+result);
        switch(result){
            case 7:
                System.out.println("获胜");
                return ;
            case 11:
                System.out.println("获胜");
                return ;
            case 2:
                System.out.println("败");
                return ;
            case 3:
                System.out.println("失败");
                return ;
            case 12:
                System.out.println("失败");
                return ;
            default:break;
        }

        while(true){
            int p=result;
            seed=seedcount(seed);
            result=roll(seed);
            System.out.println("结果为:"+result);
            if(result==7){
                System.out.println("失败");
                return;
            }else if(result==p){
                System.out.println("获胜");
                return;
            }


        }




    }





    static int roll(int seed){
        if (seed*1234==0){
        }
        int result1=(seed*1234%6)+1;
        seed=(seed*1234)%100;
        int result2=(seed*1234%6)+1;
        return result1+result2;
    }

    static int seedcount(int seed){
        seed=(1234*seed)%100;
        seed=(1234*seed)%100;
        return seed;
    }
}