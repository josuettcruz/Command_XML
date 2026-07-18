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
        new Domain(0, "Selecione uma opção!"),
        new Domain(1, "Condicionar todo o texto."),
        new Domain(2, "Condicionar Texto."),
        new Domain(3, "Predefinir DATA/HORA"),
        new Domain(4, "Separas por frase."),
        new Domain(5, "Separar por textos da frase.")
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
        
        var t = txt.title(doc.getTitle(), true);
        
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
    
    public static void session_cancel(
        boolean mouse,
        xml_document doc,
        xml_document_one one
    )
    {
        
        // Deve ser criada uma nova classe
        // que servirá para confirmar ou cancelar
        // que ira apagar o formulário!
        
        System.exit(0);
        
    }//session_cancel
    
    public static void session(
        boolean mouse,
        xml_document doc,
        xml_document_one one,
        String new_title
    )
    {
        
        //next code
        
    }//session
    
    private static int month_ComboBox(String value){
        
        final String month[] = {
            "jan",
            "fev",
            "mar",
            "abr",
            "mai",
            "jun",
            "jul",
            "ago",
            "set",
            "out",
            "nov",
            "dez"
        };
        
        var val = -1;
        
        if(txt.text(value).isBlank()){
            
            val = 0;
            
        } else {//if(txt.text(value).isBlank())
            
            var tx = txt.arq(value);
            var tm = "";
            var charAt = 0;
            
            var cont = 0;
            
            var loop = true;
            
            do{
                
                var co = 0;
                var intern_loop = true;
                
                do{
                    
                    if(charAt < month[co].length()){
                        
                        if(tx.charAt(charAt) == month[co].charAt(charAt)){
                            
                            tm += tx.charAt(charAt);
                            charAt++;
                            
                            intern_loop = false;
                            
                        }//if(tx.charAt(cont) == month[co].charAt(cont))
                        
                    } else {//if(charAt < month[co].length())
                        
                        loop = false;
                        
                    }//if(charAt < month[co].length())
                    
                    co++;
                    
                }while(intern_loop && co > 0 && co < month.length);
                
                cont++;
                
            }while(loop && cont > 0 && cont < tx.length());
            
            if(tm.length() >= 3){
                
                cont = 0;
                
                loop = true;
                
                do{
                    
                    if(tm.equalsIgnoreCase(month[cont])){
                        
                        val = cont+1;
                        
                        loop = false;
                        
                    }//if(tm.equalsIgnoreCase(month[cont]))
                    
                    cont++;
                    
                }while(loop && cont > 0 && cont < month.length);
                
            }//if(tm.length() >= 3)
            
        }//if(txt.text(value).isBlank())
        
        return val;
        
    }//month_ComboBox(String val)
    
    public static List<String> session_ComboBox(
        Domain d,
        List<String> value,
        int row
    )
    {
        
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
                            
                            var c2 = new Hora(t);
                            
                            if(c1.Val()){
                                
                                val.add(c1.Load());
                                
                            } else if(c2.Val()){//if(c1.Val())
                                
                                val.add(c2.Timer());
                                
                            } else {//if(c1.Val())
                                
                                var day = 0;
                                var month = 0;
                                var year = 0;
                                
                                final char[] element = {
                                    '.',
                                    ',',
                                    ';'
                                };
                                
                                for(String tm : txt.phrase(t, element)){
                                    
                                    var dat = month_ComboBox(tm);
                                    
                                    var n = new Num(tm);
                                    
                                    if(dat > 0) month = dat;
                                    
                                    if(
                                        n.Val()
                                        && n.Num() > 0
                                        && n.Num() <= 31
                                    ) day = n.Num();
                                    
                                    if(
                                        n.Val()
                                        && n.Num() > 1972
                                        && n.Num() <= new Data()
                                            .getDate()
                                            .getYear()
                                    ) year = n.Num();
                                    
                                }//while(loop && cont > 0 && cont < tm.size());
                                
                                Data code = new Data(year, month, day);
                                
                                if(code.Val()){
                                    
                                    val.add(code.Load());
                                    
                                } else {//if(code.Val())
                                    
                                    val.add(t);
                                    
                                }//if(code.Val())
                                
                            }//if(c1.Val())
                            
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