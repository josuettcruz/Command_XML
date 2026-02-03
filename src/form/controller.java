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
        
        boolean execute;
        
        if(w == null){
            
            var title = "Hoje é ";
            title += Reg.modify.DataCompleta(true);
            
            w = new window(200,100,600,600);
            w.Page_1(title, Reg.modify.DataAbreviada(true));
            
            execute = true;
            
        } else if(println){//if(w == null && new Data().CompareTo(Reg.modify))
            
            execute = Msg();
            
        } else {//if(w == null && new Data().CompareTo(Reg.modify))
            
            execute = false;
            
        }//if(w == null && new Data().CompareTo(Reg.modify))
        
        return execute;
        
    }//Home()
    
    public static void HomeEnter(){
        
        if(println){
            
            Reg.Print(
                new Hora(true).TimerGood(true),
                new Data().DataCompleta(true),
                39
            );
            
        }//if(println)
        
        System.exit(0);
        
    }//Home_Enter()
    
    public static void HomeClear(){
        
        var hour = new Hora(true).TimerGood(true);
        
        if(println){
            
            Reg.Print(
                new Data().DataAbreviada(true),
                hour,
                39 - hour.length()
            );
            
        }//if(println)
        
        System.exit(0);
        
    }//Exit()
    
    public static void HomeFile(String file){
        
        if(println){
            
            var homefilehour = "Bo";
            homefilehour += Hora.Good("m Dia", "a Tarde", "a Noite");
            homefilehour += "!";
            
            var homefileprint = "No momento não existe nenuma ação para ser executada!";
            
            if(!file.isBlank()) homefileprint = txt.title(file, true);
            
            Reg.Print(new Hora(true).TimerGood(false), new Data().DataCompleta(true));
            Reg.Print(homefilehour, homefileprint);
            
        }//if(println)
        
        System.exit(0);
        
    }
    
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
                
                tema = "Última modificação:\nHoje, ";
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
