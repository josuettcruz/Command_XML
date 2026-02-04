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
        
        if(text.trim().isBlank()) text = "null";
        
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
                
                case '\t', '\f', '￿' ->{
                    
                    if(remove_char){
                        
                        if(digit)
                        space = true;
                        
                    } else {//if(remove_char)
                        
                        txt += text.charAt(i);
                        
                    }//if(remove_char)
                    
                }//case '\t', '\f', '￿'
                
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
    
    public static List<String> phrase(String text, boolean remove_char){
        
        if(text.trim().isBlank()) text = "null";
        
        List<String> tem = new ArrayList();
        
        var txt = "";
        var space = false;
        
        var z = 0;
        var loop = true;
        
        do{
            
            switch(text.charAt(z)){
                
                case '\n', ' ' ->{
                    
                    if(space){
                        
                        tem.add(txt);
                        txt = "";
                        space = false;
                        
                    }//if(space)
                    
                }//case '\n', ' '
                
                case '\t', '\f', '￿' ->{
                    
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
                    
                }//case '\t', '\f', '￿'
                
                default ->{
                    
                    txt += text.charAt(z);
                    space = true;
                    
                }//default
                
            }//switch(text.charAt(z))
            
            z++;
            
        }while(z > 0 && z < text.length() && loop); 
        
        if(space) tem.add(txt);
        
        return tem;
        
    }//phrase(String text, boolean remove_char)
    
    public static String capitalize(String phrase){
        
        if(phrase.trim().isBlank()) phrase = "null";
        
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
                        
                    case '￿' -> {}
                        
                    default ->{
                        
                        txt += phrase.toUpperCase().charAt(p);
                        cap = false;
                        
                    }
                    
                }//switch(phrase.charAt(p))
                
            } else {//if(cap)
                
                txt += phrase.toLowerCase().charAt(p);
                
            }//if(cap)
            
        }//for(int p = 0; p < phrase.length(); p++)
        
        return txt;
        
    }//capitalize(String phrase)
    
    public static String title(String text, boolean remove_char){
        
        if(text.trim().isBlank()) text = "null";
        
        String[] articles = {
            "com",
            "sem",
            "se",
            "sim",
            "não",
            "nao",
            "ao",
            "aos",
            "às",
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
                
                do{
                    
                    if(
                        p.toLowerCase()
                         .replace(":", "")
                         .replace(";", "")
                         .replace(",", "")
                         .replace(".", "")
                         .replace("!", "")
                         .equalsIgnoreCase(
                                articles[t]
                         )
                    )
                    {
                        
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
        
    }//title(String text, boolean remove_char)
    
    public static String arq(String text){
        
        var txt = "";
        
        var line = false;
        
        var caracter = false;
        
        for(String p : phrase(text, true)){
            
            if(line){
                
                txt += "-";
                
            } else {//if(line)
                
                line = true;
                
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
                        
                    case '\n',
                         '\t',
                         '\f',
                         '\\',
                         '\'',
                         '/',
                         '|',
                         ':',
                         ';',
                         '?',
                         '!',
                         '@',
                         '#',
                         '$',
                         '%',
                         '¨',
                         '&',
                         '*',
                         '+',
                         '=',
                         '§',
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
                         '"',
                         '_',
                         '￿' -> caracter = true;
                    
                    default -> {
                        
                        if(caracter && i > 0){
                            
                            txt += "_";
                            caracter = false;
                            
                        }//if(caracter)
                        
                        txt += p.toLowerCase().charAt(i);
                        
                    }//default
                    
                }//switch(p.charAt(i))
                
            }//for(int i = 0; i < p.length(); i++)
            
        }//for(String p : phrase(true))
        
        return txt;
        
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
            'z',
            '￿'
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
    
    public static String Local(String loc){
        
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
                     '"' -> {
                    
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
        
    }//Local(String loc)
    
}