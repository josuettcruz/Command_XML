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
public interface Painel_1 {
    
    public String obs = "FUNIONANDO";
    
    public String Title(boolean title);
    
    public String InputText(boolean user);
    
    public List<String> List();
    
    public java.awt.Font ListFont();
    
    public boolean ListColumn();
    
    public Painel_1 Adicionar(boolean button, String input);
    
    public Painel_1 Abrir(
        boolean button,
        int index,
        String name,
        String input
    );
    
    public Painel_1 Apagar(
        boolean button,
        int index,
        String name,
        String input
    );
    
}//Painel_1