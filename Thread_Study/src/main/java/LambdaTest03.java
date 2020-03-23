/**
 * lambda推导+参数+返回值
 */
public class LambdaTest03 {

    public static void main(String[] args) {
        IInterest interest=(int a,int b)->{
            System.out.println("I like lambda -->" + (a - b));
            return a-b;
        };
        System.out.println(interest.lambda(100, 50));

        //简化
         interest= (a, b)-> a-b;
        System.out.println(interest.lambda(100, 20));
    }
}

interface IInterest{
    int lambda(int a,int b);
}

//外部类
class Interest implements IInterest {

    @Override
    public int  lambda(int a,int b) {
        System.out.println("I like lambda -->"+a+":"+b);
        return a-b;
    }
}