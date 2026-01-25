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
    private static boolean init = false;
    
    public static boolean Msg(){
        
        if(init){
            
            return false;
            
        } else {//if(init)
            
            var com = Reg.modify.getDate().getDayOfWeek().getValue() < 6;
            
            Data d = new Data();
            
            var tema = "Bo";
            tema += Hora.Good("m Dia", "a Tarde", "a Noite");
            tema += "!\nHoje é ";
            tema += d.DataCompleta(",\ndia ");
            tema += "!";
            
            if(Reg.modify.CompareTo(d, false)){
                
                tema += "\nA última modificação desse projeto foi feit";
                tema += com ? "a na " : "o no ";
                tema += Reg.modify.DataCompleta(",\n");
                tema += "!";

            }//if(Reg.modify.CompareDay(d, false))
            
            if(d.CompareTo(Reg.modify, false)){

                tema += "\nSegundo o sistema: esse projet";
                tema += "o será atualizado no futuro!\nMai";
                tema += "s precisamente n";
                tema += com ? "a " : "o ";
                tema += Reg.modify.DataCompleta(",\ndia ");
                tema += "!";

            }//if(d.CompareDay(Reg.modify, false))
            
            w = new window(
                400,
                200,
                600,
                200 + (
                    txt.text(
                        tema,
                        true
                    ).split("\n").length * 25
                )
            );
            
            w.Title("Command_XML");
            w.Command(tema);
            
            init = true;
            
            return true;
            
        }//if(init)
        
    }//Msg()
    
    public static boolean Function(){
        
        if(init){
            
            /* 15:02 25/01/2026
            **  Verificar se o formulário
            **  window foi iniciado!
            **
            ** Só executar função se o mesmo for iniciado!
            **
            */
            
        }//if(init)
        
        return init;
        
    }//Function()
    
}
