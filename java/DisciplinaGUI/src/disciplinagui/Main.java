/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package disciplinagui;

import javax.swing.SwingUtilities;
import disciplinagui.model.TableModelDisciplina;
import disciplinagui.view.DisciplinaView;

/**
 *
 * @author andrea
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		new DisciplinaView().setVisible(true);
	    }
	});
    }

}
