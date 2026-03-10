/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package form;

import java.util.List;
import javax.swing.text.Caret;

/**
 *
 * @author josue
 */
public interface Painel_3 {
    
    public String Title();
    
    public java.awt.Font FontTitle();
    
    public java.awt.Font TextAreaFont();
    
    public List<String> TextArea();
    
    public TextCursor TexAreaCursor();
    
    public Domain[] Mode();
    
    public boolean Painel3(
        int key_code,
        char key_char,
        Domain[] menu,
        List<String> text,
        int row,
        int col
    );
    
    public void Painel3(
        pag3 op,
        Domain[] menu,
        List<String> text,
        int row,
        int col
    );
    
}
