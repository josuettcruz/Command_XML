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
    private String[] local;
    
    public xml_config(Read arq, Integer tab){
        
        this.list = new ArrayList();
        
        this.tab_space = tab;
        
        this.local = new String[Arq.Folder(arq.Arq()).size()];
        
        for(int i = 0; i < Arq.Folder(arq.Arq()).size(); i++)
        {this.local[i] = Arq.Folder(arq.Arq()).get(i);}
        
        var tag = "null";
        
        var title = "";
        var file = "";
        
        var create = false;
        var create_year = new Data().getDate().getYear();
        var create_month = 1;
        var create_day = 1;
        var create_hour = 0;
        var create_minute = 0;
        var create_second = 0;
        
        var modify = false;
        var modify_year = new Data().getDate().getYear();
        var modify_month = 1;
        var modify_day = 1;
        var modify_hour = 0;
        var modify_minute = 0;
        var modify_second = 0;
        
        for(Tag t : new xml(arq.Read()).Tag()){
            
            if(
                t.txt().equalsIgnoreCase("document") &&
                t.Value().equalsIgnoreCase("tag") &&
                !title.isEmpty() &&
                !file.isEmpty()
            )
            {//if(t.OpenTag())
                
                this.list.add(
                    new xml_config_one(
                        title,
                        new Arq(file).Read(),
                        new Data(create_year, create_month, create_day),
                        new Hora(create_hour, create_minute, create_second),
                        new Data(modify_year, modify_month, modify_day),
                        new Hora(modify_hour, modify_minute, modify_second)
                    )
                );

                title = "";
                file = "";

                create = false;
                create_year = 1972;
                create_month = 1;
                create_day = 1;
                create_hour = 0;
                create_minute = 0;
                create_second = 0;

                modify = false;
                modify_year = 1972;
                modify_month = 1;
                modify_day = 1;
                modify_hour = 0;
                modify_minute = 0;
                modify_second = 0;
                
            } else if(t.OpenTag()){//if(t.OpenTag())
                
                tag = t.txt();
                
            } else if(t.CloseTag()){//if(t.OpenTag())
                
                tag = "null";
                
            } else {//if(t.OpenTag())
                
                switch(tag){
                    
                    case "title" -> title = t.txt();
                    
                    case "file" -> file = t.txt();
                    
                    case "create" -> {
                        
                        create = true;
                        modify = false;
                        
                    }//case "create"
                    
                    case "modify" -> {
                        
                        create = false;
                        modify = true;
                        
                    }//case "modify"
                    
                    case "year" ->{
                        
                        var n = new Num(t.txt());
                        
                        if(n.Val() && n.Num() >= 1972){
                            
                            if(create){
                                
                                create_year = n.Num();
                                modify_year = n.Num();
                                
                            }//if(create)
                            
                            if(modify){
                                
                                modify_year = n.Num();
                                
                            }//if(modify)
                            
                        }//if(n.Val() && n.Num() >= 1972)
                        
                    }//case "year"
                    
                    case "month" ->{
                        
                        var n = new Num(t.txt());
                        
                        if(n.Val() && n.Num() >= 1 && n.Num() <= 12){
                            
                            if(create){
                                
                                create_month = n.Num();
                                modify_month = n.Num();
                                
                            }//if(create)
                            
                            if(modify){
                                
                                modify_month = n.Num();
                                
                            }//if(modify)
                            
                        }//if(n.Val() && n.Num() >= 1 && n.Num() <= 12)
                        
                    }//case "month"
                    
                    case "day" ->{
                        
                        var n = new Num(t.txt());
                        
                        if(n.Val() && n.Num() >= 1 && n.Num() <= 31){
                            
                            if(create){
                                
                                create_day = n.Num();
                                modify_day = n.Num();
                                
                            }//if(create)
                            
                            if(modify){
                                
                                modify_day = n.Num();
                                
                            }//if(modify)
                            
                        }//if(n.Val() && n.Num() >= 1 && n.Num() <= 31)
                        
                    }//case "day"
                    
                    case "hour" ->{
                        
                        var n = new Num(t.txt());
                        
                        if(n.Val() && n.Num() >= 0 && n.Num() < 24){
                            
                            if(create){
                                
                                create_hour = n.Num();
                                modify_hour = n.Num();
                                
                            }//if(create)
                            
                            if(modify){
                                
                                modify_hour = n.Num();
                                
                            }//if(modify)
                            
                        }//if(n.Val())
                        
                    }//case "hour"
                    
                    case "minute" ->{
                        
                        var n = new Num(t.txt());
                        
                        if(n.Val() && n.Num() >= 0 && n.Num() < 60){
                            
                            if(create){
                                
                                create_minute = n.Num();
                                modify_minute = n.Num();
                                
                            }//if(create)
                            
                            if(modify){
                                
                                modify_minute = n.Num();
                                
                            }//if(modify)
                            
                        }//if(n.Val() && n.Num() >= 0 && n.Num() < 60)
                        
                    }//case "minute"
                    
                    case "second" ->{
                        
                        var n = new Num(t.txt());
                        
                        if(n.Val() && n.Num() >= 0 && n.Num() < 60){
                            
                            if(create){
                                
                                create_second = n.Num();
                                modify_second = n.Num();
                                
                            }//if(create)
                            
                            if(modify){
                                
                                modify_second = n.Num();
                                
                            }//if(modify)
                            
                        }//if(n.Val() && n.Num() >= 0 && n.Num() < 60)
                        
                    }//case "second"
                    
                }//switch(tag)
                
            }//if(t.OpenTag())
            
        }//for(Tag t : new xml(arq.Read()).Tag())
        
    }//xml_config(Read arq, Integer tab
    
    private String Tab(int tab, String tema){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*this.tab_space);
            
        }//if(tab > 1)
        
        value += tema;
        
        return value;
    
    }//Tab(int tab, String tema)
    
    public Exec Save(Arq save){
        
        List<String> exp = new ArrayList();
        
        exp.add(this.Tab(1, Reg.xmls));
        
        if(this.list.isEmpty()){
            
            exp.add(this.Tab(1, "<root url=\"" + Reg.http + "\">"));
            exp.add(this.Tab(2, "<document></document>"));
            
        } else {//if(this.list.isEmpty())
            
            exp.add(
                this.Tab(
                    1,
                    "<root url=\"" +
                    Reg.http +
                    "\" count=\"" +
                    this.list.size() +
                    "\">"
                )
            );
            
            int cont = 1;
            
            for(xml_config_one doc : this.list){
                
                exp.add(
                    this.Tab(
                        2,
                        "<document id=\"" +
                        Reg.Numb(
                            cont,
                            this.list.size()
                        ) +
                        "\">"
                    )
                );
                
                var dt = !doc.InsertData().CompareTo(doc.ModifyData());
                var ht = doc.InsertHora().getHora()
                        != doc.ModifyHora().getHora();
                
                exp.add(this.Tab(3, "<title>" + doc.Title() + "</title>"));
                
                var a = "<file acept=\"";
                a += doc.Cond().Desc();
                a += "\">";
                a += doc.File().Arq();
                a += "</file>";
                
                exp.add(this.Tab(3, a));
                
                exp.add(this.Tab(3, "<create>"));
                
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
                        "<month>" +
                        doc.InsertData().getDate().getMonthValue() +
                        "</month>"
                    )
                );
                
                exp.add(
                    this.Tab(
                        5,
                        "<day>" +
                        doc.InsertData().getDate().getDayOfMonth() +
                        "</day>"
                    )
                );
                
                exp.add(this.Tab(4, "</date>"));
                
                exp.add(this.Tab(4, "<time>"));
                
                exp.add(
                    this.Tab(
                        5,
                        "<hour>" +
                        doc.InsertHora().Hour() +
                        "</hour>"
                    )
                );
                
                exp.add(
                    this.Tab(
                        5,
                        "<minute>" +
                        doc.InsertHora().Min() +
                        "</minute>"
                    )
                );
                
                if(doc.InsertHora().Sec() > 0){
                    
                    exp.add(
                        this.Tab(
                            5,
                            "<second>" +
                            doc.InsertHora().Sec() +
                            "</second>"
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
                                "<year>" +
                                doc.ModifyData().getDate().getYear() +
                                "</year>"
                            )
                        );
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<month>" +
                                doc.ModifyData().getDate().getMonthValue() +
                                "</month>"
                            )
                        );
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<day>" +
                                doc.ModifyData().getDate().getDayOfMonth() +
                                "</day>"
                            )
                        );
                        
                        exp.add(this.Tab(4, "</date>"));
                        
                    }//if(dt)
                    
                    if(ht){
                        
                        exp.add(this.Tab(4, "<time>"));
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<hour>" +
                                doc.ModifyHora().Hour() +
                                "</hour>"
                            )
                        );
                        
                        exp.add(
                            this.Tab(
                                5,
                                "<minute>" +
                                doc.ModifyHora().Min() +
                                "</minute>"
                            )
                        );
                        
                        if(doc.ModifyHora().Sec() > 0){
                            
                            exp.add(
                                this.Tab(
                                    5,
                                    "<second>" +
                                    doc.ModifyHora().Sec() +
                                    "</second>"
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
    
    public boolean Update(Data d, Hora h, int pos){
        
        if(pos >= 0 && pos < this.list.size()){
            
            var doc = this.list.get(pos);
            
            doc.modify(d, h);
            
            this.list.set(pos, doc);
            
            return true;
            
        } else {//if(pos >= 0 && pos < this.list.size())
            
            return false;
            
        }//if(pos >= 0 && pos < this.list.size())
        
    }//Update(Data d, Hora h, int pos)
    
    public boolean Update(Hora h, int pos){
        
        if(pos >= 0 && pos < this.list.size()){
            
            var doc = this.list.get(pos);
            
            doc.modify(h);
            
            this.list.set(pos, doc);
            
            return true;
            
        } else {//if(pos >= 0 && pos < this.list.size())
            
            return false;
            
        }//if(pos >= 0 && pos < this.list.size())
        
    }//Update(Hora h, int pos)
    
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