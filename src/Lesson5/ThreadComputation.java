package Lesson5;

public class ThreadComputation {
    private static final int SIZE = 25_000_000;
    private static final int h = SIZE / 2;
    private static float[] arr = new float[SIZE];
    private static float[] arrThread = new float[SIZE];


    public static void main(String[] args) {

        arrFill(arr);
        arrFill(arrThread);

        arrCalc2Thread(arrThread);

        //arrCalcThread(arr);
        long startMainThread = System.nanoTime();
        arrCalc(arr, 0);
        System.out.println((System.nanoTime() - startMainThread) / 1_000_000_000.0 + " сек без разделения");

        long count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (arr[i] != arrThread[i]) {
                count++;
            }
        }
        System.out.println(count + " отличающихся значений");

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

    private static void arrCalcThread(float[] arr) {
        Thread t3 = new Thread(() -> {
            arrCalc(arr, 0);
        });
        long start = System.nanoTime();
        t3.start();
        if (t3.isAlive()) {
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println((System.nanoTime() - start) / 1_000_000_000.0 + " сек без разделения");
    }

    private static void arrCalc2Thread(float[] arr) {
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        long startThread1 = System.nanoTime();
        Thread t1 = new Thread(() -> {
            System.arraycopy(arr, 0, a1, 0, h);
            arrCalc(a1, 0);
            System.arraycopy(a1, 0, arr, 0, h);
        });
        Thread t2 = new Thread(() -> {
            System.arraycopy(arr, h, a2, 0, h);
            arrCalc(a2, h);
            System.arraycopy(a2, 0, arr, h, h);
        });
        t1.start();
        t2.start();
        if (t1.isAlive()) {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (t2.isAlive()) {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println((System.nanoTime() - startThread1) / 1_000_000_000.0 + " сек в 2 потока");
    }
}
