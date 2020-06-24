import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PDD5 {
    public static void main(String [] args){
        long total = 1L;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        List<Integer> weight= new ArrayList<>();

        for(int i=0; i<N; i++){
            int temp =scanner.nextInt();
            weight.add(temp);
            total *= temp;
        }
        Collections.sort(weight);
        long sum = 1;
        float result = 0;
        for(int i = 1; i < weight.size() ; i++){
            long temp_forward = 1;
            for(int j = 0; j < i; j++){
                temp_forward *= doFactorial(weight.get(j));
            }
            long temp_backword = 1;
            temp_backword = weight.get(i)*(weight.size() - i) - temp_forward;
            long temp = temp_forward * temp_backword * weight.get(i);
            sum += temp;
        }
        result = sum / total;
        System.out.println(result);

    }
    public static int doFactorial(int n){
        if(n<0){
            return -1;
        }
        if(n==0){
            return 1;
        }else if(n==1){
            return 1;
        }else{
            return n*doFactorial(n-1);
        }
    }
}
