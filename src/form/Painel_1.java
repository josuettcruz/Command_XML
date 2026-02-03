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
public interface Painel_1 {
    
    public String Title(boolean title);
    
    public String Font_Init();
    
    public String Font_Key();
    
    public List<String> List();
    
    public java.awt.Font ListFont();
    
    public int MaxListMode();
    
    public void Salvar(boolean button, int index);
    
    public void Apagar(boolean button);
    
    public void Adicionar(boolean button);
    
}
