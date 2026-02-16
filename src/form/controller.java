/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import model.*;
import xml_mf.config;

/**
 *
 * @author josue
 */
public class controller {
    
    private static window w = null;
    
    public static void Init(){
        
        Data d = new Data();
        
        if(Reg.modify.CompareTo(d, true)) Home();
        
        if(Reg.modify.CompareTo(d, false)) Msg();
        
    }//Init()
    
    private static void Home(){
        
        try{
            
            if(w == null) w = new window(100,100,600,600);
            w.Page_1(new config());
        
        } catch(Exception e) {
            
            if(Reg.java){
                
                System.err.println(e.hashCode());
                System.err.println(e.getMessage());
                
            }//if(println)
            
        }
        
    }//Home()
    
    private static void Msg(){
        
        if(w == null){
            
            var com = "n";
            
            if(Reg.modify.getDate().getDayOfWeek().getValue() < 6){
                
                com += "a";
                
            } else {//if(Reg.modify.getDate().getDayOfWeek().getValue() < 6)
                
                com += "o";
                
            }//if(Reg.modify.getDate().getDayOfWeek().getValue() < 6)
            
            com += " ";
            
            Data d = new Data();
            
            String tema;
            
            if(d.CompareTo(Reg.modify)){
                
                var node1 = Reg.modify.DataCompleta("#");
                var node2 = node1.indexOf("#");
                var node0 = node2 > 1 ? node2 : 1;
                
                tema = Reg.http;
                tema += "\n";
                tema += "_".repeat(node0 + 1);
                tema += "\n";
                tema += Reg.modify.DataCompleta("!\nDia ", "!\nAno de ");
                tema += "!";

            } else {//if(d.CompareTo(Reg.modify))
                
                tema = Hora.Good();
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
            
            w.Page_0(new Link(Reg.http).page(false), tema);
            
        } else if(Reg.java){//if(w == null)
            
            System.err.println(new Hora(true).TimerGood(false));
            System.err.println(new Data().DataCompleta(true));
            System.err.println("O valor deve ser \"null\" para poder ser iniciado!");
            System.exit(0);
            
        } else {//if(w == null)
            
            System.exit(0);
            
        }//if(w == null)
        
    }//Msg()
    
}//controller