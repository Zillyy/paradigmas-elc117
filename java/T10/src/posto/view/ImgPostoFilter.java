package posto.view;

import java.io.File;

/**
 *
 * @author Zilly
 */

//Filtro do FileChooser de imagens
public class ImgPostoFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public boolean accept(File file) {
        // Permite somente imagens .png ou .jpg
        return file.getAbsolutePath().endsWith(".png") || file.getAbsolutePath().endsWith(".jpg");
    }

    @Override
    public String getDescription() {
        return "Arquivo de imagem (*.png ou *.jpg)";
    }
}
