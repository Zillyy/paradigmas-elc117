/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemo;

import javax.swing.JTextArea;

/**
 *
 * @author andrea
 */
class MyRunnable implements Runnable {

    private JTextArea textArea;
    private static final int SLEEP_MILLIS = 1000;
    

    public MyRunnable(JTextArea textArea) {
        this.textArea = textArea;       
    }

    public void run() {
        try {
            int i = 0;
            while (true) {
                textArea.append("Counting: " + i + "\n");
                Thread.sleep(SLEEP_MILLIS);
                i++;
            }
        } catch (InterruptedException e) {
            System.out.println("Thread 0 interrupted!");
        }
    }
}
