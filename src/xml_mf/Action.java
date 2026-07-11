/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.*;
import model.*;

/**
 *
 * @author josue
 */
public class Action {
    
    public final static Domain[] session_option = {
        new Domain(1, "Ação 1"),
        new Domain(2, "Ação 2"),
        new Domain(3, "Ação 3"),
        new Domain(4, "Ação 4"),
        new Domain(5, "Ação 5"),
        new Domain(6, "Ação 6"),
        new Domain(7, "Ação 7"),
        new Domain(8, "Ação 8"),
        new Domain(9, "Ação 9"),
        new Domain(10, "Ação 10")
    };
    
    public final static void Err(String type, String message){
        
        if(Reg.java){
            
            String print[] = {
                new Data().DataAbreviada(true),
                new Hora(true).TimerGood(true),
                Hora.Good()
            };
            
            String println[] = {
                type,
                "Hove um erro no código do projeto!",
                message
            };
            
            var tab = 0;
            
            for(String max : print)
            {tab = max.length() > tab ? max.length() : tab;}
            
            tab++;
            
            var cont = 0;
            
            while(cont < print.length && cont < println.length){
                
                System.err.println(
                    Reg.Tab(
                        print[cont],
                        println[cont],
                        tab
                    )
                );
                
                cont++;
                
            }//while(cont < print.length && cont < println.length)
            
        }//if(Reg.java)
        
        System.exit(0);
        
    }//Err(String message)
    
    public static void Init(){
        
        controller.p1s(new config());
    
    }//Action()
    
}//Action