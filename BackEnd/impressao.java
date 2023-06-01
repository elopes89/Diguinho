import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JButton;

import java.util.logging.Level;

public class impressao extends javax.swing.JFrame {

    public impressao() {
        initComponents();
    }
    
    @SupressWarnings("unchecked")
    
    private void initComponents() {
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
    }
    imprimir("C:\\Users\\Sofia\\Desktop\\testeDiguingo.txt");

    public void imprimir(String caminhoArquivo) {
        Desktop desktop = Desktop.getDesktop();
        
        
        try {
            File arquivoAImprimir = new File(caminhoArquivo);
            desktop.print(arquivoAImprimir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


// "C:\Users\Sofia\Desktop\testeDiguingo.pdf"
