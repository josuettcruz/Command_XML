/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package form;

import java.util.List;

/**
 *
 * @author joaot
 */
public interface Painel_3 {
    
    public String Title(boolean title);
    
    public Domain[] Mode();
    
    public java.awt.Font Font(boolean title);
    
    //15:55 08/03/2026
    public List<Domain> Painel3(
        pag3 op,
        List<Domain> menu,
        List<String> text,
        int col,
        int row
    );//Pendente
    
}
