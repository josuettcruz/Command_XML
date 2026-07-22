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
    
    private final static char[] exclude_document_function = {'<','>',':',';',
        '.',',','!','?', '{','}','[',']','(',')',
        '0','1','2','3','4','5','6','7','8','9'};
    
    public static xml_document_one Document(
        String new_title,
        List<String> input_text_area
    )
    {
        
        xml_document_one val = new xml_document_one();
        
        if(txt.text(new_title, exclude_document_function).isBlank()){
            
            var title = new Data().Load();
            title += "_";
            
            Hora ds = new Hora(true);
            
            title += Reg.Numb(ds.Hour());
            title += "-";
            title += Reg.Numb(ds.Min());
            title += "-";
            title += Reg.Numb(ds.Sec());
            
            val.setTitle(title);
            
        } else {//if(txt.text(doc.getTitle(), exclude).isBlank())
            
            val.setTitle(txt.title(new_title, true));
            
        }//if(txt.text(doc.getTitle(), exclude).isBlank())
        
        List<xml_document_link> dat = new ArrayList();
        
        List<String> tem = new ArrayList();
        
        String tema = "";
        
        for(String v : input_text_area){
            
            Link lnk = new Link(v);
            
            if(tema.isBlank()){
                
                if(lnk.Val()){
                    
                    dat.add(
                        new xml_document_link(
                            lnk.page(true),
                            lnk
                        )
                    );
                    
                } else {//if(lnk.Val())
                    
                    tema = v.trim();
                    
                }//if(lnk.Val())
                
            } else {//if(tema.isBlank())
                
                if(lnk.Val()){
                    
                    dat.add(new xml_document_link(tema,lnk));
                    
                } else {//if(lnk.Val())
                    
                    tem.add(tema);
                    
                }//if(lnk.Val())
                
                tema = "";
                
            }//if(tema.isBlank())
            
        }//for(String val : input_text_area)
        
        if(!tema.isBlank()) tem.add(tema);
        
        val.setText(tem);
        val.setUrl(dat);
        
        return val;
        
    }//Document(xml_document_one doc, String new_title, List<String> input_te...
    
    public static xml_document_one Document(
        xml_document_one doc,
        List<String> input_text_area
    )
    {
        
        xml_document_one val = new xml_document_one();
        
        if(txt.text(doc.getTitle(), exclude_document_function).isBlank()){
            
            var title = new Data().Load();
            title += "_";
            
            Hora ds = new Hora(true);
            
            title += Reg.Numb(ds.Hour());
            title += "-";
            title += Reg.Numb(ds.Min());
            title += "-";
            title += Reg.Numb(ds.Sec());
            
            val.setTitle(title);
            
        } else {//if(txt.text(doc.getTitle(), exclude).isBlank())
            
            val.setTitle(doc.getTitle());
            
        }//if(txt.text(doc.getTitle(), exclude).isBlank())
        
        List<xml_document_link> dat = new ArrayList();
        
        if(!doc.getUrl().isEmpty()) dat.addAll(doc.getUrl());
        
        List<String> tem = new ArrayList();
        
        String tema = "";
        
        for(String v : input_text_area){
            
            Link lnk = new Link(v);
            
            if(tema.isBlank()){
                
                if(lnk.Val()){
                    
                    dat.add(
                        new xml_document_link(
                            lnk.page(true),
                            lnk
                        )
                    );
                    
                } else {//if(lnk.Val())
                    
                    tema = v.trim();
                    
                }//if(lnk.Val())
                
            } else {//if(tema.isBlank())
                
                if(lnk.Val()){
                    
                    dat.add(new xml_document_link(tema,lnk));
                    
                } else {//if(lnk.Val())
                    
                    tem.add(tema);
                    
                }//if(lnk.Val())
                
                tema = "";
                
            }//if(tema.isBlank())
            
        }//for(String val : input_text_area)
        
        if(!tema.isBlank()) tem.add(tema);
        
        val.setText(tem);
        val.setUrl(dat);
        
        return val;
        
    }//Document(xml_document_one doc, List<String> input_text_area)
    
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
                new Domain(12,"dez")
            };
            
            var val = -1;
            
            var tx = "";
            
            for(int i = 0; i < txt.arq(value).length(); i++){
                
                var cont = 0;
                var loop = true;
                
                do{
                    
                    var charAt = tx.isBlank() ? 0 : tx.length()-1;
                    
                    var dm = month[cont].Text();
                    
                    if(charAt < dm.length()){
                        
                        if(dm.charAt(charAt) == txt.arq(value).charAt(i)){
                            
                            tx += dm.charAt(charAt);
                            loop = false;
                            
                        }//if(dm.charAt(charAt) == txt.arq(value).charAt(i))
                        
                    }//if(charAt < dm.length())
                    
                    cont++;
                    
                }while(loop && cont > 0 && cont < month.length);
                
            }//for(int i = 0; i < txt.arq(value).length(); i++)
            
            var proc = 0;
            var in_loop = true;
            
            do{
                
                if(tx.equalsIgnoreCase(month[proc].Text())){
                    
                    val = month[proc].index();
                    in_loop = false;
                    
                }//if(tx.equalsIgnoreCase(month[proc].Text()))
                
                proc++;
                
            }while(in_loop && proc > 0 && proc < month.length);
            
            return val;
            
        }//if(!text.isBlank())
        
    }//month_ComboBox(String value)
    
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
    
    public static void session_confirm(
        boolean mouse,
        xml_document doc,
        xml_document_one one
    )
    {
        
        /* Permitir adição à partir de um arquivo de TEXTO **
        ** simplismente digitando o seu endereço no        **
        ** campo de título!                                **
        ** ----------------------------------------------- **
        ** É importante saber que existe                   **
        ** a possibilidade de isso acontecer também na     **
        ** classe ReadWrite                                */
        
    }//session
    
    public static void session_cancel(
        xml_document doc,
        xml_document_one one
    )
    {
        
        /* SE(título == [título do documento] OU título == ""){
        **   
        **   ESCREVA("Não alterar o documento");
        **   
        ** } SENAO {
        **   
        **   ESCREVAL("Adicionar:");
        **   ESCREVAL("~");
        **   ESCREVAL("Antes do título do documento1");
        **   
        ** } */
        
    }
    
}//Action