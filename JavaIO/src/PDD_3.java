/*
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PDD_3{

    public class node{
        int weight;
        int number;
        node(int weight,int number){
            this.weight=weight;
            this.number=number;
        }
    }
    public void canFinish(int numCourses, int[][] prerequisites,int[] weight) {
        int num = 0;//已经成功学习的课程的数量
        PriorityQueue<node> zod=new PriorityQueue<>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                if(o1.weight>o2.weight)
                    return 1;
                else if(o1.weight==o2.weight){
                    if(o1.number>o2.number)
                        return 1;
                    else
                        return -1;
                }else
                    return -1;

            }
        });
        //LinkedList<Integer> zod = new LinkedList<Integer>();
        int[] outDegree = new int[numCourses];
        //动态二维数组用araylist  记住要初始化
        ArrayList<ArrayList<Integer>> preNode = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            ArrayList<Integer> a=new ArrayList<>();
            preNode.add(a);
        }
        //遍历 初始化preNode 和 outDegree
        for (int[] p : prerequisites) {
            preNode.get(p[1]).add(p[0]);
            outDegree[p[0]]++;
        }
        //初始化zod
        for (int i = 0; i < numCourses; i++) {
            if (outDegree[i] == 0) {
                node zero = new node(weight[i], i);
                zod.add(zero);
            }
        }

        while (!zod.isEmpty()) {
            int tmp = zod.peek().number;
            zod.remove(zod.peek());
            System.out.print(tmp);
            for (int i = 0; i < preNode.get(tmp).size(); i++) {
                if (--outDegree[preNode.get(tmp).get(i)] == 0) {
                    int number=preNode.get(tmp).get(i);
                    zod.add(new node(weight[number],number));
                }
            }
        }
        return;
    }

   */
/* public static void main(String[] args){
       Scanner keyboard = new Scanner(System.in);
       String content;
       String result = "";
       System.out.print("请输入内容:<空行或直接回车结束>");
       while(!(content = keyboard.nextLine()).trim().equals("")){
           result += content + System.lineSeparator();
           System.out.print("请输入内容:");
       }
       System.out.println("全部输入内容如下:");
       System.out.println(result);

       String [] results = result.split("\r\n");
       String [] N_M = results[0].split(" ");
       int N = Integer.parseInt(N_M[0]);
       int M = Integer.parseInt(N_M[1]);

       String [] N_Str = results[1].split(" ");
       int [] N_Num = new int[N_Str.length];
       for (int x = 0; x < N; x++){
            N_Num[x] = Integer.parseInt(N_Str[x]);
       }
       String [] M_Str = new String[M];
       int [] M_Num1 = new int[M];
       int [] M_Num2 = new int[M];
       for(int x = 0; x < M; x++){
            M_Str[x] = results[x + 2];
            String [] temp = M_Str[x].split(" ");
            M_Num1[x] = Integer.parseInt(temp[0]);
            M_Num2[x] = Integer.parseInt(temp[1]);
       }
       int [] temp = M_Num1;
       List<Integer> list_Num1 = IntStream.of(M_Num1).boxed().collect(Collectors.toList());
       List<Integer> list_Num2 = IntStream.of(M_Num2).boxed().collect(Collectors.toList());
    }*//*

   public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int N=sc.nextInt();
       int M=sc.nextInt();
       int[] weight=new int[N];
       for(int i=0;i<N;i++){
           weight[i]=sc.nextInt();
       }
       int [][] a=new int[M][2];
       for(int i=0;i<M;i++){
           a[i][1]=sc.nextInt();
           a[i][0]=sc.nextInt();
       }

       PDD_3 c=new PDD_3();
       c.canFinish(N,a,weight);
   }
}
*/
