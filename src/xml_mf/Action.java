// PAUSED CODE: 25/10/2026 - 14:08
// Line: "1184"
// Line: "1721"

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.Texto to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import confirm_cancel.*;
import form.*;
import model.*;
import xml_rw.*;
import file.*;

import static xml_rw.xml_config_file_cond.*;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Action {
    
    public final static char[] exclude_document_function = {'<','>',':',';',
        '.',',','!','?', '{','}','[',']','(',')',
        '0','1','2','3','4','5','6','7','8','9',
        '"','\'','@','#','$','%','&','*','-','_',
        '|','/','\\'};
    
    public final static Domain[] session_option = {
        new Domain(0, "Selecione uma opção!"),
        new Domain(1, "Condicionar todo o texto."),
        new Domain(2, "Condicionar Texto."),
        new Domain(3, "Predefinir DATA/HORA"),
        new Domain(4, "Separar por frase."),
        new Domain(5, "Separar por textos da frase.")
    };
    
    public final static int max_session_option = 5;
    
    private static Font EditFont = new java.awt.Font("Verdana", 18, 0);
    
    private static Font[] MyFont(){
        
        java.awt.Font font[] = {
            new java.awt.Font("Impact", 12, 0),
            EditFont
        };
        
        return font;
        
    }//MyFont()
    
    public static void Init(){
        
        controller.PrintKey();
        controller.p1s(new config());
        
        /* CADEIA info_err;                                                 **
        **                                                                  **
        ** ESCREVAL("classe \"Action\" do pacote \"xml_mf\"");              **
        **                                                                  **
        ** ESCREVA("Observe o código minunciosamente e diga se ");          **
        ** ESCREVAL("encontrou algum erro!");                               **
        **                                                                  **
        ** ESCREVAL("Deixe em branco se não encontrar nenhum erro!");       **
        ** LEIA(info_err);                                                  **
        **                                                                  **
        ** SE(info_err == ""){                                              **
        **                                                                  **
        **    ESCREVA("A próxima etapa é: ");                               **
        **    ESCREVAL("rodar o código!");                                  **
        **                                                                  **
        **    ESCREVA("Mas atenção, pode haver erros que não ");            **
        **    ESCREVA("foi encontrado na visualização do código, mas ");    **
        **    ESCREVA("pode ser que todo erro já tenha sido resolvido e "); **
        **    ESCREVA("que o código funcione normalmente!");                **
        **                                                                  **
        ** } SENAO {                                                        **
        **                                                                  **
        **    ESCREVAL("Não mexer na função:");                             **
        **                                                                  **
        **    ESCREVAL("public static void Init()");                        **
        **                                                                  **
        **    ESCREVA("Mas ao invés disso, antes, resolver o problema ");   **
        **    ESCREVA("encontrado e procurar novos erros.");                **
        **                                                                  **
        ** }                                                                */
        
    }//Init()
    
    private static String xml_config(){
        
        var file_name_path = "";
        
        if(Reg.java) file_name_path += "..\\";
        
        file_name_path += "java-command_xml.xml";
        
        return file_name_path;
        
    }//xml_config()
    
    private static boolean xml_val(){
        return Arq.Dir(xml_config(), false);
    }
    
    private static xml_config xml()
    {return new xml_config(new Arq(xml_config()).Read());}
    
    private static List<String> Doc(){
        
        List<String> files = new ArrayList();
        
        if(xml().Windows()){
            
            var Documents = "C:\\Users\\";
            Documents += xml().UserWindows();
            Documents += "\\Documents\\";
            
            files.add(Documents);
            
        }//if(xml().Windows())
        
        if(!xml().learn().isEmpty()){
            
            Order<xml_config_one> data = new Order();
            
            for(xml_config_one x : xml().learn()){
                
                var t = x.Local();
                var folder = "";
                var file = "";
                
                for(var i = 0; i < t.length(); i++){
                    
                    switch(t.charAt(i)){
                        
                        case '\\', '/' ->{
                            
                            folder = file;
                            file = "";
                            
                        }//case '\\', '/'
                        
                        default -> file += t.charAt(i);
                        
                    }//switch(tema.charAt(i))
                    
                }//for(var i = 0; i < t.length(); i++)
                
                data.Add(x, file.isBlank() ? folder : file);
                
            }//for(xml_config_one x : xml().learn())
            
            for(xml_config_one j : data.Return()){
                
                var t = j.Local();
                var tema = "";
                var demo = "";
                var control = false;
                
                for(var i = 0; i < t.length(); i++){
                    
                    switch(t.charAt(i)){
                        
                        case '\\', '/' ->{
                            
                            if(!tema.isBlank()){
                                
                                tema += "\\";
                                control = false;
                                
                            }//if(!tema.isBlank())
                            
                            tema += demo;
                            demo = "";
                            
                        }//case '\\', '/'
                        
                        case ' ' -> {
                            
                            if(control) demo += " ";
                            
                        }//case ' '
                        
                        default -> {
                            
                            demo += t.charAt(i);
                            control = true;
                            
                        }//default
                        
                    }//switch(t.charAt(i))
                    
                }//for(var i = 0; i < tema.length(); i++)
                
                if(control) tema += "\\";
                
                files.add(tema);
                
            }//for(xml_config_one j : data.Return())
            
        }//if(!xml().learn().isEmpty())
        
        return files;
        
    }//Doc()
    
    private static void newFont(Font font){EditFont = font;}
    
    private static boolean newFont(String arq){
        
        if(
            Arq.Dir(arq, false) &&
            !Texto.text(arq, exclude_document_function).isBlank()
        )
        {
            
            final String[] otf = {"ttf", "otf","TTF", "OTF"};
            
            var file = "";
            
            for(var i = 0; i < arq.length(); i++){
                
                switch(arq.charAt(i)){
                    
                    case '.' -> file = "";
                    
                    default -> file += arq.charAt(i);
                    
                }//switch(ttf.charAt(i))
                
            }//for(var i = 0; i < ttf.length(); i++)
            
            var aply = false;
            
            if(!file.trim().isBlank() && otf.length > 1){
                
                var proc = 0;
                
                do{
                    
                    aply = file.equals(otf[proc]);
                    
                    proc++;
                    
                }while(!aply && proc > 0 && proc < otf.length);
                
            }//if(!file.trim().isBlank() && otf.length > 1)
            
            return aply;
            
        } else {//if(Arq.Dir(ttf, false) && !Texto.text(ttf, exclude_document_f...
            
            return false;
            
        }//if(Arq.Dir(ttf, false) && !Texto.text(ttf, exclude_document_function...
        
    }//newFont(String arq)
    
    public static void font_new(carregarFonte f){
        
        if(xml_val() && f.Val()){
            
            newFont(f.Font());
            
            controller.p1s(new folder_xml(xml(), MyFont()));
            
        } else if(xml_val()){//if(xml_val() && f.Val())
            
            controller.p1s(new folder_xml(xml(), MyFont(), f.msg().get(0)));
            
        } else {//if(xml_val() && f.Val())
            
            Exit();
            
        }//if(xml_val() && f.Val())
        
    }//font_new(carregarFonte f)
    
    public static void font_new(xml_document doc, carregarFonte f){
        
        if(f.Val()){
            
            newFont(f.Font());
            
            controller.p1s(new ReadWrite(doc, MyFont()));
            
        } else {//if(f.Val())
            
            controller.p1s(new ReadWrite(doc, MyFont(), f.msg().get(0)));
            
        }//if(f.Val())
        
    }//font_new(xml_document doc, carregarFonte f)
    
    public static void font_new(
        xml_document doc,
        xml_document_one one,
        carregarFonte f
    )
    {
        
        if(f.Val()){
            
            newFont(f.Font());
            
            controller.p3(new session(doc, one, MyFont()));
            
        } else {//if(f.Val())
            
            List<String> note = new ArrayList();
            
            note.addAll(f.msg());
            
            if(!one.getText().isEmpty()) note.addAll(one.getText());
            
            var dat = one;
            
            dat.setText(note);
            
            controller.p3(new session(doc, dat, MyFont()));
            
        }//if(f.Val())
        
    }//font_new(xml_document doc, xml_document_one one, carregarFonte f)
    
    public static void Exit(){
        
        if(Reg.java){
            
            System.out.println(Data.code.DataCompleta(true));
            System.out.println(Hora.code.TimerGood(true));
            
            if(xml_val() && xml().Windows()){
                
                System.out.print("Ola: \"");
                System.out.print(xml().UserWindows().toUpperCase());
                System.out.print("\" ");
                
            }//if(arq.Val() && xml.Windows())
                
            System.out.print(Hora.Good());
            System.out.println("!");
            
            if(!xml().learn().isEmpty()){
                
                System.out.println();
                
                int ind = 0;
                
                var tot = 0;
                
                for(xml_config_one t : xml().learn())
                {if(Arq.Dir(t.Local())) tot++;}
                
                for(xml_config_one t : xml().learn()){
                    
                    if(Arq.Dir(t.Local())){
                        
                        ind++;
                        
                        System.out.print("Arquivo: ");
                        System.out.print(Reg.Numb(ind, tot, " de "));
                        System.out.print(": \"");
                        System.out.print(Arq.Files(t.Local()));
                        System.out.print("\" - [");
                        System.out.print(t.InsertData().DataAbreviada(true));
                        
                        if(!t.ModifyData().CompareTo(t.InsertData())){
                            
                            System.out.print("] [");
                            System.out.print(t.ModifyData().DataAbreviada(true));
                            
                        }//if(!t.ModifyData().CompareTo(t.InsertData()))
                        
                        System.out.println("]");
                        
                    }//if(Arq.Dir(t.Local()))
                    
                }//for(xml_config_one t : xml.learn())
                
            }//if(!xml.learn().isEmpty())
            
        }//if(Reg.java)
        
        System.exit(0);
        
    }//Exit()
    
    public static void Exit(xml_document doc){
        
        if(Reg.java){
            
            System.out.println(Data.code.DataCompleta(true));
            System.out.println(Hora.code.TimerGood(true));
            
            if(xml_val() && xml().Windows()){
                
                System.out.print("Ola: \"");
                System.out.print(xml().UserWindows().toUpperCase());
                System.out.print("\" ");
                
            }//if(arq.Val() && xml.Windows())
                
            System.out.print(Hora.Good());
            System.out.println("!");
            
            if(!doc.List().isEmpty()){
                
                System.out.println();
                
                for(int i = 0; i < doc.List().size(); i++){
                    
                    System.out.print("Título ");
                    System.out.print(Reg.Numb(i+1, doc.List().size(), " de "));
                    System.out.print(": \"");
                    System.out.print(doc.List().get(i).getTitle());
                    System.out.println("\"");
                    
                }//for(int i = 0; i < doc.List().size(); i++)
                
            }//if(!doc.List().isEmpty())
            
        }//if(Reg.java)
        
        System.exit(0);
        
    }//Exit(xml_document doc)
    
    public final static void Err(String type, String message){
        
        var no_user_form = true;
        
        if(Texto.phrase(message).size() > 1){
        
            List<String> tok = new ArrayList();
            
            String toc = "";
            
            for(String t : Texto.phrase(message)){
                
                var new_t = false;
                
                if(t.length() > 1){
                    
                    final char[] end = {'.', ',', ';', ':'};
                    
                    var proc_end = 0;
                    
                    do{
                        
                        new_t = t.charAt(t.length()-1) == end[proc_end];
                        
                        proc_end++;
                        
                    }while(!new_t && proc_end > 0 && proc_end < end.length);
                    
                    if(!new_t){
                        
                        final char[] into = {'\'','"', '[', '(', '{'};
                        
                        var proc = 0;
                        
                        do{
                            
                            new_t = t.charAt(0) == end[proc_end];
                            
                            proc++;
                            
                        }while(!new_t && proc > 0 && proc < into.length);
                        
                    }//if(!new_t)
                    
                }//if(t.length() > 1)
                
                if(new_t){
                    
                    tok.add(toc);
                    toc = "";
                    
                } else {//if(new_t)
                    
                    if(!toc.isBlank()) toc += " ";
                    
                    toc += t;
                    
                }//if(new_t)
                
            }//for(String t : Texto.phrase(message))
            
            var tl = Hora.Good();
            tl += " - \"";
            tl += type.toUpperCase();
            tl += "\"";
            
            no_user_form = !controller.Msg(tl, tok, true);
        
        }//if(Texto.phrase(message).size() > 1)
        
        if(no_user_form){
            
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
                
                for(var i = 0; i < print.length || i < println.length; i++)
                {System.err.println(Reg.Tab(print[i],println[i],tab));}
                
            }//if(Reg.java)
            
            System.exit(0);
            
        }//if(no_user_form)
        
    }//Err(String message)
    
    private static String Document(String input){
        
        if(Texto.text(input, exclude_document_function).isBlank()){
            
            var title = Data.code.DataAbreviada(false);
            title += " - ";
            title += Hora.code.Timer();
            
            return title;
            
        } else {//if(Texto.text(doc.getTitle(), exclude).isBlank())
            
            return Texto.title(input, true);
            
        }//if(Texto.text(doc.getTitle(), exclude).isBlank())
        
    }//Document(String input)
    
    public final static String OverrideTitle(xml_document doc, boolean title){
        
        var c = doc.CreateDate();
        var m = doc.ModifyDate();
        var equal = c.CompareTo(m, true);
        
        var t = Texto.title(doc.getTitle(), true);
        
        var val = "";
        
        if(title && !t.isBlank()){
            
            if(equal) val += "[";
            
            val += c.DataAbreviada(equal);
            
            if(equal){
                
                val += "]";
                
            } else {//if(equal)
                
                val += " --> ";
                
                val += m.DataAbreviada(true);
                
                val += " -->";
                
            }//if(equal)
            
            val += " ";
            val += t;
            
        } else if(!t.isBlank()){//if(title && !t.isBlank())
            
            var max_str = 32;
            
            if(equal){
                
                val += c.DataAbreviada(false);
                val += " ";
                
                max_str = 21;
            
            }//if(equal)
            
            var tm = Texto.phrase(t, exclude_document_function);
            
            if(tm.get(0).length() < max_str){
                
                var i = 0;
                var cont = 0;
                
                boolean loop;
                
                do{
                    
                    if(i > 0) val += " ";
                    
                    val += tm.get(i);
                    
                    cont += tm.get(i).length();
                    
                    var cond1 = cont <= max_str;
                    var cond2 = tm.get(i).length() <= max_str;
                    
                    loop = cond1 && cond2;
                    
                    i++;
                    
                }while(loop && i > 0 && i < tm.size());
                
            } else {//if(tm.get(0).length() < max_str)
                
                var p = tm.get(0).toUpperCase();
                
                var i = 0;
                
                do{
                    
                    val += p.toUpperCase().charAt(i);
                    
                    i++;
                    
                }while(i > 0 && i < max_str && i < p.length());
                
            }//if(tm.get(0).length() < max_str)

        } else if(title){//if(title && !t.isBlank())
            
            val += Data.code.DataAbreviada(equal);
            val += "! Documento sem título!";
            
        } else {//if(title && !t.isBlank())
            
            val += doc.ModifyDate().DataAbreviada(true);
            
        }//if(title && !t.isBlank())
        
        return val;
        
    }//OverrideTitle(xml_document doc, boolean title)
    
    private static int month_ComboBox(String value){
        
        if(Texto.arq(value).isBlank()){
            
            return -1;
            
        } else {
            
            final Domain month[] = {
                new Domain(1,"jan"),
                new Domain(2,"fev"),
                new Domain(2,"feb"),
                new Domain(3,"mar"),
                new Domain(4,"abr"),
                new Domain(5,"mai"),
                new Domain(5,"may"),
                new Domain(6,"jun"),
                new Domain(7,"jul"),
                new Domain(8,"ago"),
                new Domain(9,"set"),
                new Domain(10,"out"),
                new Domain(11,"nov"),
                new Domain(12,"dez"),
                new Domain(12,"dec")
            };
            
            var val = -1;
            
            var tx = "";
            
            var dm = Texto.arq(value);
            
            for(int i = 0; i < dm.length(); i++){
                
                var cont = 0;
                var in_loop = true;
                
                do{
                    
                    var charAt = tx.isBlank() ? 0 : tx.length()-1;
                    
                    if(charAt < month[cont].Text().length()){
                        
                        if(month[cont].Text().charAt(charAt) == dm.charAt(i)){
                            
                            tx += month[cont].Text().charAt(charAt);
                            in_loop = false;
                            
                        }//if(month[cont].Text().charAt(charAt) == dm.charAt(i))
                        
                    }//if(charAt < dm.length())
                    
                    cont++;
                    
                }while(in_loop && cont > 0 && cont < month.length);
                
            }//for(int i = 0; i < Texto.arq(value).length(); i++)
            
            var proc = 0;
            var loop = true;
            
            do{
                
                if(tx.equalsIgnoreCase(month[proc].Text())){
                    
                    val = month[proc].index();
                    loop = false;
                    
                }//if(tx.equalsIgnoreCase(month[proc].Text()))
                
                proc++;
                
            }while(loop && proc > 0 && proc < month.length);
            
            return val;
            
        }//if(!text.isBlank())
        
    }//month_ComboBox(String value)
    
    private static List<String> session_ComboBox(
        Domain d,
        List<String> value,
        int row
    )
    {
        
        if(value.isEmpty()){
            
            return new ArrayList();
            
        } else if(d.index() == 1){//if(value.isEmpty())
            
            List<String> aplication = new ArrayList();
            
            var line_blank = false;
            
            for(String line : value){
                
                var text_line = new Link(line).Val()
                    ? line
                    : Texto.text(line, true);
                
                if(text_line.isBlank()){
                    
                    line_blank = true;
                    
                } else {//if(text_line.isBlank())
                    
                    if(line_blank){
                        
                        aplication.add("");
                        line_blank = false;
                        
                    }//if(line_blank)
                    
                    aplication.add(text_line);
                    
                }//if(t.isBlank())
                
            }//for(String val : value)
            
            return aplication;
            
        } else {//if(value.isEmpty())
            
            List<String> val = new ArrayList();
            
            for(var i = 0; i < value.size(); i++){
                
                if(
                    i == row &&
                    !new Link(value.get(i)).Val() &&
                    !Texto.text(value.get(i)).isBlank()
                )
                {
                    
                    String t = value.get(i);
                    
                    switch(d.index()){
                        
                        case 2 -> val.add(Texto.text(t));
                        
                        case 3 -> {
                            
                            var data = new Data(t.trim());
                            
                            if(data.Val()){
                                
                                val.add(data.Load());
                                
                            } else {//if(data.Val())
                                
                                final var init = -1;
                                
                                var year = init;
                                var month = init;
                                var day = init;
                                
                                for(String tm : Texto.phrase(t, true)){
                                    
                                    var dat = month_ComboBox(tm);
                                    
                                    var n = new Num(tm);
                                    
                                    if(
                                        year == init &&
                                        n.Val() &&
                                        n.Num() > 1972 &&
                                        n.Num() <= new Data()
                                            .getDate()
                                            .getYear() + 1
                                    ) year = n.Num();
                                    
                                    if(
                                        day == init &&
                                        n.Val() &&
                                        n.Num() > 0 &&
                                        n.Num() <= 31
                                    ) day = n.Num();
                                    
                                    if(month == init && dat > 0) month = dat;
                                    
                                }//while(loop && cont > 0 && cont < tm.size());
                                
                                if(
                                    init != year &&
                                    init != month &&
                                    init != day
                                )
                                {
                                    
                                    Data code = new Data(year, month, day);
                                    
                                    if(code.Val()){
                                        
                                        val.add(code.Load());
                                        
                                    } else {//if(code.Val())
                                        
                                        val.add(t);
                                        
                                    }//if(code.Val())
                                    
                                } else {//if(year != init && month != init &&...
                                    
                                    val.add(t);
                                    
                                }//if(year != init && month != init && day !=...
                                
                            }//if(data.Val())
                            
                        }//case 3
                        
                        case 4, 5 -> {
                            
                            var line = true;
                            
                            var rd = "";
                            
                            for(String r : Texto.phrase(t)){
                                
                                switch(r.charAt(0)){
                                    
                                    case '{', '[', '(' -> {
                                        
                                        if(!rd.isBlank()){
                                            
                                            val.add(rd);
                                            line = false;
                                            rd = r;
                                            
                                        }//if(!rd.isBlank())
                                        
                                    }//case '{', '[', '('
                                    
                                    case '"', '\'' -> {
                                        
                                        switch(d.index()){
                                            
                                            case 4 ->{
                                                
                                                if(!rd.isBlank()) rd += " ";
                                                
                                                rd += r;
                                                
                                            }//case 4
                                            
                                            case 5 ->{

                                                if(!rd.isBlank()){
                                                    
                                                    val.add(rd);
                                                    rd = r;
                                                    
                                                    line = false;
                                                    
                                                }//if(!rd.isBlank())
                                                
                                            }//case 5
                                            
                                        }//switch(d.index())
                                        
                                    }//case '"', '\''
                                    
                                    default ->{
                                        
                                        if(!rd.isBlank()) rd += " ";
                                        rd += r;
                                        
                                    }//default
                                    
                                }//switch(r.charAt(0))
                                
                                if(line){
                                    
                                    switch(r.charAt(r.length()-1)){
                                        
                                        case '.' -> {
                                            
                                            if(r.length() > 3){
                                                
                                                val.add(rd);
                                                rd = "";
                                                
                                            }//if(r.length() > 3)
                                            
                                        }//case '.'
                                        
                                        case ',',
                                             '>',
                                             '}',
                                             ']',
                                             ')',
                                             '"',
                                             '\'' ->{
                                            
                                            if(d.index() == 5){
                                                
                                                val.add(rd);
                                                rd = "";
                                                
                                            }//if(d.index() == 5)
                                            
                                        }//cases
                                        
                                        case '?',
                                             '!',
                                             ';',
                                             ':' -> {
                                            
                                            val.add(rd);
                                            rd = "";
                                            
                                        }//cases
                                             
                                    }//switch(r.charAt(r.length()-1))
                                    
                                }//for(String r : Texto.phrase(t))
                                
                            }//if(line)
                            
                            if(!rd.isBlank()) val.add(rd);
                            
                        }//case 4, 5
                        
                        default -> val.add(t);
                        
                    }//switch(d.index())
                    
                } else {//if(i == row && !new Link(value.get(i)).Val() &&...
                    
                    val.add(value.get(i));
                    
                }//if(i == row && !new Link(value.get(i)).Val() && !Texto.text(...
                
            }//for(var i = 0; i < value.getText().size(); i++)
            
            return val;
            
        }//if(value.isEmpty())
        
    }//session_ComboBox
    
    public static void session_combobox(
        Domain menu,
        xml_document doc,
        xml_document_one one,
        int row
    )
    {
        
        var dat = one;
        
        dat.setText(
            session_ComboBox(
                menu,
                one.getText(),
                row
            )
        );
        
        controller.p3(
            new session(
                doc,
                dat,
                MyFont()
            )
        );
        
    }//session_combobox
    
    public static void session_save(
        xml_document doc,
        xml_document_one one,
        String title,
        boolean confirm
    )
    {
        
        Arq arq = new Arq(doc.Local());
        
        if(arq.Val()){
            
            doc.Del(one.getTitle());
            
            one.setTitle(Document(title));
            
            doc.Add(one, true);
            
            var e = doc.Save(arq);
            
            if(e.Val()){
                
                if(Reg.java){
                    
                    System.out.print("Salvo: ");
                    System.out.print(Data.code.DataAbreviada(true));
                    System.out.print(" - ");
                    System.out.print(Hora.code.TimerGood(false));
                    System.out.print(" - ");
                    System.out.print(one.getTitle());
                    
                }//if(Reg.java)
                
            } else {//if(e.Val())
                
                Err(e.Type(), e.Message());
                
            }//if(e.Val())
            
        } else {//if(arq.Val())
            
            final var p = Texto.arq_no_extension(doc.getTitle());
            
            var con = "";
            
            if(xml().Windows()){
                
                if(Arq.Dir(xml().Documents())){
                    
                    con += xml().Documents();
                    
                }//if(Arq.Dir(xml.Documents()))
                
            }//if(xml.Windows())
            
            Hora h = Hora.code;
            
            con += Data.code.Load();
            con += " - ";
            con += Reg.Numb(h.Hour());
            con += "h";
            con += Reg.Numb(h.Min());
            con += "m";
            
            if(h.Sec() > 0){
                
                con += Reg.Numb(h.Sec());
                con += "s";
                
            }//if(h.Sec() > 0)
            
            if(p.length() <= 20){
                
                con += " - ";
                
                con += p;
                
            }//if(p.length() <= 20)
            
            con += ".xml";
            
            doc.Del(one.getTitle());
            
            one.setTitle(Document(title));
            
            doc.Add(one, true);
            
            var e = doc.Save(new Arq(con));
            
            if(e.Val()){
                
                if(Reg.java){
                    
                    System.out.print(Hora.code.TimerGood(false));
                    System.out.print(" - Arquivo: \"");
                    System.out.print(doc.getTitle());
                    System.out.println("\" salvo!");
                    
                }//if(Reg.java)
                
            } else {//if(e.Val())
                
                Err(e.Type(), e.Message());
                
            }//if(e.Val())
            
        }//if(arq.Val())
        
        var read = xml().learn();
        
        List<String> node = new ArrayList();
        
        for(xml_config_one o : read) node.add(o.Local());
        
        var cod = Order.Proc(node, doc.Local());
        
        xml_config_one rew;
        
        if(!read.isEmpty() && cod >= 0 && cod < read.size()){
            
            xml().Del(cod);
            
            rew = xml().learn().get(cod);
            
            rew.Update();
            
        } else {//if(!read.isEmpty() && cod >= 0 && cod < read.size())
            
            rew = new xml_config_one(
                doc.getTitle(),
                doc.Local()
            );
            
        }//if(!read.isEmpty() && cod >= 0 && cod < read.size())
        
        xml().Add(rew);
        
        var ok = xml().Save(new Arq(xml_config()));
        
        if(!ok.Val()) Err(ok.Type(), ok.Message());
        
    }//session_save
    
    public static void session_open(
        xml_document doc,
        xml_document_one one,
        Read r
    )
    {
        
        // PAUSED CODE
        
    }//session_open
    
    public static void session(
        xml_document doc,
        xml_document_one one,
        String title,
        boolean confirm
    ){
        
        if(confirm){
            
            var cod = Texto.arq_no_extension(title);
            
            var cond1 = cod.length() >= 3;
            
            var cond2 = cod.length() <= 20;
            
            boolean acept;
            
            if(cond1 && cond2){
                
                acept = true;
                
                var t = one.getText();
                
                var proc = 0;
                
                do{
                    
                    acept = Texto.text(
                        t.get(proc),
                        exclude_document_function
                    ).isBlank();
                    
                    proc++;
                    
                }while(acept && proc > 0 && proc < t.size());
                
            } else {//if(cond1 && cond2)
                
                acept = false;
                
            }//if(cond1 && cond2)
            
            if(acept){
                
                var proc = 0;
                var next = true;
                
                do{
                    
                    var tl = Doc().get(proc);
                    tl += cod;
                    tl += ".txt";
                    
                    if(Arq.Dir(tl, false)){
                        
                        if(Arq.Tam(tl) < 1073741824L){
                            
                            var r = new Arq(Arq.Files(tl)).Read();
                            
                            if(r.Max() < 1000){
                                
                                var l = 0;
                                
                                do{
                                    
                                    if(
                                        Texto.phrase(
                                            r.Read(l),
                                            exclude_document_function
                                        ).size() > 1
                                    )
                                    {
                                        
                                        session_open(doc, one, r);
                                        next = false;
                                        
                                    }//if(Texto.phrase(r.Read(l), exclude...
                                    
                                    l++;
                                    
                                }while(next && l > 0 && l < r.Max());
                                
                            }//if(r.Max() < 1000)
                            
                        }//if(Arq.Tam(cod) < 1073741824L)
                        
                    }//if(Arq.Dir(cod, false))
                    
                    proc++;
                    
                }while(next && proc > 0 && proc < Doc().size());
                
                if(next){//1 -- 3
                    
                    var tl = Doc().get(proc);
                    tl += cod;
                    tl += ".md";
                    
                    proc = 0;
                    
                    do{
                        
                        if(Arq.Dir(tl, false)){
                            
                            if(Arq.Tam(tl) < 1073741824L){
                                
                                var r = new Arq(Arq.Files(tl)).Read();
                                
                                if(r.Max() < 1000){
                                    
                                    var l = 0;
                                    
                                    do{
                                        
                                        if(
                                            Texto.phrase(
                                                r.Read(l),
                                                exclude_document_function
                                            ).size() > 1
                                        )
                                        {
                                            
                                            session_open(doc, one, r);
                                            next = false;
                                            
                                        }//if(Texto.phrase(r.Read(l), exclude...
                                        
                                        l++;
                                        
                                    }while(next && l > 0 && l < r.Max());
                                    
                                }//if(r.Max() < 1000)
                                
                            }//if(Arq.Tam(cod) < 1073741824L)
                            
                        }//if(Arq.Dir(cod, false))
                        
                        proc++;
                        
                    }while(next && proc > 0 && proc < Doc().size());
                    
                }//if(next) -- 1 -- 3
                
                if(next){//2 -- 3
                    
                    var tl = Doc().get(proc);
                    tl += cod;
                    tl += ".MD";
                    
                    proc = 0;
                    
                    do{
                        
                        if(Arq.Dir(tl, false)){
                            
                            if(Arq.Tam(tl) < 1073741824L){
                                
                                var r = new Arq(Arq.Files(tl)).Read();
                                
                                if(r.Max() < 1000){
                                    
                                    var l = 0;
                                    
                                    do{
                                        
                                        if(
                                            Texto.phrase(
                                                r.Read(l),
                                                exclude_document_function
                                            ).size() > 1
                                        )
                                        {
                                            
                                            session_open(doc, one, r);
                                            next = false;
                                            
                                        }//if(Texto.phrase(r.Read(l), exclude...
                                        
                                        l++;
                                        
                                    }while(next && l > 0 && l < r.Max());
                                    
                                }//if(r.Max() < 1000)
                                
                            }//if(Arq.Tam(cod) < 1073741824L)
                            
                        }//if(Arq.Dir(cod, false))
                        
                        proc++;
                        
                    }while(next && proc > 0 && proc < Doc().size());
                    
                }//if(next) -- 2 -- 3
                
                if(next){//3 -- 3
                    
                    var tl = Doc().get(proc);
                    tl += cod;
                    tl += ".TXT";
                    
                    proc = 0;
                    
                    do{
                        
                        if(Arq.Dir(tl, false)){
                            
                            if(Arq.Tam(tl) < 1073741824L){
                                
                                var r = new Arq(Arq.Files(tl)).Read();
                                
                                if(r.Max() < 1000){
                                    
                                    var l = 0;
                                    
                                    do{
                                        
                                        if(
                                            Texto.phrase(
                                                r.Read(l),
                                                exclude_document_function
                                            ).size() > 1
                                        )
                                        {
                                            
                                            session_open(doc, one, r);
                                            next = false;
                                            
                                        }//if(Texto.phrase(r.Read(l), exclude...
                                        
                                        l++;
                                        
                                    }while(next && l > 0 && l < r.Max());
                                    
                                }//if(r.Max() < 1000)
                                
                            }//if(Arq.Tam(cod) < 1073741824L)
                            
                        }//if(Arq.Dir(cod, false))
                        
                        proc++;
                        
                    }while(next && proc > 0 && proc < Doc().size());
                    
                }//if(next) -- 3 -- 3
                
                if(next) session_save(doc, one, title, true);
                
            } else {//if(acept)
                
                session_save(doc, one, title, true);
                
            }//if(acept)
            
        } else {//if(confirm)
            
            session_save(doc, one, title, false);
            
        }//if(confirm)
        
    }//session
    
    public static void session_confirm(
        xml_document doc,
        xml_document_one one,
        String title
    )
    {
        
        if(newFont(title)){
            
            controller.p2(new newFont(doc, one, Arq.Files(title), MyFont()));
            
        } else {//if(newFont(title))
            
            session(doc, one, title, true);
            
        }//if(newFont(title))
        
    }//session_confirm
    
    public static void session_save_temp(
        xml_document doc,
        xml_document_one one,
        String title
    ){
        
        final var t = Texto.text(one.getTitle(), true);
        
        var node = "~";
            
        if(t.charAt(0) == '~'){
            
            node += Texto.AddRepeat(t.substring(1));
            
        } else {
            
            node += t;
            
        }
        
        one.setTitle(node);
        
        session(doc, one, title, false);
        
    }//session_save_temp
    
    public static void session_cancel(
        xml_document doc,
        xml_document_one one,
        String title
    )
    {
        
        var txt1 = "";
        
        for(String p : Texto.phrase(one.getTitle()))
        {txt1 += Texto.arq(p);}
        
        var proc = 0;
        var find = -1;
        
        do{
            
            var txt_a1 = "";
            
            for(String p : Texto.phrase(doc.List().get(proc).getTitle()))
            {txt_a1 += Texto.arq(p);}
            
            if(txt1.equals(txt_a1)) find = proc;
            
            proc++;
            
        }while(find < 0 && proc > 0 && proc < doc.List().size());
        
        if(find >= 0){
            
            xml_document_one done = doc.List().get(find);
            
            var txt2 = "";
            
            if(done.getText().isEmpty()){
                
                for(String x : done.getText()){
                    
                    if(!Texto.phrase(x).isEmpty())
                    {for(String y : Texto.phrase(x)) {txt2 += Texto.arq(y);}}
                    
                }//for(String x : done.getText())
                
            }//if(done.getText().isEmpty())
            
            var txt3 = "";
            
            if(!one.getText().isEmpty()){
                
                for(String x : one.getText()){
                    
                    if(!Texto.phrase(x).isEmpty())
                    {for(String y : Texto.phrase(x)) {txt3 += Texto.arq(y);}}
                    
                }//for(String x : one.getText())
                
            }//if(!one.getText().isEmpty())
            
            var cond1a = txt2.equals(txt3);
            var cond1b = Texto.text(txt2,exclude_document_function).isBlank();
            var cond1 = cond1a || cond1b;
            
            var txt4 = "";
            
            if(!Texto.phrase(title).isEmpty()){
                
                for(String x : Texto.phrase(title)){
                    
                    if(!Texto.phrase(x).isEmpty()){
                        
                        for(String y : Texto.phrase(x))
                        {txt4 += Texto.arq(y);}
                        
                    }//if(!Texto.phrase(x).isEmpty())
                    
                }//for(String x : Texto.phrase(title))
                
            }//if(!Texto.phrase(title).isEmpty())
            
            var txt5 = "";
            
            if(!Texto.phrase(done.getTitle()).isEmpty()){
                
                for(String x : Texto.phrase(done.getTitle())){
                    
                    if(!Texto.phrase(x).isEmpty()){
                        
                        for(String y : Texto.phrase(x))
                        {txt5 += Texto.arq(y);}
                        
                    }//if(!Texto.phrase(x).isEmpty())
                    
                }//for(String x : Texto.phrase(title))
                
            }//if(!Texto.phrase(title).isEmpty())
            
            var cond2a = txt4.equals(txt5);
            var cond2b = Texto.text(txt4,exclude_document_function).isBlank();
            var cond2 = cond2a || cond2b;
            
            if(cond1 && cond2){
                
                controller.p1m(
                    new ReadWrite(
                        doc,
                        MyFont(),
                        Texto.text(title, true)
                    )
                );
                
            } else {//if(cond1 && cond2)
                
                session_save_temp(doc, one, title);
                
            }//if(cond1 && cond2)
                
        } else {//if(find >= 0)
            
            var cond = true;
            
            if(!one.getText().isEmpty()){
                
                var cod = one.getText();
                
                var letter = 0;
                
                do{
                    
                    cond = Texto.phrase(
                        cod.get(letter),
                        exclude_document_function
                    ).isEmpty();
                    
                    letter++;
                    
                }while(cond && letter > 0 && letter < cod.size());
                
            }//if(!one.getText().isEmpty())
            
            if(cond){
                
                controller.p1m(
                    new ReadWrite(
                        doc,
                        MyFont(),
                        Texto.text(title, true)
                    )
                );
                
            } else {//if(cond)
                
                session_save_temp(doc, one, title);
                
            }//if(cond)
            
        }//if(find >= 0)
        
    }//session_cancel
    
    public static void ReadWrite(xml_document doc, String input){
        
        if(newFont(input)){
            
            controller.p2(new newFont(doc, Arq.Files(input), MyFont()));
            
        } else {//if(newFont(input))
            
            xml_document_one novo = new xml_document_one();
            
            novo.setTitle(
                Texto.text(
                    input,
                    exclude_document_function
                ).isBlank() ? "" : Texto.title(input, true)
            );
            
            controller.p2(new DocumentView(doc, novo, MyFont()));
            
        }//if(newFont(input))
        
    }//ReadWrite(xml_document doc,String input)
    
    public static void ReadWrite(
        xml_document doc,
        xml_document_one one,
        String input
    )
    {
        
        if(
            Texto.text(
                input,
                exclude_document_function
            ).isBlank()
        )
        {
            
            if(newFont(input)){
                
                controller.p2(new newFont(doc, Arq.Files(input), MyFont()));
                
            } else {//if(newFont(input))
                
                controller.p2(new DocumentView(doc,one,MyFont()));
                
            }//if(newFont(input))
            
        } else {//if(Texto.text...
            
            ReadWrite(doc, input);
            
        }//if(Texto.text...
        
    }//ReadWrite(xml_document doc, xml_document_one one, String input)
    
    public static void folder_xml(String input){
        
        if(newFont(Texto.text(input, true))){
            
            controller.p2(new newFont(xml(), Arq.Files(input), MyFont()));
            
        } else if(Texto.text(input, exclude_document_function).isBlank()){//if(...
            
            Exit();
            
        } else {//if(newFont(Texto.text(input, true)))
            
            // PAUSED CODE
            
        }//if(newFont(Texto.text(input, true)))
        
    }//folder_xml(String input)
    
    public static void folder_xml(Domain menu, String input){
        
        if(newFont(Texto.text(input, true))){
            
            controller.p2(new newFont(xml(), Arq.Files(input), MyFont()));
            
        } else if(
            menu.index() >= 0 &&
            menu.index() < xml().learn().size() &&
            !xml().learn().isEmpty() &&
            Texto.text(input, exclude_document_function).isBlank()
        )
        {
            
            xml_config_one id = xml().learn().get(menu.index());
            
            switch(id.Cond()){
                
                case write ->{
                    
                    Arq cod = new Arq(id.Local());
                    
                    if(cod.Val()){
                    
                        controller.p1s(
                            new ReadWrite(
                                new xml_document(
                                    cod.Read(),
                                    cod.Dir(true)
                                ),
                                MyFont()
                            )
                        );
                        
                    } else {//if(cod.Val())
                        
                        Err(cod.Type(), cod.Message());
                        
                    }//if(cod.Val())
                    
                }//case write
                
                case readonly ->{
                    
                    Arq cod = new Arq(id.Local());
                    
                    if(cod.Val()){
                    
                        controller.p1m(
                            new ReadWrite(
                                new xml_document(cod.Read(), false), MyFont()
                            )
                        );
                        
                    } else {//if(cod.Val())
                        
                        Err(cod.Type(), cod.Message());
                        
                    }//if(cod.Val())
                    
                }//case readonly
                
                case not ->{
                    
                    /* Abrir o formulário que mostra todos os               **
                    ** itens indisponíveis!                                 **
                    ** Esse mesmo formulário vai ser a tela inicial         **
                    ** sempre que a condição de:                            **
                    ** EXISTE ARQUIVOS INDISPONÍVEIS?                       **
                    ** for verdadeira!                                      **
                    ** coso contrário, diretamente o formulário referente à **
                    ** "xml_config"                                         */
                    
                }//case not
                
            }//switch(id.Cond())
            
        } else {//if(newFont(input))
            
            folder_xml(input);
            
        }//if(newFont(input))
        
    }//folder_xml(Domain menu, String input)
    
}//Action