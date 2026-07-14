/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.*;
import java.util.ArrayList;
import java.util.List;
import model.*;
import xml_rw.*;

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
            
            for(var i = 0; i < print.length && i < println.length; i++)
            {System.err.println(Reg.Tab(print[i],println[i],tab));}
            
        }//if(Reg.java)
        
        System.exit(0);
        
    }//Err(String message)
    
    public static void Init(){
        
        controller.PrintKey();
        controller.p1s(new config());
    
    }//Action()
    
    public final static String OverrideTitle(xml_document doc, boolean title){
        
        var c = doc.CreateDate();
        var m = doc.ModifyDate();
        var equal = c.CompareTo(m, true);
        
        var t = txt.text(txt.InputForm(doc.getTitle()));
        
        var val = "";
        
        if(title && !t.isBlank()){
            
            if(equal) val += "[";
            
            val += c.DataAbreviada(equal);
            
            if(equal){
                
                val += "]";
                
            } else {//if(equal)
                
                val += " --> ";
                
                val += m.DataAbreviada(true);
                
                val += "-->";
                
            }//if(equal)
            
            val += " ";
            val += t;
            
        } else if(!t.isBlank()){//if(title)
            
            var max_str = 32;
            
            if(equal){
                
                val += c.DataAbreviada(false);
                val += " ";
                
                max_str = 21;
            
            }//if(equal)
            
            var tm = txt.title(t, true).split(" ");
            
            if(tm[0].length() < max_str){
                
                var i = 0;
                var cont = 0;
                
                boolean loop;
                
                do{
                    
                    if(i > 0) val += " ";
                    
                    val += tm[i];
                    
                    cont += tm[i].length();
                    
                    loop = cont <= max_str;
                    
                    i++;
                    
                }while(i > 0 && i < tm.length && loop);
                
            } else {//if(tm[0].length() < max_str)
                
                var p = tm[0].toUpperCase();
                
                var i = 0;
                
                do{
                    
                    val += p.toUpperCase().charAt(i);
                    
                    i++;
                    
                }while(i > 0 && i < max_str && i < p.length());
                
            }//if(tm[0].length() < max_str)

        } else if(title){//if(title)
            
            val += Hora.Good();
            
        } else if(equal){//if(title)
            
            val += c.DataCompleta(false);
            
        } else {//if(title)
            
            val += c.DataAbreviada(true);
            val += " --> ";
            val += m.DataAbreviada(true);
            
        }//if(title)
        
        return val;
        
    }//OverrideTitle(xml_document doc, boolean title)
    
    public static void cancel_mouse(boolean mouse){
        
        if(mouse){
            
            System.exit(0);
            
        } else {//if(mouse)
            
            //code
            
        }//if(mouse)
        
    }//next modify paramters
    
    public static void session(
        boolean mouse,
        xml_document doc,
        xml_document_one one,
        String title,
        List<String> text
    )
    {
        
        //next code
        
    }//session
    
    public static List<String> session_ComboBox(Domain d, List<String> value, int row){
        
        if(value.isEmpty()){
            
            return new ArrayList();
            
        } else {//if(value.isEmpty())
            
            List<String> val = new ArrayList();
            
            for(var i = 0; i < value.size(); i++){
                
                String t = value.get(i);
                
                if(i == row && !txt.text(t).isBlank()){
                    
                    //fazer ação correspondente ao menu selectionado
                    
                    switch(d.index()){
                        
                        case 1 -> val.add(txt.text(t));
                        
                        case 2 -> {
                            
                            var c1 = new Data(t);
                            // Deve ser incluída novas opções de validação de
                            // DATA com entradas de String
                            // além das que já existem
                            // A principal ou até mesma a única deve ser:
                            // {dia} {nome do mes em ENG}. {ano}
                            
                            var c2 = new Hora(t);
                            
                            if(c1.Val()){
                                
                                val.add(c1.Load());
                                
                            } else if(c2.Val()){
                                
                                val.add(c2.Timer());
                                
                            } else {
                                
                                val.add(t);
                                
                            }
                            
                        }//case 2
                        
                        default -> val.add(t);
                        
                    }//switch(d.index())
                    
                } else {//if(i == row && !txt.text(t).isBlank())
                    
                    val.add(t);
                    
                }//if(i == row && !txt.text(t).isBlank())
                
            }//for(var i = 0; i < value.getText().size(); i++)
            
            return val;
            
        }//if(value.isEmpty())
        
    }//session_ComboBox
    
}//Action