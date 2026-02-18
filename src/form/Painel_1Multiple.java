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
public interface Painel_1Multiple {
    
    public String Title(boolean title);
    
    public String InputText(boolean user);
    
    public List<Domain> ListMode();
    
    public java.awt.Font ListFont();
    
    public boolean ListColumn();
    
    public Painel_1Multiple Action(pag1 action, List<Domain> vol, String input);
    
}//Painel_1Multiple