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
    
    private static final String page_title = "Command_XML";
    
    private static boolean println;
    
    public static void Init(boolean java_ide){
        
        boolean ok = Home();
        
        println = java_ide;
        
        if(!ok){
            
            System.err.println(new Hora(true).TimerGood(false));
            System.err.println(new Data().DataCompleta(true));
            System.err.println("O valor deve ser \"null\" para poder ser iniciado!");
            System.exit(0);
            
        }//if(!ok)
        
    }//Init()
    
    private static boolean Home(){
        
        return Msg();
        
    }//Home()
    
    private static boolean Msg(){
        
        var valid = false;
        
        if(w == null){
            
            valid = true;
            
            var com = "n";
            
            if(Reg.modify.getDate().getDayOfWeek().getValue() < 6){
                
                com += "a";
                
            } else {//if(Reg.modify.getDate().getDayOfWeek().getValue() < 6)
                
                com += "o";
                
            }//if(Reg.modify.getDate().getDayOfWeek().getValue() < 6)
            
            com += " ";
            
            Data d = new Data();
            
            var good = "Bo";
            good += Hora.Good("m Dia", "a Tarde", "a Noite");
            good += "!";
            
            String tema;
            
            if(d.CompareTo(Reg.modify)){
                
                tema = "Última modificação;\nHoje; ";
                tema += Reg.modify.DataCompleta(",\nDia ","!\nAno ");
                tema += "!\n";
                tema += good;

            } else {//if(d.CompareTo(Reg.modify))
                
                tema = good;
                tema += "\nHoje é ";
                tema += d.DataCompleta(",\ndia ");
                tema += "!";
                
            }//if(d.CompareTo(Reg.modify))
            
            if(Reg.modify.CompareTo(d, false)){
                
                tema += "\nA última modificação desse projeto\nfoi feita ";
                tema += com;
                tema += Reg.modify.DataCompleta(",\ndia ");
                tema += "!";

            }//if(Reg.modify.CompareTo(d, false))
            
            if(d.CompareTo(Reg.modify, false)){

                tema += "\nSegundo o sistema:\nesse projet";
                tema += "o será atualizado no futuro!\nMai";
                tema += "s precisamente ";
                tema += com;
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
            
            w.Page_0("Command_XML", tema);
            
        }//if(w == null)
        
        return valid;
        
    }//Msg()
    
}
