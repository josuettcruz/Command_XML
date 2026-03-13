/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package form;

import java.util.List;

/**
 *
 * @author josue
 */
public interface Painel_3 {
    
    public String Title(boolean title);
    
    public String InputText();
    
    public java.awt.Font FontTitle();
    
    public List<String> TextArea();
    
    public java.awt.Font TextAreaFont();
    
    //public TextCursor TexAreaCursor();
    
    public Domain[] Mode();
    
    public void Painel3(
        int key_code,
        char key_char,
        Domain[] menu,
        String input,
        List<String> text,
        int row,
        int col
    );
    
    public void Painel3(
        pag3 op,
        Domain[] menu,
        String input,
        List<String> text,
        int row,
        int col
    );
    
}//Painel_3