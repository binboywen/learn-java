
class ArrayUtil{
    private int sum = 0;
    private double avg = 0.0;
    private int max ;
    private int min ;

    public static void sort(int data[]){
        for (int x = 0; x < data.length; x++){
            for (int y = 0; y < data.length - x -1; y++){
                if (data[y] > data[y + 1]){
                    int temp = data[y];
                    data[y] = data[y + 1];
                    data[y + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int temp[]) {
        for (int number:temp){
            System.out.println(number);
        }

    }
    public ArrayUtil(int data[]){

        this.max = data[0];
        this.min = data[0];

        for(int temp : data){
            this.sum += temp;
            if (temp > this.max){
                this.max = temp;
            }
            if (temp < this.min){
                this.min = temp;
            }

        }
        this.avg = this.sum / data.length;

    }

    public int getSum(){
        return this.sum;
    }
    public double getAvg() {
        return avg;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}

public class Array {
    public static void main(String [] args){
        int data [] = new int[] {2,5,1,3,4};
        for (int x = 0; x < data.length; x++){
            System.out.println(data[x]);
        }
        for (int temp : data){
            System.out.println(temp);
        }

        int array [][] = new int [][]{{1,2,3,4,5},{1,2,3},{5,6,7,8}};
        for (int x = 0; x < array.length; x++){
            for (int y = 0; y < array[x].length ; y++){
                System.out.println("array[" +x+"]["+y+"] = " + array[x][y]);
            }
            System.out.println();
        }

        for (int temp []: array){
            for(int number :temp){
                System.out.println(number + "、");
            }
            System.out.println();
        }
        ArrayUtil.printArray(data);

        ArrayUtil arrayTest = new ArrayUtil(data);
        System.out.println(arrayTest.getMax());
        System.out.println(arrayTest.getMin());
        System.out.println(arrayTest.getAvg());
        System.out.println(arrayTest.getSum());
        ArrayUtil.sort(data);
        ArrayUtil.printArray(data);


    }

    public static void arraycopy(int [] src, int sindex,int [] dsc , int dindex , int len){
        for (int x = 0; x < len; x++){
            dsc[dindex++] = src[sindex++];
        }
    }

}
