package PipedStream;

import java.util.Scanner;

public class beike {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        long sum_up = 0;
        long sum_down = 0;

        int N=sc.nextInt();
        int[] weight=new int[N];

        for(int i = 0;i < N; i++){
            weight[i]=sc.nextInt();
        }
        int [] weight_up = weight;
        for(int i = 0; i < N - 1; i ++){
            if(weight_up[i] > weight_up[i+1]){
                sum_up+= (weight_up[i] + 1 - weight_up[i+1]);
                weight_up[i+1] = weight_up[i]+1;
            }
        }

        int [] weight_down = weight;
        for(int i = N-1; i >0; i--){
            if(weight_down[i] > weight_down[i-1]){
                sum_down+=(weight_down[i]+1 -weight_down[i-1]);
                weight_down[i-1] = weight_down[i] + 1;
            }
        }
        long [] sum = new long[N];
        for(int i = 1; i < N - 1; i++){
            int [] temp = weight;
            for(int m = 0; m < i; m++){
                if(temp[m] > temp[m+1]){
                    sum[i] += (temp[i] + 1 - temp[i+1]);
                    sum[i+1] = sum[i]+1;
                }
            }
            for(int n = N -1; n > i; n--){
                if(temp[n] > temp[n-1]){
                    sum[n] +=(temp[n]+1 -temp[n-1]);
                    temp[n-1] = temp[n] + 1;
                }
            }
        }
        long sum_min = getMin(sum);
        if(sum_min > sum_up){
            sum_min = sum_up;
        }
        if(sum_min>sum_down){

            sum_min = sum_down;
        }
        System.out.println(sum_min);
    }
    public static long getMin(long []arr){
        if(arr == null){
            return 0;
        }
        long min= arr[0];
        for(int i= 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
