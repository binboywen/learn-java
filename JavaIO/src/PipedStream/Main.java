package PipedStream;
import java.util.Scanner;

public class Main {
    public long maxAdd(int [] nums){
        long first=0,two=0;
        int[] a=new int[nums.length];
        long[] aa=new long[nums.length];
        int[] b=new int[nums.length];
        long[] bb=new long[nums.length];
        int maxCur=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxCur){
                maxCur=nums[i];
            }else{
                first+=(maxCur+1-nums[i]);
                maxCur+=1;
            }
            a[i]=maxCur;
            aa[i]=first;
        }
        maxCur=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>maxCur){
                maxCur=nums[i];
            }else{
                two+=(maxCur+1-nums[i]);
                maxCur+=1;
            }
            b[i]=maxCur;
            bb[i]=two;
        }
        long re=Math.min(bb[0],aa[nums.length-1]);
        long addCount=re;
        for(int i=1;i<nums.length-1;i++){
            addCount = Math.min(addCount,aa[i-1]+bb[i+1]+(a[i]>b[i]? a[i]-nums[i]:b[i]-nums[i]));
        }
        return addCount;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Main m=new Main();
        System.out.println(m.maxAdd(nums));
    }

}