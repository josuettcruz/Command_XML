/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import file.*;
import execute.*;
import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class xml_config {
    
    private List<xml_config_one> list;
    private Integer tab_space;
    
    private void init(Read arq, Integer tab){
        
        this.list = new ArrayList();
        
        this.tab_space = tab;
        
        String receive[] = new String[2];
        
        for(int i = 0; i < receive.length; i++) receive[i] = "null";
        
        var left = 0;
        
        for(Tag t : new xml(arq.Read()).Tag()){
            
            switch(t.Value()){
                
                case "txt", "val" -> {
                    
                    var tem = t.txt();
                    
                    switch(left){
                        
                        case 1 ->{
                            
                            switch(receive[0]){
                                
                                case "document" ->{
                                    
                                    System.out.print("Documento: \"");
                                    System.out.print(tem);
                                    System.out.println("\"");
                                    
                                }//case "document"
                                
                            }//switch(receive[0])
                            
                        }//case 1
                        
                        case 2 ->{
                            
                            switch(receive[0]){
                                
                                case "arquivo" ->{
                                    
                                    switch(receive[1]){
                                        
                                        case "date" -> {
                                            
                                            Data d = new Data(tem);
                                            
                                            if(d.Val()){
                                                
                                                System.out.println(
                                                    d.DataCompleta(true)
                                                );
                                                
                                            }//if(d.Val())
                                            
                                        }//case "date"
                                        
                                        case "hour" -> {
                                            
                                            Hora h = new Hora(tem);
                                            
                                            if(h.Val()){
                                                
                                                System.out.println(
                                                    h.TimerGood(false)
                                                );
                                                
                                            }//if(h.Val())
                                            
                                        }//case "hour"
                                        
                                    }//switch(receive[1])
                                    
                                }//case "document"
                                
                            }//switch(receive[0])
                            
                        }//case 2
                        
                    }//switch(left)
                    
                }//case "txt", "val"
                
                case "tag" ->{
                    
                    if(t.txt().equalsIgnoreCase("root"))
                    {left = 1;}
                    
                    if(left > 0) receive[0] = t.txt().toLowerCase();
                
                }//case "tag"
                
                case "attr" ->{
                    
                    if(t.txt().equalsIgnoreCase("/")){
                        
                        left--;
                    
                    } else {//if(t.txt().equalsIgnoreCase("/"))
                        
                        receive[1] = t.txt().toLowerCase();
                        
                    }//if(t.txt().equalsIgnoreCase("/"))
                
                }//case "attr"
                
                default ->{
                    
                    System.exit(0);
                    
                }//default
                
            }//switch(t.Value())
            
            if(t.OpenTag() && left > 0) left++;
            
            if(t.CloseTag() && left > 0) left--;
            
        }
        /* for(Tag t : new xml(arq.Read()).Tag()) **
        ** line "31"                              **
        ** 23/05/2026 - 16:00                     **
        ** Tudo vai ficar como comentário!        */
        
    }//xml_config()
    
    public xml_config(Read arq, Integer tab){
        
        this.init(arq, tab);
        
    }//xml_config(Read arq, Integer tab)
    
    public xml_config(Read arq){
        
        this.init(arq, 3);
        
    }//xml_config(Read arq)
    
    private String Tab(int tab, String tema){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*2);
            
        }//if(tab > 1)
        
        value += tema;
        
        return value;
    
    }//Tab(int tab, String tema)
    
    public Exec Save(Arq save){
        
        List<String> exp = new ArrayList();
        
        exp.add(this.Tab(1, "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
        // https://www.w3schools.com/xml/xml_usedfor.asp
        
        exp.add(this.Tab(1, "<root>"));
        
        if(this.list.isEmpty()){
            
            exp.add(this.Tab(2, "<document></document>"));
            
        } else {//if(this.list.isEmpty())
            
            for(xml_config_one doc : this.list){
                
                exp.add(this.Tab(2, "<document>"));
                
                var dt = !doc.InsertData().CompareTo(doc.ModifyData());
                var ht = doc.InsertHora().getHora() != doc.ModifyHora().getHora();
                
                exp.add(this.Tab(3, "<title>" + doc.Title() + "</title>"));
                
                var a = "<fifle exist=\"";
                a += doc.Arq().Val() ? "True" : "False";
                a += "\">";
                a += doc.Arq().Arq();
                a += "</file>";
                
                exp.add(this.Tab(3, a));
                
                exp.add(this.Tab(3, "</create>"));
                
                exp.add(this.Tab(4, "<date>"));
                
                exp.add(
                    this.Tab(
                        5,
                        "<year>"
                        + doc.InsertData().getDate().getYear()
                        + "</year>"
                    )
                );
                
                exp.add(
                    this.Tab(
                        5,
                        "<month>"
                        + doc.InsertData().getDate().getMonthValue()
                        + "</month>"
                    )
                );
                
                exp.add(
                    this.Tab(
                        5,
                        "<day>"
                        + doc.InsertData().getDate().getDayOfMonth()
                        + "</day>"
                    )
                );
                
                exp.add(this.Tab(4, "</date>"));
                
                exp.add(this.Tab(4, "<time>"));
                
                exp.add(
                    this.Tab(
                        5,
                        "<hour>"
                        + doc.InsertHora().Hour()
                        + "</hour>"
                    )
                );
                
                exp.add(
                    this.Tab(
                        5,
                        "<minute>"
                        + doc.InsertHora().Min()
                        + "</minute>"
                    )
                );
                
                if(doc.InsertHora().Sec() > 0){
                    
                    exp.add(
                        this.Tab(
                            5,
                            "<second>"
                            + doc.InsertHora().Sec()
                            + "</second>"
                        )
                    );
                    
                }//if(doc.Hora().Sec() > 0)
                
                exp.add(this.Tab(4, "</time>"));
                
                exp.add(this.Tab(3, "</create>"));
                
                if(dt || ht){
                    
                    exp.add(this.Tab(3, "<modify>"));
                    
                    if(dt){
                        
                        exp.add(this.Tab(4, "<date>"));
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<year>"
                                + doc.ModifyData().getDate().getYear()
                                + "</year>"
                            )
                        );
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<month>"
                                + doc.ModifyData().getDate().getMonthValue()
                                + "</month>"
                            )
                        );
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<day>"
                                + doc.ModifyData().getDate().getDayOfMonth()
                                + "</day>"
                            )
                        );
                        
                        exp.add(this.Tab(4, "</date>"));
                        
                    }//if(dt)
                    
                    if(ht){
                        
                        exp.add(this.Tab(4, "<time>"));
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<hour>"
                                + doc.ModifyHora().Hour()
                                + "</hour>"
                            )
                        );
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<minute>"
                                + doc.ModifyHora().Min()
                                + "</minute>"
                            )
                        );
                        
                        if(doc.ModifyHora().Sec() > 0){
                            
                            exp.add(
                                this.Tab(
                                    5,
                                    "<second>"
                                    + doc.ModifyHora().Sec()
                                    + "</second>"
                                )
                            );
                            
                        }//if(doc.Hora().Sec() > 0)
                        
                        exp.add(this.Tab(4, "</time>"));
                        
                    }//if(ht)
                    
                    exp.add(this.Tab(3, "</modify>"));
                    
                }//if(dt || ht)
                
                exp.add(this.Tab(2, "</document>"));
                
            }//for(xml_config_one d : this.list)
            
        }//if(this.list.isEmpty())
        
        exp.add(this.Tab(1, "</root>"));
        
        return save.Save(exp);
        
    }//Save(Arq save)
    
    public void Insert(xml_config_one insert){
        
        this.list.add(insert);
        
    }//Insert(xml_config_one insert)
    
    public void Insert(xml_config_one insert, int position){
        
        if(position >= 0 && position < this.list.size()){
            
            List<xml_config_one> done = new ArrayList();
            
            done.addAll(this.list);
            
            this.list.clear();
            
            for(int i = 0; i < done.size(); i++){
                
                if(i == position) this.list.add(insert);
                
                this.list.add(done.get(i));
                
            }//for(int i = 0; i < done.size(); i++)
            
        }//if(position >= 0 && position < this.list.size())
        
    }//Insert(xml_config_one insert, int position)
    
    public void Insert(List<xml_config_one> insert, int position){
        
        if(position >= 0 && position < this.list.size()){
            
            List<xml_config_one> done = new ArrayList();
            
            done.addAll(this.list);
            
            this.list.clear();
            
            for(int i = 0; i < done.size(); i++){
                
                if(i == position) this.list.addAll(insert);
                
                this.list.add(done.get(i));
                
            }//for(int i = 0; i < done.size(); i++)
            
        }//if(position >= 0 && position < this.list.size())
        
    }//Insert(List<xml_config_one> insert, int position)
    
    public void remove(int position){
        
        if(position >= 0 && position < this.list.size()){
            
            List<xml_config_one> done = new ArrayList();
            
            done.addAll(this.list);
            
            this.list.clear();
            
            for(int i = 0; i < done.size(); i++){
                
                if(i != position){this.list.add(done.get(i));}
                
            }//for(int i = 0; i < done.size(); i++)
            
        }//if(position >= 0 && position < this.list.size())
        
    }//remove(int position)
    
    public void remove(int min, int max){
        
        if(
            min >= 0 &&
            max >= 0 &&
            min < this.list.size() &&
            max < this.list.size() &&
            min < max
        )
        {
            
            List<xml_config_one> done = new ArrayList();
            
            done.addAll(this.list);
            
            this.list.clear();
            
            for(int i = 0; i < done.size(); i++){
                
                if(i < min && i > max){this.list.add(done.get(i));}
                
            }//for(int i = 0; i < done.size(); i++)
            
        }//if(min >= 0 && max >= 0 && min < this.list.size() && max < this...
        
    }//remove(int min, int max)
    
    public List<xml_config_one> learn(){
        
        return this.list;
        
    }//learn()
    
}//xml_config