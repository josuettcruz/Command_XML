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
public interface Painel_1Single {
    
    public String Title(boolean title);
    
    public String InputText();
    
    public List<String> List();
    
    public java.awt.Font ListFont();
    
    public boolean ListColumn();
    
    public void Button(pag1 action, int index, List<String> vol, String input);
    
}//Painel_1Single