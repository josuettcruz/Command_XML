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
    
    public String InputText(boolean user);
    
    public List<String> List();
    
    public java.awt.Font ListFont();
    
    public boolean ListColumn();
    
    public Painel_1Single Adicionar(boolean button, String input);
    
    public Painel_1Single Abrir(
        boolean button,
        int index,
        String name,
        String input
    );
    
    public Painel_1Single Apagar(
        boolean button,
        int index,
        String name,
        String input
    );
    
}//Painel_1