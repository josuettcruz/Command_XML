/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.*;
import model.*;
import xml_rw.*;
import file.Arq;

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
    
    public static void newFont(Font font){EditFont = font;}
    
    public static void Init(){
        
        controller.PrintKey();
        controller.p1s(new config());
    
    }//Action()
    
    private static boolean newFont(String ttf){
        
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
        
        /* LOGICO ide_execute = Reg.java;              **
        **                                             **
        ** SE(ide_execute){                            **
        **   ESCREVAL("System.out.println(\"...\");"); **
        ** }                                           **
        **                                             **
        ** ESCREVAL("System.exit(0);");                */
        
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
            value.add(l.lnk().getLink());
            
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
    
    public static void session_confirm(
        boolean mouse,
        xml_document doc,
        xml_document_one one,
        String title
    )
    {
        
        doc.Del(one.getTitle());
        
        one.setTitle(Action.Document(title));
        
        doc.Add(one, true);
        
        /* undefined Java code **
        
        Arq xml = new Arq([LOCAL DO ARQUIVO XML]);
        
        doc.Save(xml);
        
        xml_config comment = new xml_config(new Arq([ARQUIVO PADRÃO]).Read());
        
        comment.Del(doc.getTitle());
        
        comment.Add(xml.Read());
        
        ** undefined Java code */
        
    }//session_confirm
    
    public static void session_cancel(
        xml_document doc,
        xml_document_one one,
        String title
    )
    {
        
        /* CADEIA antigo_titulo == one.getTitle();               **
        ** CADEIA novo_titulo == title.trim();                   **
        **                                                       **
        ** SE(new_título == antigo_titulo OU novo_titulo == ""){ **
        **                                                       **
        **   ESCREVA("Não alterar o documento");                 **
        **                                                       **
        ** } SENAO {                                             **
        **                                                       **
        **   ESCREVAL("Adicionar:");                             **
        **   ESCREVAL("~");                                      **
        **   ESCREVAL("Antes do título do documento!");          **
        **                                                       **
        ** }                                                     */
        
    }//session_cancel
    
    public static void ReadWrite(
        xml_document doc,
        xml_document_one one,
        String input
    )
    {
        
        /* Essa classe           **
        ** será chamada          **
        ** sempre que houver     **
        ** itens selecionados na **
        ** classe "ReadWrite"    */
        
        if(doc.Write()){
            
            /* Abrir formulário de ações        **
            ** que ficará em uma classe         **
            ** que ainda será criada, mas       **
            ** com a opção de Abrir adicionada! */
            
            controller.p3(new session(doc, one, MyFont()));
            
        } else {//if(doc.Write())
            
            /* Abrir formulário de ações **
            ** que ficará em uma classe  **
            ** que ainda será criada!    */
            
        }//if(doc.Write())
        
    }//ReadWrite(xml_document doc, xml_document_one one, String input)
    
    public static void ReadWrite(xml_document doc, String input){
        
        ReadWrite(doc, new xml_document_one(), input);
        
        /* Essa classe será chamada      **
        ** quando não houver             **
        ** itens selecionados!           **
        ** ----------------------------- **
        ** Existe a possibilidade de que **
        ** o chamado da função a cima    **
        ** seja substituído per uma      **
        ** ação completamente diferente! **
        ** Caso isso não ocorra,         **
        ** deixar essa classe            **
        ** chamando a classe de cima!    */
        
    }//ReadWrite(xml_document doc, String input)
    
    public static void folder_xml(Domain select, String input){
        
        /* É aquí que vai ficar a              **
        ** classe Arquivo                      **
        ** que iniciará a                      **
        ** classe "xml document"               **
        ** ----------------------------------- **
        ** Essa função será chamaa quando,     **
        ** um ou mais itens forem selecionado! */
        
    }//folder_xml(Domain select, String input)
    
    public static void folder_xml(String input){
        
        /* É aquí que vai ficar a            **
        ** classe Arquivo                    **
        ** que iniciará a                    **
        ** classe "xml document"             **
        ** --------------------------------- **
        ** Essa função será chamaa quando,   **
        ** nenhum intem estiver selecionado! */
        
    }//folder_xml(String input)
    
}//Action