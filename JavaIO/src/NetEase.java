import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class NetEase {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++ ){
            array[i]=sc.nextInt();
        }
        int number = 0;
        boolean result;
        do{
            result = sort(array);
            number++;
        }while(result && number < array.length * array.length);

        for(int j = 0; j < array.length;j++){
            System.out.println(array[j]);
        }
    }
    static boolean sort(int [] arrayInt){
        for(int i = 0; i < arrayInt.length; i++ ){
            int minTemp = Integer.MAX_VALUE;
            int Temp =  arrayInt[i];
            for(int j = i + 1; j < arrayInt.length; j++){
                if((arrayInt[j] + arrayInt[i])%2 != 0 && arrayInt[j] < arrayInt[i]){
                    if(arrayInt[j] < Temp){
                        minTemp = j;
                    }
                }
            }
            if(minTemp != Integer.MAX_VALUE){
                swap(arrayInt,i,minTemp);
                return true;
            }
        }
        return false;
    }
    static void swap(int[] array, int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
