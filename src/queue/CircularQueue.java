package queue;

public class CircularQueue {
    private int maxSize;
    private int front ;
    private int rear;
    private int[] arr;


    public CircularQueue(int num) {
        this.maxSize = num + 1;
        arr = new int[this.maxSize];
        front = 0;
        rear = 0;
    }

    private boolean isFull(){
        return (this.rear + 1) % this.maxSize == this.front;
    }

    private boolean isEmpty(){
        return this.front == this.rear;
    }

    /**
     * 往队列中添加数据
     * */
    public boolean addValue(int num){
        if (isFull()){
            System.out.println("队列已满，请勿再次添加数据");
            return false;
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
        return true;
    }

    /**
     * 从队列中取出数据
     * */
    public int getValue(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，未取得数据");
        }
        int result = arr[front];
        arr[front] = 0;
        front = (front+1)%maxSize;
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
        for (int i = this.front; i < front + (this.rear+this.maxSize-this.front)%this.maxSize; i++) {
            System.out.printf("arr[%d]=%d", i % this.maxSize , this.arr[i % this.maxSize]);
        }
    }

    /**
     * 显示队列头的数据
     * */
    public int showHead(){
        if(isEmpty()){
            throw new RuntimeException("队列为空，未取得数据");
        }
        return arr[front];
    }
}
