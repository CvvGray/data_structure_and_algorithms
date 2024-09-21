package queue;

public class OrdinaryQueue {
    private int maxSize;
    private int front ;
    private int rear;
    private int[] arr;


    public OrdinaryQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    private boolean isFull(){
        return rear == maxSize -1;
    }

    private boolean isEmpty(){
        return front == rear;
    }

    /**
     * 往队列中添加数据
     * */
    public boolean addValue(int num){
        if (isFull()){
            System.out.println("队列已满，请勿再次添加数据");
            return false;
        }
        rear++;
        arr[rear] = num;
        return true;
    }

    /**
     * 从队列中取出数据
     * */
    public int getValue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，未取得数据");
        }
        front++;
        int result = arr[front];
        arr[front] = 0;
        return result;
    }

    //以上模拟队列已经完成，后面的方法都是测试用的


    /**
     * 显示队列中的所有数据
     * */
    public void showValue(){
        if(isEmpty()){
            System.out.println("队列为空，未取得数据");
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("arr[%d]=%d\t",i,arr[i]);
        }

    }

    /**
     * 显示队列头的数据
     * */
    public int showHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，未取得数据");
        }
        return arr[front + 1];
    }

}
