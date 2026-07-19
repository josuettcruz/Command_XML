/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import model.Link;
import model.txt;

/**
 *
 * @author josue
 */
public class html_utf_8_characters {
    
    public static Link unicode = new Link(
        "https:" +
        "//www.w3schools.com/charsets/default.asp"
    );
    
    public static Link charsets = new Link(
        "https:" +
        "//www.w3schools.com/charsets/ref_html_entities_latin.asp"
    );
    
    private static String In(String dat){
        
        var val = "";
        
        switch(dat.toLowerCase()){
            
            case "nbsp", "#160", "#xa0" ->
            {val += " ";}
            
            case "amp", "#38", "#x26" ->
            {val += "&";}
            
            case "lt", "#60", "#x3c" ->
            {val += "<";}
            
            case "gt", "#62", "#x3e" ->
            {val += ">";}
            
            case "quot", "#34", "#x22" ->
            {val += "\"";}
            
            case "apos", "#39", "#x27" ->
            {val += "\'";}
            
            default -> {

                val += "{{";
                val += dat;
                val += "}}";

            }//default

        }//switch(dat)
        
        return val;
        
    }//In(String dat)
    
    private static String Out(char dat){
        
        String val = "&";
        
        var code = true;
                    
        switch(dat){
            
            case ' ' -> val += "nbsp";
            
            case '&' -> val += "amp";
            
            case '<' -> val += "lt";
            
            case '>' -> val += "gt";
            
            case '"' -> val += "quot";
            
            case '\'' -> val += "apos";
            
            default -> code = false;

        }//switch(value.charAt(p))
        
        val += ";";
        
        return code ? val : dat + "";
        
    }//Out(char dat)
    
    private static String Replace(String dat){
        
        var val = "&";
        
        switch(dat.toLowerCase()){
            
            case "nbsp", "#160", "#xa0" -> val += "nbsp";
            
            case "amp", "#38", "#x26" -> val += "amp";
            
            case "lt", "#60", "#x3c" -> val += "lt";
            
            case "gt", "#62", "#x3e" -> val += "gt";
            
            case "quot", "#34", "#x22" -> val += "quot";
            
            case "apos", "#39", "#x27" -> val += "apos";
            
            default -> val += dat;

        }//switch(dat)
        
        val += ";";
        
        return val;
        
    }//Replace(String dat)
    
    public static String InputForm(String value){
        
        if(txt.text(value, true).isBlank()){
            
            return "";
            
        } else {//if(txt.text(value, true).isBlank())
            
            var val = "";
            
            var dat = "";
            var symbol = false;
            
            for(var i = 0; i < value.length(); i++){
                
                switch(value.charAt(i)){
                    
                    case '&' ->{
                        
                        if(symbol){
                            
                            val += "&";
                            symbol = false;
                            
                        } else {//if(symbol)
                            
                            symbol = true;
                            
                        }//if(symbol)
                        
                    }//case '&'
                    
                    case ';' ->{
                        
                        if(symbol){
                            
                            val += In(dat);
                            dat = "";
                            symbol = false;
                            
                        } else {//if(symbol)
                            
                            val += value.charAt(i);
                            
                        }//if(symbol)
                        
                    }//case ';'
                    
                    default ->{
                        
                        if(symbol){
                            
                            dat += value.charAt(i);
                            
                        } else {//if(symbol)
                            
                            val += value.charAt(i);
                            
                        }//if(symbol)
                        
                    }//default
                    
                }//switch(form.charAt(i))
                
            }//for(var i = 0; i < form.length(); i++)
            
            return val;
            
        }//if(txt.text(value, true).isBlank())
        
    }//InputForm(String value)
    
    public static String OutputForm(String value){
        
        if(txt.text(value, true).isBlank()){
            
            return "";
            
        } else {//if(txt.text(value, true).isBlank())
            
            var open = 0;
            var close = 0;
            
            var symbol = "";
            var val = "";
            
            for(var i = 0; i < value.length(); i++){
                
                switch(value.charAt(i)){
                    
                    case ' ' -> val += Out(value.charAt(i));
                    
                    case '{' -> open++;
                    
                    case '}' ->{
                        
                        if(open == 2){
                            
                            close++;
                            
                        } else {//if(open == 2)
                            
                            if(open > 0){
                                
                                val += "{".repeat(open);
                                open = 0;
                                
                            }//if(open > 0)
                            
                            val += "}";
                            
                        }//if(open == 2)
                        
                    }//case '}'
                    
                    default ->{
                        
                        if(open == 2){
                            
                            symbol += value.charAt(i);
                            
                        } else if(close == 2){//if(open == 2)
                            
                            val += Replace(symbol);
                            
                            symbol = "";
                            close = 0;
                            
                        } else {//if(open == 2)
                            
                            if(open > 0) val += "{".repeat(open);
                            
                            if(close > 0) val += "}".repeat(close);
                            
                            val += Out(value.charAt(i));
                            
                            open = 0;
                            close = 0;
                            
                        }//if(open == 2)
                        
                    }//default
                    
                }//switch(form.charAt(i))
                
            }//for(var i = 0; i < form.length(); i++)
            
            if(open > 0) val += "{".repeat(open);
            
            if(close == 2){
                
                val += Replace(symbol);
                
            } else {//if(close == 2)
                
                if(close > 0) val += "}".repeat(close);
                
            }//if(close == 2)
            
            return val;
            
        }//if(txt.text(value, true).isBlank())
        
    }//OutputForm(String value)
    
}//html_utf_8_characters