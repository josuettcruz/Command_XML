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
public interface Painel_1Multiple {
    
    public String Title(boolean title);
    
    public String InputText(boolean user);
    
    public List<String> List();
    
    public java.awt.Font ListFont();
    
    public boolean ListColumn();
    
    public Painel_1Multiple Adicionar(boolean button, String input);
    
    public Painel_1Multiple Abrir(
        boolean button,
        int index,
        String name,
        String input
    );
    
    public Painel_1Multiple Apagar(
        boolean button,
        int index,
        String name,
        String input
    );
    
}
