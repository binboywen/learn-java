package SortAlg;

public class SortAlg {

    public static void main(String[] args)
    {
        int[] ins = {2,3,5,1,23,6,78,34,23,4,5,78,34,65,32,65,76,32,76,1,9};
        hillSort(ins);
        for(int in: ins){
            System.out.println(in);
        }
    }

    public static void bubbleSort(int [] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0 ; j < arr.length - 1 - i; j ++)
            {
                int temp ;
                if (arr[j] < arr[j + 1])
                {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectSort(int [] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j] < arr[min])
                {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void insertSort(int [] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; i++)
        {
            int value = arr[i];
            int j;
            for (j = i -1; j >= 0; j--)
            {
                if(value < arr[j])
                {
                    arr[j +1] = arr[j];
                }
                else
                {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    public static void hillSort(int [] arr)
    {
        int length = arr.length;

        int gap = length/2;
        while(gap > 0)
        {
            for (int i = gap; i < length; i++)
            {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] >tmp)
                {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j+gap] = tmp;
            }
            gap = gap /2;
        }

    }

    public static void mergeSort(int [] arr)
    {

    }

}
