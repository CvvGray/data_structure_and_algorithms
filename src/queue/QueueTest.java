package queue;

import java.util.Scanner;

public class QueueTest {
    public static void main(String[] args) {
        //创建普通队列实例
        //OrdinaryQueue queue = new OrdinaryQueue(3);

        //创建循环队列实例
        CircularQueue queue = new CircularQueue(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean flag = true;
        System.out.println("s,显示队列");
        System.out.println("e,退出程序");
        System.out.println("a,添加数据到队列中");
        System.out.println("g,从对列中取出数据");
        System.out.println("h,查看队列头的数据");
        while (flag){
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    queue.showValue();
                    break;
                case 'e':
                    System.out.println("程序结束");
                    flag = false;
                    break;
                case 'a':
                    System.out.println("请输入加入队列的值");
                    int num = scanner.nextInt();
                    boolean success = queue.addValue(num);
                    System.out.println(success?"添加成功":"添加失败");
                    break;
                case 'g':
                    try {
                        int value = queue.getValue();
                        System.out.println("从队列中取出的数据为" + value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = queue.showHead();
                        System.out.println("从队列中取出的数据为" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
