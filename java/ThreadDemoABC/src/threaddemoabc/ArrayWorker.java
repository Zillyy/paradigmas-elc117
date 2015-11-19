package threaddemoabc;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author andrea
 */
public class ArrayWorker extends Thread {

    private SharedArray a;
    private int count;
    private char c;

    ArrayWorker(SharedArray a, int count, char c) {
        this.a = a;
        this.count = count;
        this.c = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            spendSomeTime();
            a.addChar(c);
        }
    }

    private void spendSomeTime() {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100; j++) {
            }
        }
    }
}
