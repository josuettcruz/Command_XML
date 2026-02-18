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
public interface Painel_2 {
    
    public String Title(boolean title);
    
    public java.awt.Font ListFont();
    
    public List<Domain> ListMode();
    
    public Painel_2 Command(pag2 op, Domain value);
    
}//Painel_2