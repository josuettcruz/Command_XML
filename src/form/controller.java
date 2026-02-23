/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import model.*;
import xml_mf.config;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author josue
 */
public class controller {
    
    private static window w;
    
    public static void Init(){
        
        Home();
        
    }//Init()
    
    private static void Home(){
        
        try{
            
            if(w == null) w = new window(100,100,600,600);
            w.Painel_2(new config());
        
        } catch(Exception e) {
            
            String err = "Exception\n";
            err += e.getMessage().replace("\"", "\n");
            err += "\n-- ";
            err += Reg.Numb(e.hashCode());
            err += " --";
            
            if(
                e.getLocalizedMessage() != null
                && e.getLocalizedMessage().equalsIgnoreCase(err)
            )
            {
                
                err += e.getLocalizedMessage();
                
            }//if(e.getLocalizedMessage() != null && e.getLocalizedMessage()...
            
            if(Reg.java){
                
                for(String message : txt.text(err, true).split("\n")){
                    System.err.println(message);
                }
                
            }//if(println)
            
        }
        
    }//Home()
    
    public static boolean Msg(String setTtitle, List<String> msg){
        
        var valid = true;
        
        List<String> value = new ArrayList();
        
        for(String t : msg){
            
            if(t.contains("\n")){
                
                value.addAll(Arrays.asList(t.split("\n")));
                
            } else {//if(t.contains("\n"))
                
                value.add(t);
                
            }//if(t.contains("\n"))
            
        }//for(String t : msg)
        
        List<String> text = new ArrayList();
        
        for(String myText : value){
            
            var t = txt.text(myText, true);
            
            if(!t.isBlank()) text.add(t);
            
        }//for(String myText : value)
        
        if(text.isEmpty() || text.size() > 10){
            
            valid = false;
            
        } else {//if(text.isEmpty() || text.size() > 10)
            
            var title = txt.title(setTtitle, true);
            
            if(title.isBlank()) title = new Link(Reg.http).page(false);
            
            if(w == null){
                
                w = new window(
                    400,
                    200,
                    600,
                    200 + text.size() * 25
                );
                
            }//if(w == null)
            
            w.Page_0(title, text);
            
        }//if(text.isEmpty() || text.size() > 10)
        
        return valid;
        
    }//Msg(String setTtitle, List<String> msg)
    
    public static void p1s(Painel_1Single painel){
        
        if(w == null) w = new window();
        w.Page_1Single(painel);
        
    }//P1s(Painel_1Single painel)
    
    public static void p1m(Painel_1Multiple painel){
        
        if(w == null) w = new window();
        w.Page_1Multiple(painel);
        
    }//p1m(Painel_1Multiple painel)
    
    public static void p2(Painel_2 painel){
        
        if(w == null) w = new window();
        w.Painel_2(painel);
        
    }//p2(Painel_2 painel)
    
}//controller