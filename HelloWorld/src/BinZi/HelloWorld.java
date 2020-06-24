package BinZi;

public class HelloWorld {
    public static void printMessage() {
        System.out.println("饼方法;");

    }

    public static double sum(double num) {
        if (num == 1) {
            return 1;
        }
        return fan(num) + sum(num - 1);
    }

    public static double fan(double num) {
        if (num == 1) {
            return 1;
        }
        return num * fan(num - 1);
    }

    public static int inc(int temp) {
        if (temp > 0) {
            return temp * 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int intNum = 10;
        System.out.println(intNum * intNum);
        int intMax = Integer.MAX_VALUE;
        int intMin = Integer.MIN_VALUE;
        System.out.println("----------");
        System.out.println(intMax + 1);
        System.out.println(intMin - 1);
        System.out.println("----------");
        char temp = 'a';
        int numTemp = temp;
        System.out.println(numTemp);

        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print(y + "*" + x + "=" + (x * y) + "\t");
            }
            System.out.println();
        }

        int line = 10;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < line - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        printMessage();
        System.out.println(sum(90));
        System.out.println((char) 68);
        boolean flag = 10 % 2 == 1 && 10 / 3 == 0 && 1 / 0 == 0;
        int num = 50;
        System.out.println(num++ * 2);
        int _Name = 100;
        int i = 1;
        int j = i++;
        if ((i == (++j)) && ((i++) == j)) {
            i += j;
        }
        System.out.println("i = " + i);

        int x = 10;
        double y = 20.2;
        long z = 10L;
        String str = "" + x + y * z;
        System.out.println(str);

        str = "";
        for (x = 0; x < 5; x++) {
            str += x;
        }
        System.out.println(str);
        int testNumber = 2147483647;
        testNumber += 2L;
        System.out.println(testNumber);

        System.out.println(inc(10) + inc(8) + inc(-10));
        int sum = 0;
        for (int a = 0; a < 10; a++) {
            sum += a;
            if (a % 3 == 0) {
                break;
            }
        }
        System.out.println(sum);
        float f = 1.3f;
    }
}
