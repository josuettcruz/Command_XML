/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;
import model.*;

/**
 *
 * @author josue
 */
public class controller {
    
    private static window w = null;
    
    public static void init(){
        
        Data d = new Data();
        
        var tema = "\nBo";
        tema += Hora.Good("m Di", "a Tarde", "a Noite");
        tema += "!\nHoje é ";
        tema += d.DataCompleta(",\ndia ");
        tema += "!";
        
        if(Reg.modify.CompareDay(d, false)){
            
            tema += "\nA última modificação foi feita\n";
            tema += Reg.modify.DataCompleta(",\ndia ");
            tema += "!";
            
        }//if(Reg.modify.CompareDay(d, false))
        
        w = new window();
        w.Title(d.DataAbreviada(true));
        w.Tem_0(tema);
        
    }//controller()
    
}
