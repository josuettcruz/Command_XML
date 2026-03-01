/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author josue
 */
public class controller {
    
    private static window doc;
    
    private static boolean position = false;
    private static int r = 0;
    private static int t = 0;
    private static int w = 0;
    private static int h = 0;
    
    public static void Position(int right, int top, int width, int height){
        
        position = true;
        r = right;
        t = top;
        w = width;
        h = height;
        
    }//Position(int right, int top, int width, int height)
    
    public static boolean Msg(String setTtitle, List<String> msg, boolean exit){
        
        var valid = true;
        
        List<String> value = new ArrayList();
        
        for(String com : msg){
            
            if(com.contains("\n")){
                
                value.addAll(Arrays.asList(com.split("\n")));
                
            } else {//if(com.contains("\n"))
                
                value.add(com);
                
            }//if(com.contains("\n"))
            
        }//for(String t : msg)
        
        List<String> text = new ArrayList();
        
        for(String myText : value){
            
            var com = txt.text(myText, true);
            
            if(!com.isBlank()) text.add(com);
            
        }//for(String myText : value)
        
        if(text.isEmpty() || text.size() > 10){
            
            valid = false;
            
        } else {//if(text.isEmpty() || text.size() > 10)
            
            try{

                var title = txt.title(setTtitle, true);

                if(title.isBlank()) title = new Link(Reg.http).page(false);

                if(doc == null){

                    doc = new window(
                        400,
                        200,
                        600,
                        200 + text.size() * 25
                    );

                }//if(w == null)

                doc.Page_0(title, text, exit);

            }catch(Exception err){
                
                System.err.println(Reg.Numb(err.hashCode()));
                System.err.println(err.getMessage());
                System.exit(0);
                
            }//throw
            
        }//if(text.isEmpty() || text.size() > 10)
        
        return valid;
        
    }//Msg(String setTtitle, List<String> msg, boolean exit)
    
    public static void p1s(Painel_1Single painel){
        
        try{
            
            if(doc == null && position){
                
                doc = new window(r, t, w, h);
                doc.Page_1Single(painel);
                
            } else if(doc == null){//if(doc == null && position)
                
                doc = new window();
                doc.Page_1Single(painel);
                
            } else {//if(doc == null && position)
                
                doc.Page_1Single(painel);
                
            }//if(doc == null && position)
            
        }catch(Exception err){

            System.err.println(Reg.Numb(err.hashCode()));
            System.err.println(err.getMessage());
            System.exit(0);

        }//throw
        
    }//P1s(Painel_1Single painel)
    
    public static void p1m(Painel_1Multiple painel){
        
        try{
            
            if(doc == null && position){
                
                doc = new window(r, t, w, h);
                doc.Page_1Multiple(painel);
                
            } else if(doc == null){//if(doc == null && position)
                
                doc = new window();
                doc.Page_1Multiple(painel);
                
            } else {//if(doc == null && position)
                
                doc.Page_1Multiple(painel);
                
            }//if(doc == null && position)
            
        }catch(Exception err){

            System.err.println(Reg.Numb(err.hashCode()));
            System.err.println(err.getMessage());
            System.exit(0);

        }//throw
        
    }//p1m(Painel_1Multiple painel)
    
    public static void p2(Painel_2 painel){
        
        try{
            
            if(doc == null && position){
                
                doc = new window(r, t, w, h);
                doc.Painel_2(painel);
                
            } else if(doc == null){//if(doc == null && position)
                
                doc = new window();
                doc.Painel_2(painel);
                
            } else {//if(doc == null && position)
                
                doc.Painel_2(painel);
                
            }//if(doc == null && position)
            
        }catch(Exception err){

            System.err.println(Reg.Numb(err.hashCode()));
            System.err.println(err.getMessage());
            System.exit(0);

        }//throw
        
    }//p2(Painel_2 painel)
    
}//controller