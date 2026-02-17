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
    
    public String obs = "Arquivo morto!";
    
    public String Title(boolean title);
    
    public String Input();
    
    public List<Domain> TableModel();
    
    public String TableTitle();
    
    public java.awt.Font ListFont();
    
    public String ButtonText();
    
    public Painel_2 Action(Action act, List<Domain> tema, String input);
    
}//Painel_2