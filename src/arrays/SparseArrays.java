package arrays;

public class SparseArrays {
    public static void main(String[] args){
        int[][] array = new int[11][11];
        array[0][2] =  1;
        array[1][3] =  2;
        array[4][6] =  2;
        System.out.println("原二维数组");
        print2DArray(array);

        int[][] sparseArray = changeSparseArray(array,0);
        System.out.println("稀疏数组");
        print2DArray(sparseArray);

        int[][] returnArray = change2DArray(sparseArray);
        System.out.println("还原成的数组");
        print2DArray(returnArray);


    }

    /**
     * 将二维数组转成稀疏数组
     */
    public static int[][] changeSparseArray(int[][] array,int defaultValue){
        int sum = 0;
        for(int i=0; i<array.length;i++){
            for (int j=0;j< array[i].length;j++){
                if (array[i][j] != defaultValue){
                    sum++;
                }
            }
        }

        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;

        int count = 0;
        for(int i=0; i<array.length;i++){
            for (int j=0;j< array[i].length;j++){
                if (array[i][j] != defaultValue){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }
        return sparseArray;
    }

    /**
     * 将稀疏数组转成二维数组
     */
    public static int[][] change2DArray(int[][] array){
        int row = array[0][0];
        int col = array[0][1];
        int value = 0;
        int[][] array2D = new int[row][col];
        for (int i = 1; i < array.length; i++) {
            row = array[i][0];
            col = array[i][1];
            value = array[i][2];
            array2D[row][col] = value;
        }
        return array2D;
    }

    /**
     * 打印数组
     */
    public static void print2DArray(int[][] array){
        for (int[] row:array) {
            for (int data:row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }

    }

}
