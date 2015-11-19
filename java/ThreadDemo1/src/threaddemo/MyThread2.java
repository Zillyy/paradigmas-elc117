/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemo;

import java.util.Random;
import javax.swing.JTextArea;

/**
 *
 * @author Zilly
 */
class MyThread2 extends Thread {

    private JTextArea textArea2;
    private static final int SLEEP_MILLIS = 2000;

    public MyThread2(JTextArea textArea) {
        this.textArea2 = textArea;
    }

    public void run() {
        try {
            int rand = Random();
            int i = 0;
            while (true) {
                i += rand;
                textArea2.append("Counting: " + i + "\n");
                Thread.sleep(SLEEP_MILLIS);
                rand = Random();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread 1 interrupted!");
        }
    }

    public int Random() {
        Random gerador = new Random();
        return gerador.nextInt(300);
    }
}
