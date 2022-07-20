package JavaTestDemo;

/**
 * @ClassName IfDemo
 * @Description TODO
 * @Author yangfan
 * @Date 2021/12/31 14:07
 */
public class IfDemo {
    public static void main(String args[]){
        int x;
        int y;
        x = 10;
        y = 20;
        if (x < y)
            System.out.println("x的值为" + x + "，y的值为 " + y +"，x小于y");
        x = x*2;
        if(x == y)
            System.out.println("x的值为" + x + "，y的值为 " + y +"，x等于y");
        x = x*2;
        if(x > y)
            System.out.println("x的值为" + x + "，y的值为 " + y +"，x大于y");
        else
            System.out.println("这个条件不满足，不会被输出");
    }

}
