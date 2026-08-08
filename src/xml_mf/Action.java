/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
        '0','1','2','3','4','5','6','7','8','9'};
    
    public final static Domain[] session_option = {
        new Domain(0, "Selecione uma opção!"),
        new Domain(1, "Condicionar todo o texto."),
        new Domain(2, "Condicionar Texto."),
        new Domain(3, "Predefinir DATA/HORA"),
        new Domain(4, "Separas por frase."),
        new Domain(5, "Separar por textos da frase.")
    };
    
    public final static int max_session_option = 5;
    
    private static Font EditFont = new java.awt.Font("Verdana", 18, 0);
    
    public static Font[] MyFont(){
        
        java.awt.Font font[] = {
            new java.awt.Font("Impact", 12, 0),
            EditFont
        };
        
        return font;
        
    }//MyFont()
    
    private static Arq dll(){
        
        var file_name_path = "";
        
        if(Reg.java) file_name_path += "\\..";
        
        file_name_path += "java-command_xml.xml";
        
        return new Arq(file_name_path);
        
    }//dll()
    
    private static xml_config xml_config(){
        
        xml_config doc = new xml_config(dll().Read());
        
        return doc;
        
    }//xml_config()
    
    public static void Init(){
        
        controller.PrintKey();
        controller.p1s(new config());
        
    }//Init()
    
    public static void newFont(Font font){EditFont = font;}
    
    public static boolean newFont(String ttf){
        
        if(
            Arq.Dir(ttf, false) &&
            !txt.text(ttf, exclude_document_function).isBlank()
        )
        {
            
            final String[] otf = {"ttf", "otf"};
            
            var ext = "";
            
            for(var i = 0; i < ttf.length(); i++){
                
                switch(ttf.charAt(i)){
                    
                    case '.' -> ext = "";
                    
                    default -> ext += ttf.charAt(i);
                    
                }//switch(ttf.charAt(i))
                
            }//for(var i = 0; i < ttf.length(); i++)
            
            var aply = false;
            
            if(!txt.arq(ext).isBlank()){
                
                var proc = 0;
                
                do{
                    
                    aply = txt.arq(ext).equals(otf[proc]);
                    
                    proc++;
                    
                }while(!aply && proc > 0 && proc < otf.length);
                
            }//if(!txt.arq(ext).isBlank())
            
            return aply;
            
        } else {//if(Arq.Dir(ttf, false) && !txt.text(ttf, exclude_document_f...
            
            return false;
            
        }//if(Arq.Dir(ttf, false) && !txt.text(ttf, exclude_document_function...
        
    }//newFont(String ttf)
    
    public static void Exit(){
        
        if(Reg.java){
            
            System.out.println(Data.code.DataCompleta(true));
            System.out.println(Hora.code.TimerGood(true));
            System.out.println(Hora.Good());
            
        }
        
        System.exit(0);
        
    }//Exit()
    
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
    
    private static String Document(String input){
        
        if(txt.text(input, exclude_document_function).isBlank()){
            
            var title = new Data().Load();
            title += "_";
            
            Hora ds = new Hora(true);
            
            title += Reg.Numb(ds.Hour());
            title += "-";
            title += Reg.Numb(ds.Min());
            title += "-";
            title += Reg.Numb(ds.Sec());
            
            return title;
            
        } else {//if(txt.text(doc.getTitle(), exclude).isBlank())
            
            return txt.title(input, true);
            
        }//if(txt.text(doc.getTitle(), exclude).isBlank())
        
    }//Document(String input)
    
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

        } else {//if(title && !t.isBlank())
            
            val += Hora.Good();
            val += "!";
            if(title) val += " Documento sem título.";
            
        }//if(title && !t.isBlank())
        
        return val;
        
    }//OverrideTitle(xml_document doc, boolean title)
    
    private static int month_ComboBox(String value){
        
        if(txt.arq(value).isBlank()){
            
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
            
            var dm = txt.arq(value);
            
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
                
            }//for(int i = 0; i < txt.arq(value).length(); i++)
            
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
                    : txt.text(line, true);
                
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
                    !txt.text(value.get(i)).isBlank()
                )
                {
                    
                    String t = value.get(i);
                    
                    switch(d.index()){
                        
                        case 2 -> val.add(txt.text(t));
                        
                        case 3 -> {
                            
                            var data = new Data(t.trim());
                            
                            if(data.Val()){
                                
                                val.add(data.Load());
                                
                            } else {//if(data.Val())
                                
                                final var init = -1;
                                
                                var year = init;
                                var month = init;
                                var day = init;
                                
                                for(String tm : txt.phrase(t, true)){
                                    
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
                            
                            var rd = "";
                            
                            for(String r : txt.phrase(value.get(i))){
                                
                                switch(r.charAt(0)){
                                    
                                    case '{', '[', '(' -> {
                                        
                                        if(!rd.isBlank()) val.add(rd);
                                        rd = r;
                                        
                                    }//case '{', '[', '('
                                    
                                    case '"', '\'' -> {
                                        
                                        switch(d.index()){
                                            
                                            case 4 ->{
                                                
                                                if(!rd.isBlank()) rd += " ";
                                                
                                                rd += r;
                                                
                                            }//case 4
                                            
                                            case 5 ->{

                                                if(!rd.isBlank()) val.add(rd);
                                                
                                                rd = r;
                                                
                                            }//case 5
                                            
                                        }//switch(d.index())
                                        
                                    }//case '{', '[', '('
                                    
                                    default ->{
                                        
                                        if(!rd.isBlank()) rd += " ";
                                        rd += r;
                                        
                                    }//default
                                    
                                }//switch(r.charAt(0))
                                
                                switch(r.charAt(r.length()-1)){
                                    
                                    case '.' -> {
                                        
                                        if(r.length() > 4){
                                            
                                            val.add(rd);
                                            rd = "";
                                            
                                        }//if(r.length() > 4)
                                        
                                    }//case '.'
                                    
                                    case ',', '>', '"', '\'' ->{
                                        
                                        if(d.index() == 5){
                                            
                                            val.add(rd);
                                            rd = "";
                                            
                                        }//if(d.index() == 5)
                                        
                                    }//case ',', '>', '"', '\''
                                    
                                    case '?',
                                         '!',
                                         ';',
                                         ':',
                                         '}',
                                         ']',
                                         ')' -> {
                                        
                                        val.add(rd);
                                        rd = "";
                                        
                                    }//cases
                                         
                                }//switch(r.charAt(r.length()-1))
                                
                            }//for(String r : txt.phrase(value.get(i)))
                            
                            if(!rd.isBlank()) val.add(rd);
                            
                        }//case 4, 5
                        
                        default -> val.add(t);
                        
                    }//switch(d.index())
                    
                } else {//if(i == row && !new Link(value.get(i)).Val() &&...
                    
                    val.add(value.get(i));
                    
                }//if(i == row && !new Link(value.get(i)).Val() && !txt.text(...
                
            }//for(var i = 0; i < value.getText().size(); i++)
            
            return val;
            
        }//if(value.isEmpty())
        
    }//session_ComboBox
    
    public static void session_combobox(
        Domain menu,
        xml_document doc,
        xml_document_one one,
        Font font[],
        int row
    )
    {
        
        one.setText(
            session_ComboBox(
                menu,
                one.getText(),
                row
            )
        );
        
        controller.p3(
            new session(
                doc,
                one,
                font
            )
        );
        
    }//session_combobox
    
    public static List<String> session_Document(xml_document_one val){
        
        List<String> value = new ArrayList();
        
        for(xml_document_link l : val.getUrl()){
            
            value.add(l.name());
            value.add(l.lnk().getLink(true));
            
        }//for(xml_document_link l : val.getUrl())
        
        for(String t : val.getText()) value.add(t);
        
        return value;
        
    }//session_Document
    
    public static xml_document_one session_textArea(
        String title,
        List<String> input_text_area
    )
    {
        
        xml_document_one val = new xml_document_one();
        
        val.setTitle(Document(title));
        
        List<xml_document_link> dat = new ArrayList();
        
        List<String> tem = new ArrayList();
        
        String tema = "";
        boolean next_line = false;
        
        for(String v : input_text_area){
            
            if(next_line){
                
                Link lnk = new Link(v);
                
                if(lnk.Val()){
                    
                    String text_link;
                    
                    if(txt.text(tema, exclude_document_function).isBlank()){
                        
                        text_link = lnk.dat(false);
                        
                    } else {//if(txt.text(tema, exclude_document_function).is...
                        
                        text_link = txt.text(tema, next_line);
                        
                    }//if(txt.text(tema, exclude_document_function).isBlank()...
                    
                    dat.add(new xml_document_link(text_link,lnk));
                    
                } else {//if(next_line)
                    
                    tem.add(tema);
                    
                }//if(next_line)
                
                tema = "";
                next_line = false;
                
            } else {//if(next_line)
                
                tema = v;
                next_line = true;
                
            }//if(next_line)
            
        }//for(String val : input_text_area)
        
        if(next_line) tem.add(tema);
        
        val.setText(tem);
        val.setUrl(dat);
        
        return val;
        
    }//session_textArea
    
    private static void session(
        xml_document doc,
        xml_document_one one,
        String title
    )
    {
        
        xml_config xml = xml_config();
        
        doc.Del(one.getTitle());
        
        one.setTitle(Action.Document(title));
        
        doc.Add(one, true);
        
        Arq arq = new Arq(doc.Local(true));
        
        if(arq.Val()){
            
            doc.Save(arq);
            
        } else {//if(arq.Val())
            
            var con = "";
            
            if(xml.Windows()){
                
                if(Arq.Dir(xml.Documents())){
                    
                    con += xml.Documents();
                    
                }//if(Arq.Dir(xml.Documents()))
                
            }//if(xml.Windows())
            
            con += Data.code.Load();
            con += "_";
            con += Reg.Numb(Hora.code.Hour());
            con += "-";
            con += Reg.Numb(Hora.code.Min());
            con += "-";
            con += Reg.Numb(Hora.code.Sec());
            con += ".xml";
            
            doc.Save(new Arq(con));
            
        }//if(arq.Val())
        
        var read = xml.learn();
        
        List<String> node = new ArrayList();
        
        for(xml_config_one o : read) node.add(o.Local());
        
        var cod = Order.Proc(node, doc.Local(true));
        
        if(!read.isEmpty() && cod >= 0 && cod < read.size()){
            
            xml.Del(cod);
            
            var rew = xml.learn().get(cod);
            
            rew.Update(Data.code, Hora.code);
            
            xml.Add(rew);
            
        } else {//if(!read.isEmpty() && cod >= 0 && cod < read.size())
            
            //xml_config_one c = new xml_config_one(doc.getTitle(), doc.Local(true), doc.[read], Data.code, Hora.code);
            
        }//if(!read.isEmpty() && cod >= 0 && cod < read.size())
        
        var ok = xml.Save(dll());
        
        if(!ok.Val()) Action.Err(ok.Type(), ok.Message());
        
    }//session
    
    public static void session_confirm(
        xml_document doc,
        xml_document_one one,
        String title
    )
    {
        
        if(Action.newFont(title)){
            
            controller.p2(new newFont(doc, one, Arq.Files(title), MyFont()));
            
        } else {//if(Action.newFont(title))
            
            Action.session(doc, one, title);
            
        }//if(Action.newFont(title))
        
    }//session_confirm
    
    public static void session_save_temp(
        xml_document doc,
        xml_document_one one,
        String title
    ){
        
        var node = "~";
            
        node += txt.text(one.getTitle()).charAt(0) == '~'
            ? txt.AddRepeat(one.getTitle())
            : one.getTitle();
        
        if(txt.phrase(title, exclude_document_function).size() > 1){
            
            node += " - ";
            node += title;
            
        }//if(txt.phrase(title, exclude_document_function).size() > 1)
        
        one.setTitle(node);
        
        session(doc, one, title);
        
    }//session_save_temp
    
    public static void session_cancel(
        xml_document doc,
        xml_document_one one,
        String title
    )
    {
        
        var txt1 = "";
        
        for(String p : txt.phrase(one.getTitle()))
        {txt1 += txt.arq(p);}
        
        var proc = 0;
        var find = -1;
        
        do{
            
            var txt_a1 = "";
            
            for(String p : txt.phrase(doc.List().get(proc).getTitle()))
            {txt_a1 += txt.arq(p);}
            
            if(txt1.equals(txt_a1)) find = proc;
            
            proc++;
            
        }while(find < 0 && proc > 0 && proc < doc.List().size());
        
        if(find >= 0){
            
            xml_document_one done = doc.List().get(find);
            
            var txt2 = "";
            
            if(done.getText().isEmpty()){
                
                for(String x : done.getText()){
                    
                    if(!txt.phrase(x).isEmpty())
                    {for(String y : txt.phrase(x)) {txt2 += txt.arq(y);}}
                    
                }//for(String x : done.getText())
                
            }//if(done.getText().isEmpty())
            
            var txt3 = "";
            
            if(!one.getText().isEmpty()){
                
                for(String x : one.getText()){
                    
                    if(!txt.phrase(x).isEmpty())
                    {for(String y : txt.phrase(x)) {txt3 += txt.arq(y);}}
                    
                }//for(String x : one.getText())
                
            }//if(!one.getText().isEmpty())
            
            var cond1a = txt2.equals(txt3);
            var cond1b = txt.text(txt2,exclude_document_function).isBlank();
            var cond1 = cond1a || cond1b;
            
            var txt4 = "";
            
            if(!txt.phrase(title).isEmpty()){
                
                for(String x : txt.phrase(title)){
                    
                    if(!txt.phrase(x).isEmpty()){
                        
                        for(String y : txt.phrase(x))
                        {txt4 += txt.arq(y);}
                        
                    }//if(!txt.phrase(x).isEmpty())
                    
                }//for(String x : txt.phrase(title))
                
            }//if(!txt.phrase(title).isEmpty())
            
            var txt5 = "";
            
            if(!txt.phrase(done.getTitle()).isEmpty()){
                
                for(String x : txt.phrase(done.getTitle())){
                    
                    if(!txt.phrase(x).isEmpty()){
                        
                        for(String y : txt.phrase(x))
                        {txt5 += txt.arq(y);}
                        
                    }//if(!txt.phrase(x).isEmpty())
                    
                }//for(String x : txt.phrase(title))
                
            }//if(!txt.phrase(title).isEmpty())
            
            var cond2a = txt4.equals(txt5);
            var cond2b = txt.text(txt4,exclude_document_function).isBlank();
            var cond2 = cond2a || cond2b;
            
            if(cond1 && cond2){
                
                controller.p1m(
                    new ReadWrite(
                        doc,
                        MyFont(),
                        txt.text(title, true)
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
                    
                    cond = txt.phrase(
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
                        txt.text(title, true)
                    )
                );
                
            } else {//if(cond)
                
                session_save_temp(doc, one, title);
                
            }//if(cond)
            
        }//if(find >= 0)
        
    }//session_cancel
    
    public static void ReadWrite(xml_document doc,String input){
        
        if(Action.newFont(input)){
            
            controller.p2(new newFont(doc, Arq.Files(input), MyFont()));
            
        } else {//if(Action.newFont(input))
            
            xml_document_one novo = new xml_document_one();
            
            novo.setTitle(
                txt.text(
                    input,
                    Action.exclude_document_function
                ).isBlank() ? "" : txt.title(input, true)
            );
            
            controller.p2(new DocumentView(doc, novo, MyFont()));
            
        }//if(Action.newFont(input))
        
    }//ReadWrite(xml_document doc,String input)
    
    public static void ReadWrite(
        xml_document doc,
        xml_document_one one,
        String input
    )
    {
        
        if(
            txt.text(
                input,
                Action.exclude_document_function
            ).isBlank()
        )
        {
            
            if(Action.newFont(input)){
                
                controller.p2(new newFont(doc, Arq.Files(input), MyFont()));
                
            } else {//if(Action.newFont(input))
                
                controller.p2(new DocumentView(doc,one,MyFont()));
                
            }//if(Action.newFont(input))
            
        } else {//if(txt.text...
            
            ReadWrite(doc, input);
            
        }//if(txt.text...
        
    }//ReadWrite(xml_document doc, xml_document_one one, String input)
    
    public static void folder_xml(xml_config xml, String input){
        
        if(newFont(input)){
            
            controller.p2(new newFont(xml, Arq.Files(input), MyFont()));
            
        } else {//if(newFont(input))
            
            /* Executar uma ação que só será possível   **
            ** quando o projeto avançar                 **
            ** para a criação do arquivo geral que      **
            ** guardará todos os arquivos XMLs recenter */
            
        }//if(newFont(input))
        
    }//folder_xml(String input)
    
    public static void folder_xml(xml_config xml, Domain menu, String input){
        
        if(newFont(input)){
            
            controller.p2(new newFont(xml, Arq.Files(input), MyFont()));
            
        } else if(
            menu.index() >= 0 &&
            menu.index() < xml.learn().size() &&
            !xml.learn().isEmpty()
        )
        {
            
            controller.p1s(
                new ReadWrite(
                    new xml_document(
                        xml.learn().get(menu.index()).File(),
                        xml.learn().get(menu.index()).Cond() == write
                    ),
                    MyFont(),
                    txt.title(input, true)
                )
            );
            
        } else {//if(newFont(input))
            
            folder_xml(xml, input);
            
        }//if(newFont(input))
        
    }//folder_xml(Domain menu, String input)
    
}//Action