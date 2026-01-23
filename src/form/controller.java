/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;
import model.Data;
import model.Hora;

/**
 *
 * @author josue
 */
public class controller {
    
    private static window w = null;
    
    public static void init(){
        
        Data d = new Data();
        
        w = new window();
        w.Title(d.DataAbreviada(true));
        w.Tem_0("Hoje é " + d.DataCompleta(",\ndia ") + "\nBo" + Hora.Good("m Dia", "a Tarde", "a Noite") + "!");
        
    }//controller()
    
}
