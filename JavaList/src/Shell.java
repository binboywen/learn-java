import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();
        int M = scanner.nextInt();
        int [][] a = new int[N][2];
        for(int i = 0; i < N; i++){
            a[i][0]=scanner.nextInt();
            a[i][1]=scanner.nextInt();
        }
        int count = 0;
        for(int i = 0; i < N; i++){
            if(a[i][1] > M)
                continue;
            if(M == 0)
                continue;
            int temp = M / a[i][1];
            if(temp <= a[i][0]){
                count += temp;
                M = M - temp * a[i][1];
            }else{
                count += a[i][0];
                M = M - a[i][0] * a[i][1];
            }
        }
        System.out.println(count);
    }
}
