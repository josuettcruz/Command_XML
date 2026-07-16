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
        new Domain(1, "Condicionar todo o texto"),
        new Domain(2, "Condicionar Texto"),
        new Domain(3, "Predefinir DATA/HORA"),
        new Domain(4, "Separas por frase"),
        new Domain(5, "Separar por textos da frase"),
        new Domain(6, "Ação 5"),
        new Domain(7, "Ação 6"),
        new Domain(8, "Ação 7"),
        new Domain(9, "Ação 8"),
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
    
    public static void session_cancel(boolean mouse, xml_document doc, xml_document_one one){
        
        // Deve ser criada uma nova classe
        // que servirá para confirmar ou cancelar
        // a ação que ira apagar todo o formulário
        
        System.exit(0);
        
    }//next modify paramters
    
    public static void session(
        boolean mouse,
        xml_document doc,
        xml_document_one one,
        String new_title
    )
    {
        
        //next code
        
    }//session
    
    public static List<String> session_ComboBox(Domain d, List<String> value, int row){
        
        if(value.isEmpty()){
            
            return new ArrayList();
            
        } else if(d.index() == 1){
            
            List<String> aplication = new ArrayList();
            
            for(String val : value) aplication.add(txt.text(val, true));
            
            return aplication;
            
        } else {//if(value.isEmpty())
            
            List<String> val = new ArrayList();
            
            for(var i = 0; i < value.size(); i++){
                
                String t = value.get(i);
                
                if(i == row && !txt.text(t).isBlank()){
                    
                    //fazer ação correspondente ao menu selectionado
                    
                    switch(d.index()){
                        
                        case 2 -> val.add(txt.text(t));
                        
                        case 3 -> {
                            
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
                            
                        }//case 3
                        
                        case 4 -> {
                            
                            var rd = "";
                            
                            for(String r : txt.phrase(value.get(i))){
                                
                                if(!rd.isBlank()) rd += " ";
                                
                                rd += r;
                                
                                if(r.length() > 1){
                                    
                                    switch(r.charAt(r.length()-1)){
                                        
                                        case '.', '!', '?' -> {
                                            
                                            val.add(rd);
                                            rd = "";
                                            
                                        }//case '.', '!', '?'
                                        
                                    }//switch(r.charAt(r.length()-1))
                                    
                                }//if(r.length() > 1)
                                
                            }//for(String r : txt.phrase(value.get(i)))
                            
                        }//case 4
                        
                        case 5 -> {
                            
                            var rd = "";
                            
                            for(String r : txt.phrase(value.get(i))){
                                
                                if(!rd.isBlank()) rd += " ";
                                
                                rd += r;
                                
                                if(r.length() > 1){
                                    
                                    switch(r.charAt(r.length()-1)){
                                        
                                        case '.', '!', '?', ';', ',' -> {
                                            
                                            val.add(rd);
                                            rd = "";
                                            
                                        }//case '.', '!', '?'
                                        
                                    }//switch(r.charAt(r.length()-1))
                                    
                                }//if(r.length() > 1)
                                
                            }//for(String r : txt.phrase(value.get(i)))
                            
                        }//case 5
                        
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