/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class txt {
    
    public static String text(String text, boolean remove_char){
        
        var txt = "";
        
        var line = false;
        var space = false;
        var digit = false;
        
        for(int i = 0; i < text.length(); i++){
            
            switch(text.charAt(i)){
                
                case ' ' ->{
                    
                    if(digit)
                    space = true;
                    
                }//case ' '
                
                case '\t', '\f', '￿', '' ->{
                    
                    if(remove_char){
                        
                        if(digit)
                        space = true;
                        
                    } else {//if(remove_char)
                        
                        txt += text.charAt(i);
                        
                    }//if(remove_char)
                    
                }//case '\t', '\f', '￿', ''
                
                case '\n' ->{
                    
                    if(digit)
                    line = true;
                    
                }//case '\n'
                
                default -> {
                    
                    if(line){
                        
                        txt += "\n";
                        txt += text.charAt(i);
                        
                    } else if(space){//if(line)
                        
                        txt += " ";
                        txt += text.charAt(i);
                        
                    } else {//if(line)
                        
                        txt += text.charAt(i);
                        
                    }//if(line)
                    
                    digit = true;
                    space = false;
                    line = false;
                    
                }//default
                
            }//switch(text.charAt(i))
            
        }//for(int i = 0; i < text.length(); i++)

        return txt;
        
    }//text(String text, boolean remove_char)
    
    public static String text(String text, char[] exclude){
        
        var value = "";
        
        if(!text.isBlank() && exclude.length > 0){
            
            final var space = " ";
            
            String val = "";
            
            for(int p = 0; p < text.length(); p++){
                
                char ds = text.charAt(p);
                
                if(exclude.length == 1){
                    
                    if(ds == exclude[0]){
                        
                        val += space;
                        
                    } else {//if(ds == exclude[0])
                        
                        val += ds;
                        
                    }//if(ds == exclude[0])
                    
                } else {//if(exclude.length == 1)
                    
                    var proc = 0;
                    var loop = true;
                    
                    do{
                        
                        if(ds == exclude[proc]){
                            
                            val += space;
                            loop = false;
                            
                        }//if(ds == exclude[proc])
                        
                        proc++;
                        
                    }while(loop && proc > 0 && proc < exclude.length);
                    
                    if(loop) val += ds;
                    
                }//if(exclude.length == 1)
                
            }//for(int p = 0; p < text.length(); p++)
            
            value = text(val, true);
        
        }//if(!text.isBlank())
        
        return value;
        
    }//text(String text, char[] exclude)
    
    public static String text(String text){
        
        final char[] exclude = {'_','-'};
        
        return text(text, exclude);
        
    }//text(String text)
    
    public static List<String> phrase(String text, boolean remove_char){
        
        List<String> tem = new ArrayList();
        
        if(text.trim().isBlank()){
            
            tem.add("");
            
        } else {//if(text.trim().isBlank())
            
            var txt = "";
            var space = false;
            
            var z = 0;
            
            do{
                
                switch(text.charAt(z)){
                    
                    case '\n', ' ' ->{
                        
                        if(space){
                            
                            tem.add(txt);
                            txt = "";
                            space = false;
                            
                        }//if(space)
                        
                    }//case '\n', ' '
                    
                    case '\t', '\f', '￿', '' ->{
                        
                        if(remove_char){
                            
                            if(space){
                                
                                tem.add(txt);
                                txt = "";
                                space = false;
                                
                            }//if(space)
                            
                        } else {//if(remove_char)
                            
                            txt += text.charAt(z);
                            space = true;
                            
                        }//if(remove_char)
                        
                    }//case '\t', '\f', '￿', ''
                    
                    default ->{
                        
                        txt += text.charAt(z);
                        space = true;
                        
                    }//default
                    
                }//switch(text.charAt(z))
                
                z++;
                
            }while(z > 0 && z < text.length()); 
            
            if(space) tem.add(txt);
            
        }//if(text.trim().isBlank())
        
        return tem;
        
    }//phrase(String text, boolean remove_char)
    
    public static List<String> phrase(String text, char[] exclude){
        
        var value = new ArrayList();
        
        if(!text.isBlank() && exclude.length > 0){
            
            final var space = " ";
            
            String val = "";
            
            for(int p = 0; p < text.length(); p++){
                
                char ds = text.charAt(p);
                
                if(exclude.length == 1){
                    
                    if(ds == exclude[0]){
                        
                        val += space;
                        
                    } else {//if(ds == exclude[0])
                        
                        val += ds;
                        
                    }//if(ds == exclude[0])
                    
                } else {//if(exclude.length == 1)
                    
                    var proc = 0;
                    var loop = true;
                    
                    do{
                        
                        if(ds == exclude[proc]){
                            
                            val += space;
                            loop = false;
                            
                        }//if(ds == exclude[proc])
                        
                        proc++;
                        
                    }while(loop && proc > 0 && proc < exclude.length);
                    
                    if(loop) val += ds;
                    
                }//if(exclude.length == 1)
                
            }//for(int p = 0; p < text.length(); p++)
            
            value.addAll(phrase(val, true));
        
        }//if(!text.isBlank())
        
        return value;
        
    }//phrase(String text, char[] exclude)
    
    public static List<String> phrase(String text){
        
        final char[] exclude = {'_','-'};
        
        return phrase(text, exclude);
        
    }//List<String> phrase(String text)
    
    public static String capitalize(String phrase){
        
        if(phrase.trim().isBlank()) phrase = "Classe: \"TXT\"\nPacote: \"MODEL\"";
        
        if(phrase.trim().isBlank()){
            
            return "";
            
        } else {//if(phrase.trim().isBlank())
            
            var txt = "";
            
            var cap = true;
            
            for(int p = 0; p < phrase.length(); p++){
                
                if(cap){
                    
                    switch(phrase.charAt(p)){
                        
                        case ' ',
                            '\t',
                            '\n',
                            '\f',
                            '\\',
                            '\'',
                            '"',
                            '/',
                            '(',
                            ')',
                            '[',
                            ']',
                            '{',
                            '}',
                            '0',
                            '1',
                            '2',
                            '3',
                            '4',
                            '5',
                            '6',
                            '7',
                            '8',
                            '9',
                            '-',
                            '_' -> txt += phrase.charAt(p);
                            
                        case '￿', '' -> {}
                        
                        default ->{
                            
                            txt += phrase.toUpperCase().charAt(p);
                            cap = false;
                            
                        }
                        
                    }//switch(phrase.charAt(p))
                    
                } else {//if(cap)
                    
                    txt += phrase.toLowerCase().charAt(p);
                    
                }//if(cap)
                
            }//for(int p = 0; p < phrase.length(); p++)
            
            return phrase.isBlank() ? "" : txt;
            
        }//if(phrase.trim().isBlank())
        
    }//capitalize(String phrase)
    
    public static String title(String text, boolean remove_char){
        
        if(text.trim().isBlank()) text = "Classe: \"TXT\"\nPacote: \"MODEL\"";
        
        if(text.trim().isBlank()){
            
            return "";
            
        } else {//if(text.trim().isBlank())
            
            String[] articles = {
                "no",
                "na",
                "nos",
                "nas",
                "um",
                "uma",
                "uns",
                "umas",
                "dois",
                "duas",
                "de",
                "do",
                "da",
                "dos",
                "das",
                "pôs",
                "pos",
                "após",
                "apos",
                "os",
                "as",
                "às",
                "em",
                "ue",
                "ué",
                "uè",
                "uê"
            };
            
            var txt = "";
            
            var note = true;
            
            for(String p : phrase(text, remove_char)){
                
                if(note){
                    
                    txt += capitalize(p);
                    note = false;
                    
                } else if(p.length() == 1){//if(note)
                    
                    txt += " ";
                    txt += p.toLowerCase();
                    
                } else {//if(note)
                    
                    txt += " ";
                    
                    boolean article = true;
                    int t = 0;
                    
                    var node = "";
                    
                    for(int i = 0; i < p.length(); i++){
                        
                        switch(p.toLowerCase().charAt(i)){
                            
                            case ':',
                                 ';',
                                 ',',
                                 '.',
                                 '!',
                                 '?',
                                 '-' ->{}
                            
                            default -> node += p.toLowerCase().charAt(i);
                            
                        }//switch(p.toLowerCase().charAt(i))
                        
                    }//for(int i = 0; i < p.length(); i++)
                    
                    do{
                        
                        if(node.equalsIgnoreCase(articles[t])){

                            txt += p.toLowerCase();
                            article = false;

                        }//if(p.equalsIgnoreCase(articles[t]))

                        t++;

                    }while(t > 0 && t < articles.length && article);

                    if(article)
                    txt += capitalize(p);

                }//if(note)

            }//for(String p : phease(true))

            return txt;

        }//if(text.trim().isBlank())
        
    }//title(String text, boolean remove_char)
    
    public static String arq(String text){
        
        if(text.trim().isBlank()) text = "Classe: \"TXT\"\nPacote: \"MODEL\"";
        
        var txt = "";
        
        var space = false;
        var demo = true;
        
        for(String p : phrase(text, true)){
            
            if(space){
                
                if(demo) txt += "-";
                
            } else {//if(line)
                
                space = true;
                
            }//if(line)
            
            for(int i = 0; i < p.length(); i++){
                
                switch(p.toLowerCase().charAt(i)){
                    
                    case 'a',
                         'à',
                         'á',
                         'ã',
                         'â',
                         'ä',
                         'ª' -> txt += "a";
                         
                    case 'c',
                         'ç' -> txt += "c";
                            
                    case 'e',
                         'é',
                         'è',
                         'ê',
                         'ë' -> txt += "e";
                            
                    case 'i',
                         'í',
                         'ì',
                         'î',
                         'ï' -> txt += "i";
                            
                    case 'o',
                         'ó',
                         'ò',
                         'õ',
                         'ô',
                         'ö',
                         'º' -> txt += "o";
                            
                    case 'u',
                         'ú',
                         'ù',
                         'û',
                         'ü' -> txt += "u";
                            
                    case 'y',
                         'ý' -> txt += "y";
                        
                    case '_',
                        '\n',
                        '\t',
                        '\f',
                        '\\',
                        '\'',
                         '"',
                         '-',
                         '/',
                         '|',
                         ':',
                         ';',
                         '?',
                         '!',
                         '@',
                         '#',
                         '*',
                         '&',
                         '$',
                         '§',
                         '₢',
                         '%',
                         '¨',
                         '+',
                         '=',
                         '`',
                         '´',
                         '^',
                         '~',
                         '<',
                         '>',
                         '.',
                         ',',
                         '¹',
                         '²',
                         '³',
                         '£',
                         '¢',
                         '¬',
                         '[',
                         ']',
                         '{',
                         '}',
                         '(',
                         ')',
                         '￿',
                         '' -> {
                        
                        if(i > 0 && i < p.length()-1 && demo) txt += "_";
                        demo = false;
                        
                    }
                    
                    default -> {
                        
                        txt += p.toLowerCase().charAt(i);
                        demo = true;
                        
                    }//default
                    
                }//switch(p.charAt(i))
                
            }//for(int i = 0; i < p.length(); i++)
            
        }//for(String p : phrase(true))

        return text.isBlank() ? "" : txt;
        
    }//arq(String text)
    
    private static boolean minus(String text, String less_than){
        
        long min = 0L;
        long max = 0L;
        
        char[] alphabet = {
            '_',
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9',
            'a',
            'b',
            'c',
            'd',
            'e',
            'f',
            'g',
            'h',
            'i',
            'j',
            'k',
            'l',
            'm',
            'n',
            'o',
            'p',
            'q',
            'r',
            's',
            't',
            'u',
            'w',
            'y',
            'x',
            'z'
        };
        
        for(int smaller = 0; smaller < text.length(); smaller++){
            
            int sum = 0;
            boolean loop = true;
            
            do{
                
                if(text.charAt(smaller) == alphabet[sum]){
                    
                    min = (min * (long)alphabet.length) + (long)sum;
                    loop = false;
                    
                }//if(text.charAt(smaller) == alphabet[sum])
                
                sum++;
                
            }while(sum > 0 && sum < alphabet.length && loop);
            
            if(loop) min = (min*(long)alphabet.length) + (long)alphabet.length;
            
        }//for(int smaller = 0; smaller < text.length(); smaller++)
        
        for(int bigger = 0; bigger < less_than.length(); bigger++){
            
            int sum = 0;
            boolean loop = true;
            
            do{
                
                if(less_than.charAt(bigger) == alphabet[sum]){
                    
                    max = (max * (long)alphabet.length) + (long)sum;
                    loop = false;
                    
                }//if(less_than.charAt(bigger) == alphabet[sum])
                
                sum++;
                
            }while(sum > 0 && sum < alphabet.length && loop);
            
            if(loop) max = (max*(long)alphabet.length) + (long)alphabet.length;
            
        }//for(int bigger = 0; bigger < less_than.length(); bigger++)
        
        return min < max;
        
    }//minus(String text, String less_than)
    
    public static boolean min(String text,String less_than){
        
        try{
            
            return minus(text,less_than);
            
        }catch(Exception e){
            
            return false;
            
        }
        
    }//min(String text,String less_than)
    
    private static String txtLocal(String loc){
        
        var txt = "";
        var i = 0;
        var l = 0;
        var val = true;
        var space = false;
        
        do{
            
            switch(loc.charAt(i)){
                
                case ' ' ->{
                    
                    if(i > 0 && !txt.isBlank()){
                        
                        space = true;
                        
                    }//if(i > 0 && !txt.isBlank())
                    
                }//case ' '
                
                case '\n',
                     '\f',
                     '\t',
                     '\\',
                     '|',
                     '/',
                     ':',
                     '<',
                     '>',
                     '{',
                     '}',
                     '[',
                     ']',
                     'ª',
                     'º',
                     '\'',
                     '"',
                     '￿',
                     '' -> {
                    
                    if(l >= 2){
                        
                        val = false;
                        
                    } else {//if(txt.length() >= 2)
                        
                        txt += "_";
                        
                    }//if(txt.length() >= 2)
                    
                }//cases
                
                default ->{
                    
                    l++;
                    
                    if(space){
                        
                        txt += " ";
                        space = false;
                        
                    }//if(space)
                    
                    txt += loc.charAt(i);
                    
                }//default
                
            }//switch(loc.charAt(i))
            
            i++;
            
        }while(i > 0 && i < loc.length() && val);
        
        if(i >= 2 && i <= 10 && l > 1){
            
            return txt;
            
        } else {//if(i >= 2)
            
            return "run";
            
        }//if(i >= 2)
        
    }//txtLocal(String loc)
    
    public static String Local(String text){
        
        return text.trim().isBlank() ? "" : txtLocal(text.trim());
        
    }//Local(String loc)
    
    private static String Out(char dat){
        
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
            case "nbsp", "#160", "#xA0" ->
            {val += utf ? "&nbsp" : " ";}
            
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
    
    public static String OutputForm(String value){
        
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
                    
                    case ' ' -> val += ds;
                    
                    case '{' -> {
                        
                        if(open_val){
                            
                            val += "{{{";
                            open_val = false;
                            
                        } else if(open_num >= 2){//if(open_val)
                            
                            open_val = true;
                            
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
                            
                        } else if(open_val){//if(open_val && close_val)
                            
                            if(close_val){
                                
                                val += "}}}";
                                
                            } else if(close_num >= 2){//if(close_val)
                                
                                close_val = true;
                                
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
        
    }//OutputForm(String value)
    
    public static String InputForm(String value){
        
        var val = "";
        
        if(!txt.text(value).isBlank()){
            
            var dat = "";
            var quot = false;
            
            for(int p = 0; p < value.length(); p++){
                
                switch(value.charAt(p)){
                    
                    case '&' ->{
                        
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
                    
                    default ->{
                        
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
        
    }//InputForm(String value)
    
}//txt