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
    
    public void Adicionar(boolean button, String input);
    
    public void Abrir(
        boolean button,
        int index,
        List<String> lt,
        String input
    );
    
    public void Apagar(
        boolean button,
        int index,
        List<String> lt,
        String input
    );
    
}//Painel_1Single