/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddemoabc;

import java.util.Arrays;

/**
 *
 * @author andrea
 */
public class SharedArray {

    private char[] array;
    private int index = 0;

    public SharedArray(int n) {
        array = new char[n];
        Arrays.fill(array, '-');
    }

    synchronized public void addChar(char c) {
        array[index] = c;
        spendSomeTime();
        index++;
    }

    public int countOccurrences(char c) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) {
                count++;
            }
        }
        return count;
    }

    private void spendSomeTime() {
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100; j++) {
            }
        }
    }

    @Override
    public String toString() {
        return String.valueOf(array);
    }
}
