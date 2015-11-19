/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemoabc;

import java.io.PrintStream;
import java.util.Arrays;

/**
 *
 * @author andrea
 */
public class ArrayManager {

    private static final int MaxWorkerChar = 20;
    private static final int MaxRuns = 50;
    private static final char[] WorkerMarks = {'A', 'B', 'C'};
    private SharedArray array;
    private int[] occurrences;

    public ArrayManager() {
        this.occurrences = new int[WorkerMarks.length];
        this.array = new SharedArray(MaxWorkerChar * WorkerMarks.length);
    }

    public void fillArrayConcurrently() {
        try {
            ArrayWorker[] threads = new ArrayWorker[WorkerMarks.length];
            for (int i = 0; i < WorkerMarks.length; i++) {
                threads[i] = new ArrayWorker(array, MaxWorkerChar, WorkerMarks[i]);
            }
            for (int i = 0; i < WorkerMarks.length; i++) {
                threads[i].start();
            }
            for (int i = 0; i < WorkerMarks.length; i++) {
                threads[i].join();
            }
            for (int i = 0; i < WorkerMarks.length; i++) {
                occurrences[i] = array.countOccurrences(WorkerMarks[i]);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public int[] getOccurrences() {
        return occurrences;
    }

    @Override
    public String toString() {
        String strOccur = "";
        for (int i = 0; i < WorkerMarks.length; i++) {
            strOccur += String.format("%c=%d ",
                    WorkerMarks[i], occurrences[i]);
        }
        return array.toString() + "\n" + strOccur + "\n";
    }

    public static void main(String[] args) {
        for (int i = 0; i < MaxRuns; i++) {
            ArrayManager m1 = new ArrayManager();
            ArrayManager m2 = new ArrayManager();
            m1.fillArrayConcurrently();
            m2.fillArrayConcurrently();
            if (!Arrays.equals(m1.getOccurrences(), m2.getOccurrences())) {
                System.out.printf("Run %d got different results:\n\n", i);
                System.out.println(m1);
                System.out.println(m2);
                System.exit(0);
            }
        }
        System.out.println("All runs produced the same result!");

    }
}
