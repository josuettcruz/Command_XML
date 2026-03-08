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
    
    public Domain[] Mode();
    
    public java.awt.Font Font(boolean title);
    
    public List<Domain> Painel3(
        pag3 op,
        Domain[] menu,
        List<String> text,
        int cursor
    );
    
}
