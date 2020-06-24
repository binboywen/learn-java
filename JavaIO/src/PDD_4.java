import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PDD_4 {
    public class node{
        int weight;
        int number;
        public node(int weight,int number){
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
            System.out.print(tmp+1);
            for (int i = 0; i < preNode.get(tmp).size(); i++) {
                if (--outDegree[preNode.get(tmp).get(i)] == 0) {
                    int number=preNode.get(tmp).get(i);
                    zod.add(new node(weight[number],number));
                }
            }
        }
        return;
    }

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
            a[i][1]=sc.nextInt()-1;
            a[i][0]=sc.nextInt()-1;
        }
        PDD_4 c=new PDD_4();
        c.canFinish(N,a,weight);
    }
}
