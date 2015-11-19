/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemo;

/**
 *
 * @author andrea
 */
class ThreadController {

    private ThreadDemo view;
    private Thread thread0;
    private Thread thread1;

    ThreadController(ThreadDemo view) {
        this.view = view;
        this.view.setStopped(0);
        this.view.setStopped(1);
    }

    void runThread0() {
        // Create a new thread object
        thread0 = new Thread(new MyRunnable(view.getTextArea(0)));
        // Set view 0 to a new state
        view.setRunning(0);
        // Start running thread0
        thread0.start();
    }

    void stopThread0() {
        if (thread0 != null) {
            // Interrupt execution of thread0
            thread0.interrupt();
            // Set view 0 to a new state
            view.setStopped(0);
        }
    }

    void runThread1() {
        thread1 = new Thread(new MyRunnable2(view.getTextArea(1)));
        view.setRunning(1);
        thread1.start();
    }

    void stopThread1() {
        if(thread1 != null){
            thread1.interrupt();
            view.setStopped(1);
        }
    }
}
