package Lesson5;

public class ThreadComputation {
    private static final int SIZE = 10_000_000;
    private static final int h = SIZE / 2;

    public static void main(String[] args) {

        float[] arr = new float[SIZE];
        float[] arrThread = new float[SIZE];
        float[] a1 = new float[h];
        float[] a2 = new float[h];


        arrFill(arrThread);
        Runnable r1 = () -> {
            System.out.println("Начало поток1");
            long startThread1 = System.currentTimeMillis();
            System.arraycopy(arrThread, 0, a1, 0, h);
            arrCalc(a1, 0);
            System.arraycopy(a1, 0, arrThread, 0, h);
            System.out.println((System.currentTimeMillis() - startThread1) / 1000.0 + " сек в потоке1");
        };
        Runnable r2 = () -> {
            System.out.println("Начало поток2");
            long startThread1 = System.currentTimeMillis();
            System.arraycopy(arrThread, h, a2, 0, h);
            arrCalc(a2, h);
            System.arraycopy(a2, 0, arrThread, h, h);
            System.out.println((System.currentTimeMillis() - startThread1) / 1000.0 + " сек в потоке2");
        };
        Runnable r3 = () -> {
            System.out.println("Начало поток3");
            arrFill(arr);
            long start = System.currentTimeMillis();
            arrCalc(arr, 0);
            System.out.println((System.currentTimeMillis() - start) / 1000.0 + " сек без потока");
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();





        /*int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (arr[i] != arrThread[i]) {
                count++;
            }
        }
        System.out.println(count);*/

    }

    private static void arrFill(float[] arr) {
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1f;
        }
    }

    private static void arrCalc(float[] arr, int startPos) {
        for (int i = startPos; i < arr.length + startPos; i++) {
            arr[i - startPos] = (float)(arr[i - startPos] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
    }
}
