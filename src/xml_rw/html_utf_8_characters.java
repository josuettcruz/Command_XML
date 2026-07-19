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
    
    /*private static String Out(char dat){
        
        String val = "";
                    
        switch(dat){
            
            case ' ' -> val += "&nbsp;";
            
            case '&' -> val += "&amp;";
            
            case '<' -> val += "&lt;";
            
            case '>' -> val += "&gt;";
            
            case '"' -> val += "&quot;";
            
            case '\'' -> val += "&apos;";
            
            default -> val += dat;

        }//switch(value.charAt(p))
        
        return val;
        
    }//Out(char dat)
    
    private static String Out(String dat, boolean utf){
        
        var val = "";
                            
        // https://www.w3schools.com/charsets/ref_html_entities_latin.asp
        switch(dat.toLowerCase()){
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=160&ent=nbsp
            case "nbsp", "#160", "#xa0" ->
            {val += utf ? "&nbsp;" : " ";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=38&ent=amp
            case "amp", "#38", "#x26" ->
            {val += utf ? "&amp;" : "&";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=60&ent=lt
            case "lt", "#60", "#x3c" ->
            {val += utf ? "&lt;" : "<";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=62&ent=gt
            case "gt", "#62", "#x3e" ->
            {val += utf ? "&gt;" : ">";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=34&ent=quot
            case "quot", "#34", "#x22" ->
            {val += utf ? "&quot;" : "\"";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=39&ent=apos
            case "apos", "#39", "#x27" ->
            {val += utf ? "&apos;" : "'";}
            
            default -> {

                val += "&";
                val += dat;
                val += ";";

            }//default

        }//switch(dat)
        
        return val;
        
    }//Out(String dat, boolean utf)
    
    public static String InputForm(String value){
        
        var val = "";
        
        if(!txt.text(value).isBlank()){
            
            var dat = "";
            
            var open_num = 0;
            var open_val = false;
            
            var close_num = 0;
            var close_val = false;
            
            for(int p = 0; p < value.length(); p++){
                
                var ds = value.charAt(p);
                
                switch(ds){
                    
                    case '￿', '' -> {}
                    
                    case ' ' -> val += ds;
                    
                    case '{' -> {
                        
                        if(open_val){
                            
                            val += "{{{";
                            open_val = false;
                            open_num = 0;
                            
                        } else if(open_num >= 2){//if(open_val)
                            
                            open_val = true;
                            open_num = 0;
                            
                        } else {//if(open_val)
                            
                            open_num++;
                            
                        }//if(open_val)
                    
                    }//case '{'
                    
                    case '}' -> {
                        
                        if(open_val && close_val){
                            
                            val += Out(dat, true);
                            dat = "";
                            
                            open_val = false;
                            close_val = false;
                            
                            open_num = 0;
                            close_num = 0;
                            
                        } else if(open_val){//if(open_val && close_val)
                            
                            if(close_val){
                                
                                val += "}}}";
                                
                            } else if(close_num >= 2){//if(close_val)
                                
                                close_val = true;
                                close_num = 0;
                                
                            } else {//if(close_val)
                                
                                close_num++;
                                
                            }//if(close_val)
                            
                        } else {//if(open_val && close_val)
                            
                            val += Out(ds);
                            
                        }//if(open_val && close_val)
                        
                    }//case '}'
                    
                    default ->{
                        
                        if(open_val){
                            
                            dat += ds;
                            
                        } else {//if(open_val)
                            
                            val += Out(ds);
                            
                        }//if(open_val)
                        
                    }//default
                    
                }//switch(ds)
                
            }//for(int p = 0; p < value.length(); p++)
            
        }//if(!txt.text(val).isBlank())
        
        return val;
        
    }//InputForm(String value)
    
    public static String OutputForm(String value){
        
        var val = "";
        
        if(!txt.text(value).isBlank()){
            
            var dat = "";
            var quot = false;
            
            for(int p = 0; p < value.length(); p++){
                
                switch(value.charAt(p)){
                    
                    case '￿', '' -> {}
                    
                    case '&' ->{//if(quot) - 1 - 3
                        
                        if(quot){
                            
                            val += "&";
                            
                        } else {//if(quot) - 1 - 3
                            
                            quot = true;
                            
                        }//if(quot) - 1 - 3
                        
                    }//case '&'
                    
                    case ';' -> {
                        
                        if(quot){//if(quot) - 2 - 3
                            
                            val += Out(dat, false);
                            dat = "";
                            quot = false;
                            
                        } else {//if(quot) - 2 - 3
                            
                            val += ";";
                            
                        }//if(quot) - 2 - 3
                        
                    }//case ';'
                    
                    case ' ' ->{
                        
                        if(!quot) val += " ";
                    
                    }//case ' '
                    
                    default ->{//if(quot) - 3 - 3
                        
                        if(quot){
                            
                            dat += value.charAt(p);
                            
                        } else {//if(quot) - 3 - 3
                            
                            val += value.charAt(p);
                            
                        }//if(quot) - 3 - 3
                        
                    }//default
                    
                }//switch(value.charAt(p))
                
            }//for(int p = 0; p < value.length(); p++)
            
        }//if(!txt.text(val).isBlank())
        
        return val;
        
    }//OutputForm(String value)*/
    
    private static String In(String dat){
        
        var val = "";
                            
        // https://www.w3schools.com/charsets/ref_html_entities_latin.asp
        switch(dat.toLowerCase()){
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=160&ent=nbsp
            case "nbsp", "#160", "#xa0" ->
            {val += " ";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=38&ent=amp
            case "amp", "#38", "#x26" ->
            {val += "&";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=60&ent=lt
            case "lt", "#60", "#x3c" ->
            {val += "<";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=62&ent=gt
            case "gt", "#62", "#x3e" ->
            {val += ">";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=34&ent=quot
            case "quot", "#34", "#x22" ->
            {val += "\"";}
            
            // https://www.w3schools.com/charsets/tryit.asp?deci=39&ent=apos
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
        
    }
    
    public static String InputForm(String value){
        
        var form = txt.text(value, true);
        
        if(!form.isBlank()){
            
            return "";
            
        } else {//if(!form.isEmpty())
            
            var val = "";
            
            var dat = "";
            var symbol = false;
            
            for(var i = 0; i < form.length(); i++){
                
                switch(form.charAt(i)){
                    
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
                            
                            val += form.charAt(i);
                            
                        }//if(symbol)
                        
                    }//case ';'
                    
                    default ->{
                        
                        if(symbol){
                            
                            dat += form.charAt(i);
                            
                        } else {//if(symbol)
                            
                            val += form.charAt(i);
                            
                        }//if(symbol)
                        
                    }//default
                    
                }//switch(form.charAt(i))
                
            }//for(var i = 0; i < form.length(); i++)
            
            return val;
            
        }//if(!form.isEmpty())
        
    }//InputForm(String value)
    
    public static String OutputForm(String value){
        
        var form = txt.text(value, true);
        
        if(!form.isBlank()){
            
            return "";
            
        } else {//if(!form.isEmpty())
            
            var open = 0;
            var close = 0;
            
            var symbol = "";
            var val = "";
            
            for(var i = 0; i < form.length(); i++){
                
                switch(form.charAt(i)){
                    
                    case '{' -> open++;
                    
                    case '}' ->{
                        
                        if(open == 2){
                            
                            close++;
                            open = 0;
                            
                        } else {//if(open == 2)
                            
                            if(open > 0) val += "{".repeat(open);
                            
                            val += "}";
                            
                        }//if(open == 2)
                        
                    }//case '}'
                    
                    default ->{
                        
                        if(open == 2 && close == 0){
                            
                            symbol += form.charAt(i);
                            
                        } else if(close == 2){//if(open == 2 && close == 0)
                            
                            val += Replace(symbol);
                            symbol = "";
                            
                        } else {//if(open == 2 && close == 0)
                            
                            if(open > 0) val += "{".repeat(open);
                            
                            if(close > 0) val += "}".repeat(close);
                            
                            val += Out(form.charAt(i));
                            
                        }//if(open == 2 && close == 0)
                        
                    }//default
                    
                }//switch(form.charAt(i))
                
            }//for(var i = 0; i < form.length(); i++)
            
            return val;
            
        }//if(!form.isEmpty())
        
    }//OutputForm(String value)
    
}//html_utf_8_characters