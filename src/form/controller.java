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
        
        var com = Reg.modify.getDate().getDayOfWeek().getValue() < 6;
        
        Data d = new Data();
        
        var height = 255;
        
        var tema = "\nBo";
        tema += Hora.Good("m Di", "a Tarde", "a Noite");
        tema += "!\nHoje é ";
        tema += d.DataCompleta(",\ndia ");
        tema += "!";
        
        if(Reg.modify.CompareTo(d, false)){
            
            height += 50;
            
            tema += "\nA última modificação desse projeto foi feit";
            tema += com ? "a na " : "o no ";
            tema += Reg.modify.DataCompleta(",\n");
            tema += ".";
            
        }//if(Reg.modify.CompareDay(d, false))
        
        if(d.CompareTo(Reg.modify, false)){
            
            height += 100;
            
            tema += "\nSegundo o sistema:\nEsse projet";
            tema += "o será atualizado no futuro!\nMai";
            tema += "s precisamente n";
            tema += com ? "a " : "o ";
            tema += Reg.modify.DataCompleta(",\ndia ");
            tema += "!";
            
        }//if(d.CompareDay(Reg.modify, false))
        
        w = new window(400,200,570,height);
        w.Title(Reg.categories + " -> " + Reg.choose);
        w.Tem_0(tema);
        
    }//controller()
    
}
