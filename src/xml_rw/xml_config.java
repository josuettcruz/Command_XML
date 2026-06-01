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
    private String[] local;
    private String user;
    private boolean user_in;
    
    public xml_config(Read arq){
        
        this.user = "";
        this.user_in = false;
        
        this.local = new String[Arq.Folder(arq.Arq()).size()];
        
        for(int i = 0; i < Arq.Folder(arq.Arq()).size(); i++)
        {this.local[i] = Arq.Folder(arq.Arq()).get(i);}
        
        if(Reg.xml(arq)) this.Event(arq);
        
    }//xml_config(Read arq, Integer tab)
    
    private void Event(Read arq){
        
        var o = new Order<xml_config_one>();
        
        var l_val = 0;
        var l_cont = 0;
        
        do{
            
            if(l_val == 2 && !this.local[l_cont].equalsIgnoreCase("one-drive")){
                
                this.user = this.local[l_cont];
                this.user_in = true;
                
                l_val = -1;
                
            }//if(l_val == 2)
            
            switch(this.local[l_cont].toLowerCase()){
                
                case "c:" -> {if(l_val == 0) {l_val = 1;}}
                
                case "users", "user" -> {if(l_val == 1) {l_val = 2;}}
                
            }//switch(node)
            
            l_cont++;
            
        }while(l_val >= 0 && l_cont > 0 && l_cont < this.local.length);
        
        var xml_user = 0;
        
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
        
        var set_acept = 0;
        var is_acept = "";
        
        for(Tag t : new xml(arq.Read()).Tag()){
            
            if(this.user.isBlank()){
                
                if(t.OpenTag() && t.txt().equalsIgnoreCase("root")){
                    
                    xml_user = 1;
                    
                } else if(
                    t.AttrName() &&
                    t.txt().equalsIgnoreCase("user") &&
                    xml_user == 1
                )
                {
                    
                    xml_user = 2;
                    
                } else if(
                    t.AttrVal() &&
                    xml_user == 2
                )
                {
                    
                    this.user = txt.text(t.txt(), true);
                    
                }//if -- if(this.user.isBlank())
                
            }//if(this.user.isBlank())
            
            if(
                t.OpenTag() &&
                t.txt().equalsIgnoreCase("file") &&
                set_acept == 0
            ) {set_acept = 1;}
            
            if(
                t.AttrName() &&
                t.txt().equalsIgnoreCase("acept") &&
                set_acept == 1
            ) {set_acept = 2;}
            
            if(t.Value().equalsIgnoreCase("val") && set_acept == 2){
                
                set_acept = 3;
                is_acept = t.txt();
                
            }//if(t.Value().equalsIgnoreCase("val") && set_acept == 2)
            
            if(
                t.Tag() &&
                t.txt().equalsIgnoreCase("document") &&
                !title.isEmpty() &&
                !file.isEmpty()
            )
            {//if(t.Tag())
                
                xml_config_file_cond dll;
                
                if(Arq.Dir(file, true)){
                    
                    dll = xml_config_file_cond.write;
                    
                } else if(Arq.Dir(file, false)){//if(Arq.Dir(file, true))
                    
                    dll = xml_config_file_cond.readonly;
                    
                } else {//if(Arq.Dir(file, true))
                    
                    dll = xml_config_file_cond.not;
                    
                }//if(Arq.Dir(file, true))
                
                if(!is_acept.equalsIgnoreCase(dll.Desc()) && set_acept == 3){
                    
                    Data d = new Data();
                    Hora h = new Hora(true);
                    
                    modify_year = d.getDate().getYear();
                    modify_month = d.getDate().getMonthValue();
                    modify_day = d.getDate().getDayOfMonth();
                    
                    modify_hour = h.Hour();
                    modify_minute = h.Min();
                    modify_second = h.Sec();
                    
                }//if(set_acept.equalsIgnoreCase(dll.Desc()))
                
                o.Add(
                    new xml_config_one(
                        title,
                        new Arq(file).Read(),
                        dll,
                        new Data(create_year, create_month, create_day),
                        new Hora(create_hour, create_minute, create_second),
                        new Data(modify_year, modify_month, modify_day),
                        new Hora(modify_hour, modify_minute, modify_second)
                    ),
                    title
                );

                title = "";
                file = "";

                create = false;
                create_year = new Data().getDate().getYear();
                create_month = 1;
                create_day = 1;
                create_hour = 0;
                create_minute = 0;
                create_second = 0;

                modify = false;
                modify_year = new Data().getDate().getYear();
                modify_month = 1;
                modify_day = 1;
                modify_hour = 0;
                modify_minute = 0;
                modify_second = 0;
                
                set_acept = 0;
                is_acept = "";
                
            } else if(t.OpenTag()){//if(t.Tag())
                
                tag = t.txt();
                
            } else if(t.CloseTag()){//if(t.Tag())
                
                tag = "null";
                
            } else if(t.Text()){//if(t.Tag())
                
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
                
            }//if(t.Tag())
            
        }//for(Tag t : new xml(arq.Read()).Tag())
        
        // Garantir que o último...
        // seja lido
        if(!title.isBlank() && !file.isBlank()){
            
            xml_config_file_cond dll;

            if(Arq.Dir(file, true)){

                dll = xml_config_file_cond.write;

            } else if(Arq.Dir(file, false)){//if(Arq.Dir(file, true))

                dll = xml_config_file_cond.readonly;

            } else {//if(Arq.Dir(file, true))

                dll = xml_config_file_cond.not;

            }//if(Arq.Dir(file, true))
            
            o.Add(
                new xml_config_one(
                    title,
                    new Arq(file).Read(),
                    dll,
                    new Data(create_year, create_month, create_day),
                    new Hora(create_hour, create_minute, create_second),
                    new Data(modify_year, modify_month, modify_day),
                    new Hora(modify_hour, modify_minute, modify_second)
                ),
                title
            );
            
        }//if(!title.isBlank() && !file.isBlank())
        
        this.list = new ArrayList();
        this.list.addAll(o.Return());
        
    }//Event(Read arq)
    
    public String Tab(int tab, String tema){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*Order.tab_space);
            
        }//if(tab > 1)
        
        value += tema;
        
        return value;
    
    }//Tab(int tab, String tema)
    
    public Exec Save(Arq save){
        
        List<String> exp = new ArrayList();
        
        exp.add(this.Tab(1, Reg.xmls));
        
        var root = "<root url=\"";
        root += Reg.http;
        
        var col = "";
        
        for(var i = 0; i < save.Read().Arq().length(); i++){
            
            switch(save.Read().Arq().charAt(i)){
                
                case '\'', '/' -> col = "";
                
                default -> col += save.Read().Arq().charAt(i);
                
            }//switch(save.Read().Arq().charAt(i))
            
        }//for(var i = 0; i < save.Read().Arq().length(); i++)
        
        if(this.local.length > 1){//avoid error
            
            root += "\" folder=\"";
            
            if(col.equalsIgnoreCase(this.local[this.local.length-1])){
                
                for(var i = 0; i < this.local.length-1; i++){
                    
                    root += this.local[i];
                    root += "/";
                    
                }//for(var i = 0; i < this.local.length; i++)
                
            } else {//if(col.equalsIgnoreCase(this.local[this.local.length-1]))
                
                for(var i = 0; i < this.local.length; i++){
                    
                    if(i > 0) root += "/";
                    
                    root += this.local[i];
                    
                }//for(var i = 0; i < this.local.length; i++)
                
            }//if(col.equalsIgnoreCase(this.local[this.local.length-1]))
            
        }//avoid error
        
        if(!txt.text(this.user, true).isBlank()){
            
            root += "\" user=\"";
            root += txt.text(this.user, true);
            
        }//if(!this.user.trim().isBlank())
        
        root += "\">";
        
        exp.add(this.Tab(1, root));
        
        if(this.list.isEmpty()){
            
            exp.add(this.Tab(2, "<document></document>"));
            
        } else {//if(this.list.isEmpty())
            
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
                
                var dt = doc.InsertData().getDate() != doc.ModifyData().getDate();
                var ht = doc.InsertHora().getHora() != doc.ModifyHora().getHora();
                
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
    
    public boolean setUser(String user){
        
        if(this.user_in){//setUser(String user)
            
            return false;
            
        } else {//setUser(String user)
            
            this.user = user;
            
            return true;
            
        }//setUser(String user)
    
    }//setUser(String user)
    
    public String getUser(){return this.user;}
    
    public boolean Windows(){return this.user_in;}
    
    public String Documents(String file_name){
        
        var value = "";
        
        if(this.user_in){
            
            value = "C:\\Users\\";
            value += this.user;
            value += "\\Documents\\";
            
        }//if(user_in)
        
        value += file_name;
        
        return value;
        
    }//Documents(Read d, String file_name)
    
    public Exec SaveFile(int pos, String file_name){
        
        if(pos >= 0 && pos < this.list.size() && !this.list.isEmpty()){
            
            return new Arq(file_name).Save(this.list.get(pos).File().Read());
            
        } else {//if(pos >= 0 && pos < this.list.size() && !this.list.isEmpty())
            
            return new Exec();
            
        }//if(pos >= 0 && pos < this.list.size() && !this.list.isEmpty())
        
    }//SaveFile(int pos, String file_name)
    
    public Exec SaveDocument(int pos, String file_name){
        
        String document;
        
        return this.SaveFile(pos, this.Documents(file_name));
        
    }//SaveDocument(int pos, String file_name)
    
    public int Add(String t, Read r){
        
        var msg_position = -1;
        
        Order<xml_config_one> o = new Order();
        
        for(xml_config_one x : this.list)
        {o.Add(x, x.Title());}
        
        var valid = o.Add(new xml_config_one(t, r, new Data(), new Hora(true)), t);
        
        if(valid){
            
            this.list.clear();
            this.list.addAll(o.Return());
            
        } else {//if(valid)
            
            msg_position = o.Position();
            
        }//if(valid)
        
        return msg_position;
        
    }//Add(String t, Read r)
    
    public int newTitle(int position, String title){
        
        var valid = -2;
        
        if(
            position >= 0 &&
            position < this.list.size() &&
            !this.list.isEmpty()
        )
        {
            
            var proc = this.list.get(position);
            proc.Update(new Data(), new Hora(true));
            
            Order<xml_config_one> o = new Order();
            
            for(int add = 0; add < this.list.size(); add++){
                
                if(add != position)
                {o.Add(this.list.get(add), this.list.get(add).Title());}
                
            }//for(int add = 0; add < this.list.size(); add++)
            
            var acept = o.Add(proc, title);
            
            if(acept){
                
                this.list.clear();
                this.list.addAll(o.Return());
                valid = o.Position();
                
            }//if(acept)
            
        }//if - position
        
        return valid;
        
    }//newTitle(int position, String title)
    
    public int Proc(String title){
        
        List<String> tem = new ArrayList();
        
        for(xml_config_one x : this.list)
        {tem.add(x.Title());}
        
        return Order.Proc(tem, title);
        
    }//Proc(String title)
    
    public List<xml_config_one> learn(){return this.list;}
    
}//xml_config