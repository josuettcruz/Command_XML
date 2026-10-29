/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.Texto to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Texto {
    
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
        
        final char[] exclude = {'_','|'};
        
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
        
        final char[] exclude = {'_','|'};
        
        return phrase(text, exclude);
        
    }//List<String> phrase(String text)
    
    public static String capitalize(String phrase){
        
        if(phrase.trim().isBlank())
        {phrase = "Classe: \"TXT\"\nPacote: \"MODEL\"";}
        
        if(phrase.trim().isBlank()){
            
            return "";
            
        } else {//if(phrase.trim().isBlank())
            
            var txt = "";
            
            var cap = true;
            
            for(int p = 0; p < phrase.length(); p++){
                
                if(cap){
                    
                    switch(phrase.charAt(p)){
                        
                        case '￿', '' -> {}
                        
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
                            '_'
                        -> txt += phrase.charAt(p);
                        
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
    
    public static String title(String text){
        
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
            
            for(String p : phrase(text, true)){
                
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
                    {txt += capitalize(p);}

                }//if(note)

            }//for(String p : phease(true))

            return txt;

        }//if(text.trim().isBlank())
        
    }//title(String text, boolean remove_char)
    
    public static String arq(String text){
        
        if(text.trim().isBlank())
        {text = "Classe: \"TXT\"\nPacote: \"MODEL\"";}
        
        var txt = "";
        
        var space = false;
        var demo = true;
        
        for(String p : phrase(text, true)){
            
            if(space){
                
                if(demo) txt += "_";
                
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
                         'ª' -> {
                        
                        txt += "a";
                        demo = true;
                        
                    }
                         
                    case 'c',
                         'ç' -> {
                        
                        txt += "c";
                        demo = true;
                        
                    }
                            
                    case 'e',
                         'é',
                         'è',
                         'ê',
                         'ë' -> {
                        
                        txt += "e";
                        demo = true;
                        
                    }
                            
                    case 'i',
                         'í',
                         'ì',
                         'î',
                         'ï' -> {
                        
                        txt += "i";
                        demo = true;
                        
                    }
                            
                    case 'o',
                         'ó',
                         'ò',
                         'õ',
                         'ô',
                         'ö',
                         'º' -> {
                        
                        txt += "o";
                        demo = true;
                        
                    }
                            
                    case 'u',
                         'ú',
                         'ù',
                         'û',
                         'ü' -> {
                        
                        txt += "u";
                        demo = true;
                        
                    }
                            
                    case 'y',
                         'ý' -> {
                        
                        txt += "y";
                        demo = true;
                        
                    }
                        
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
                        
                        if(i > 0 && i < p.length()-1 && demo) txt += "-";
                        demo = false;
                        
                    }//case
                    
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
                        
                    }//if(i > 0 && !Texto.isBlank())
                    
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
                        
                    } else {//if(Texto.length() >= 2)
                        
                        txt += "_";
                        
                    }//if(Texto.length() >= 2)
                    
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
    
    public static String AddRepeat(String repeated){
        
        var value = "";
        
        if(repeated.contains("_")){
            
            var before = "";
            var after = "";
            var divide = false;
            
            for(var i = 0; i < repeated.length(); i++){
                
                var ds = repeated.charAt(i);
                
                switch(ds){
                    
                    case '_' -> {
                        
                        if(divide){
                            
                            before += "_";
                            before += after;
                            after = "";
                            
                        } else {//if(divide)
                            
                            divide = true;
                            
                        }//if(divide)
                        
                    }//case '_'
                    
                    default -> {
                        
                        if(divide)
                        {after += ds;}
                        else
                        {before += ds;}
                        
                    }//default
                    
                }//switch(ds)
                
            }//for(var i = 0; i < repeated.length(); i++)
            
            var numeral = new Num(after);
            
            if(numeral.Val() && numeral.Num() > 0 && numeral.Num() <= 100){
                
                value += before;
                value += "_";
                value += Reg.Numb(numeral.Num()+1, 100);
                
            } else {//if(numeral.Val() && numeral.Num() > 0 && numeral.Num()...
                
                value += before;
                value += "_";
                value += after;
                value += "_001";
                
            }//if(numeral.Val() && numeral.Num() > 0 && numeral.Num() <= 100)
            
        } else {//if(repeated.contains("_"))
            
            value += repeated;
            value += "_001";
            
        }//if(repeated.contains("_"))
        
        return value;
        
    }//AddRepeat(String repeated)
    
    public static String arq_no_extension(String file_name){
        
        var tema = text(file_name, true);
        
        var t = "";
        
        if(!tema.isBlank()){
            
            final char[] acept_char = {
                ' ',
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
                'q',
                'w',
                'e',
                'é',
                'è',
                'ê',
                'r',
                't',
                'y',
                'ý',
                'u',
                'ú',
                'ù',
                'û',
                'i',
                'í',
                'í',
                'ì',
                'o',
                'ô',
                'õ',
                'ó',
                'ò',
                'p',
                'a',
                'ã',
                'â',
                'á',
                'à',
                's',
                'd',
                'f',
                'g',
                'h',
                'j',
                'k',
                'l',
                'z',
                'x',
                'c',
                'ç',
                'v',
                'b',
                'n',
                'm',
                '&'
            };
            
            for(var x = 0; x < tema.length(); x++){
                
                var y = 0;
                var loop = true;
                
                do{
                    
                    if(tema.toLowerCase().charAt(x) == acept_char[y]){
                        
                        t += tema.charAt(x);
                        
                        loop = false;
                        
                    }//if(tema.toLowerCase().charAt(x) == acept_char[y])
                    
                    y++;
                    
                }while(loop && y > 0 && y < acept_char.length);
                
            }//for(var x = 0; x < tema.length(); x++)
            
        }//if(!tema.isBlank())
        
        if(t.isBlank()){
            
            return "";
            
        } else {//if(t.isBlank())
            
            var val = "";
            
            var c = char_specific.other;
            
            for(var i = 0; i < t.length(); i++){
                
                switch(t.charAt(i)){
                    
                    case '.' -> c = char_specific.point;
                    
                    case '-' -> c = char_specific.hyphen;
                    
                    case '_' -> c = char_specific.underline;
                    
                    default -> {
                        
                        switch(c){
                            
                            case point, hyphen -> val += "-";
                            
                            case underline -> val += "_";
                            
                        }//switch(c)
                        
                        c = char_specific.other;
                        
                        val += t.charAt(i);
                        
                    }//default
                    
                }//switch(t.charAt(i))
                
            }//for(var i = 0; i < t.length(); i++)
            
            return val;
            
        }//if(t.isBlank())
        
    }//arq_no_extension(String file_name)
    
    public static boolean contains(String text, char[] contains){
        
        var contain = text.length() > contains.length && contains.length > 1;
        
        if(contain){
            
            var x = 0;
            
            do{
                
                var y = 0;
                
                do{
                    
                    contain = text.charAt(x) == contains[y];
                    
                    y++;
                    
                }while(!contain && y > 0 && y < contains.length);
                
                x++;
                
            }while(!contain && x > 0 && x < text.length());
            
        }//if(contain)
        
        return contain;
        
    }//contains(String text, char[] contain)
    
    public static int indexOf(String text, char proc, boolean first){
        
        final var init = -1;
        
        var value = init;
        
        if(text.length() > 1){
            
            if(first){
                
                var x = 0;
                
                do{
                    
                    if(text.charAt(x) == proc) value = x;
                    
                    x++;
                    
                }while(value == init && x > 0 && x < text.length());
                
            } else {//if(first)
                
                final var last = text.length()-1;
                
                var x = last;
                
                do{
                    
                    if(text.charAt(x) == proc) value = x;
                    
                    x--;
                    
                }while(value == init && x >= 0 && x < last);
                
            }//if(first)
            
        }//if(text.length() > 1)
        
        return value;
        
    }//indexOf(String text, char proc, boolean first)
    
    public static int ContChar(String text, char proc){
        
        int value = 0;
        
        if(text.length() > 1){
            
            for(var x = 0; x < text.length(); x++){
                
                if(text.charAt(x) == proc) value++;
                
            }//for(var x = 0; x < text.length(); x++)
            
        }//if(text.length() > 1)
        
        return value;
        
    }//indexOf(String text, char proc, boolean first)
    
    public static String replace(String txt, char remove){
        
        if(txt.length() > 1){
            
            var value = "";
            
            for(int i = 0; i < txt.length(); i++){
                
                if(txt.charAt(i) != remove) value += txt.charAt(i);
                
            }//for(int i = 0; i < txt.length(); i++)
            
            return value;
            
        } else {//if(txt.length() > 1)
            
            return "null";
            
        }//if(txt.length() > 1)
        
    }//replace(String txt, char remove)
    
    public static String replace(String txt, char[] remove){
        
        if(txt.length() > 1 && remove.length > 1){
            
            var value = "";
            
            for(int i = 0; i < txt.length(); i++){
                
                var proc = 0;
                var insert = true;
                
                do{
                    
                    insert = txt.charAt(i) != remove[proc];
                    
                    proc++;
                    
                }while(insert && proc > 0 && proc < remove.length);
                
                if(insert) value += txt.charAt(i);
                
            }//for(int i = 0; i < txt.length(); i++)
            
            return value;
            
        } else {//if(txt.length() > 1 && remove.length > 1)
            
            return "null";
            
        }//if(txt.length() > 1 && remove.length > 1)
        
    }//replace(String txt, char remove)
    
}//txt