/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package form;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author joaot
 */
public interface Painel_1 {
    
    public String Title(boolean title);
    
    public String Font_Init();
    
    public String Font_Key();
    
    public String[] List();
    
    public void Salvar();
    
    public void Limpar();
    
    public void Adicionar(boolean button);
    
}
