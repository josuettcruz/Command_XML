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
public class xml_document {
    
    private List<xml_document_one> list;
    private String title;
    private Data create_d;
    private Hora create_h;
    private Data modify_d;
    private Hora modify_h;
    
    private boolean write_doc;
    private boolean xml_doc;
    
    public xml_document(Read xhtml, boolean write_document_acept){
        
        Data d = new Data(1972,1,1);
        Hora h = new Hora(0,0,0);
        
        this.list = new ArrayList();
        this.title = "";
        
        this.create_d = d;
        this.modify_d = d;
        
        this.create_h = h;
        this.modify_h = h;
        
        this.write_doc = write_document_acept;
        
        if(Reg.xml(xhtml)){
            
            this.Event(xhtml);
            
            this.xml_doc = !this.list.isEmpty();
            
        } else {//if(Reg.xml(xhtml))
            
            this.xml_doc = false;
            
        }//if(Reg.xml(xhtml))
        
    }//xml_document(String title, Read document)
    
    public void Event(Read r){
        
        var o = new Order<xml_document_one>();
        
        List<xml_document_link> url = new ArrayList();
        List<String> textarea = new ArrayList();
        
        var tag = "";
        
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
        
        var title_one = "";
        var url_name = "";
        var url_link = "";
        var url_valid = false;
        var text_valid = false;
        
        for(Tag t : new xml(r.Read()).Tag()){
            
            if(
                t.Tag() &&
                text_valid &&
                t.txt().equalsIgnoreCase("document") &&
                title_one.isBlank()
            ){
                
                var validate = o.Add(
                    new xml_document_one(
                            txt.InputForm(title_one),
                            url,
                            textarea
                        ),
                        txt.InputForm(title_one)
                    );
                
                if(validate){
                    
                    url.clear();
                    textarea.clear();
                    
                    tag = "";
                    
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
                    
                    title_one = "";
                    url_name = "";
                    url_link = "";
                    url_valid = false;
                    text_valid = false;
                    
                } else {//if(validate)
                    
                    var tent = false;
                    
                    var cont = 0;
                    
                    do{
                        
                        tent = o.Add(
                            new xml_document_one(
                                txt.AddRepeat(title_one),
                                url,
                                textarea
                            ),
                            txt.AddRepeat(title_one)
                        );
                        
                        cont++;
                        
                    }while(!tent && cont < 100);
                    
                    if(tent){
                        
                        url.clear();
                        textarea.clear();
                        
                        tag = "";
                        
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
                        
                        title_one = "";
                        url_name = "";
                        url_link = "";
                        url_valid = false;
                        text_valid = false;
                        
                    }//if(tent)
                    
                }//if(validate)
                
            } else if(t.OpenTag()){//if(t.Tag())
                
                tag = t.txt();
                
            } else if(t.CloseTag()){//if(t.Tag())
                
                tag = "null";
                
            } else if(t.Text()){//if(t.Tag())
                
                switch(tag){
                    
                    case "links" -> url_valid = true;
                    
                    case "content" -> text_valid = true;
                    
                    case "create" -> create = true;
                    
                    case "modify" -> modify = true;
                    
                    case "title" -> {
                        
                        if(this.title.isBlank() || text_valid)
                        {this.title = txt.InputForm(t.txt());}
                        
                        if(text_valid)
                        {title = txt.InputForm(t.txt());}
                    
                    }//case "title"
                    
                    case "year" -> {
                        
                        Num n = new Num(tag);
                        
                        if(n.Val() && n.Num() >= 1972){
                            
                            if(create && modify){
                                
                                create_year = n.Num();
                                
                            } else if(create){//if(create && modify)
                                
                                create_year = n.Num();
                                modify_year = n.Num();
                                
                            } else if(modify){//if(create && modify)
                                
                                modify_year = n.Num();
                                
                            }//if(create && modify)
                            
                        }//if(n.Val() && n.Num() >= 1972)
                        
                    }//case "year"
                    
                    case "month" -> {
                        
                        Num n = new Num(tag);
                        
                        if(n.Val() && n.Num() >= 1 && n.Num() <= 12){
                            
                            if(create && modify){
                                
                                create_month = n.Num();
                                
                            } else if(create){//if(create && modify)
                                
                                create_month = n.Num();
                                modify_month = n.Num();
                                
                            } else if(modify){//if(create && modify)
                                
                                modify_month = n.Num();
                                
                            }//if(create && modify)
                            
                        }//if(n.Val() && n.Num() >= 1 && n.Num() <= 12)
                        
                    }//case "month"
                    
                    case "day" -> {
                        
                        Num n = new Num(tag);
                        
                        if(create && n.Val() && n.Num() >= 1 && n.Num() <= 31){
                            
                            if(create && modify){
                                
                                create_day = n.Num();
                                
                            } else if(create){//if(create && modify)
                                
                                create_day = n.Num();
                                modify_day = n.Num();
                                
                            } else if(modify){//if(create && modify)
                                
                                modify_day = n.Num();
                                
                            }//if(create && modify)
                            
                        }//if(n.Val() && n.Num() >= 1 && n.Num() <= 31)
                        
                    }//case "day"
                    
                    case "hour" -> {
                        
                        Num n = new Num(tag);
                        
                        if(n.Val() && n.Num() >= 0 && n.Num() < 24){
                            
                            if(create && modify){
                                
                                create_hour = n.Num();
                                
                            } else if(create){//if(create && modify)
                                
                                create_hour = n.Num();
                                modify_hour = n.Num();
                                
                            } else if(modify){//if(create && modify)
                                
                                modify_hour = n.Num();
                                
                            }//if(create && modify)
                            
                        }//if(n.Val() && n.Num() >= 0 && n.Num() < 24)
                        
                    }//case "hour"
                    
                    case "minute" -> {
                        
                        Num n = new Num(tag);
                        
                        if(n.Val() && n.Num() >= 0 && n.Num() < 60){
                            
                            if(create && modify){
                                
                                create_minute = n.Num();
                                
                            } else if(create){//if(create && modify)
                                
                                create_minute = n.Num();
                                modify_minute = n.Num();
                                
                            } else if(modify){//if(create && modify)
                                
                                modify_minute = n.Num();
                                
                            }//if(create && modify)
                            
                        }//if(n.Val() && n.Num() >= 0 && n.Num() < 60)
                        
                    }//case "minute"
                    
                    case "second" -> {
                        
                        Num n = new Num(tag);
                        
                        if(n.Val() && n.Num() >= 0 && n.Num() < 60){
                            
                            if(create && modify){
                                
                                create_second = n.Num();
                                
                            } else if(create){//if(create && modify)
                                
                                create_second = n.Num();
                                modify_second = n.Num();
                                
                            } else if(modify){//if(create && modify)
                                
                                modify_second = n.Num();
                                
                            }//if(create && modify)
                            
                        }//if(n.Val() && n.Num() >= 0 && n.Num() < 60)
                        
                    }//case "second"
                    
                    case "page" ->{
                        
                        if(url_valid){
                            
                            if(url_name.isBlank() || url_link.isBlank()){
                                
                                url_name = t.txt();
                                
                            } else {//if(url_name.isBlank() || url_link.isBlank())
                                
                                url.add(
                                    new xml_document_link(
                                        url_name,
                                        new Link(url_link)
                                    )
                                );
                                
                                url_name = "";
                                url_link = "";
                                
                            }//if(url_name.isBlank() || url_link.isBlank())
                            
                        }//if(url_valid)
                        
                    }//case "page"
                    
                    case "url" ->{
                        
                        if(url_valid){
                            
                            if(url_name.isBlank() || url_link.isBlank()){
                                
                                url_link = t.txt();
                                
                            } else {//if(url_name.isBlank() || url_link.isBlank())
                                
                                url.add(
                                    new xml_document_link(
                                        txt.InputForm(url_name),
                                        new Link(url_link)
                                    )
                                );
                                
                                url_name = "";
                                url_link = "";
                                
                            }//if(url_name.isBlank() || url_link.isBlank())
                            
                        }//if(url_valid)
                        
                    }//case "url"
                    
                    case "text" ->{
                        
                        if(text_valid)
                        {textarea.add(txt.InputForm(t.txt()));}
                        
                    }//case "text"
                    
                }//switch(tag)
                
            }//if(t.Tag())
            
        }//for(Tag t : new xml(r.Read()).Tag())
        
        // Garantir que o último...
        // seja lido
        if(!title_one.isBlank()){
            
            var validate = o.Add(
                new xml_document_one(
                        title_one,
                        url,
                        textarea
                    ),
                    title_one
                );

            if(!validate){

                var tent = false;

                var cont = 0;

                do{

                    tent = o.Add(
                        new xml_document_one(
                            txt.AddRepeat(title_one),
                            url,
                            textarea
                        ),
                        txt.AddRepeat(title_one)
                    );

                    cont++;

                }while(!tent && cont < 100);

            }//if(!validate)

        }//if(!title.isBlank() && !file.isBlank())
        
        this.create_d = new Data(create_year, create_month, create_day);
        
        this.create_h = new Hora(create_hour, create_minute, create_second);
        
        this.modify_d = new Data(modify_year, modify_month, modify_day);
        
        this.modify_h = new Hora(modify_hour, modify_minute, modify_second);
        
        this.list.addAll(o.Return());
            
    }//Event(Read r)
    
    private String Tab(int tab, int tab_space, String tema){
        
        var value = "";
        
        var tb = tab_space > 0 && tab_space <= 10 ? tab_space : 1;
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*tb);
            
        }//if(tab > 1)
        
        value += tema;
        
        return value;
    
    }//Tab(int tab, String tema)
    
    public List<String> xmls(int tab_space){
        
        var dt = create_d.getDate() != modify_d.getDate();
        var ht = create_h.getHora() != modify_h.getHora();
        
        List<String> dat = new ArrayList();
        
        dat.add(Reg.xmls);
        dat.add(this.Tab(1, tab_space, "<root>"));
        dat.add(this.Tab(2, tab_space, "<create>"));
        dat.add(this.Tab(3, tab_space, "<date>"));
        
        dat.add(
            this.Tab(
                4,
                tab_space,
                "<year>" +
                this.create_d.getDate().getYear() +
                "<year>"
            )
        );
        
        dat.add(
            this.Tab(
                4,
                tab_space,
                "<month>" +
                this.create_d.getDate().getMonthValue() +
                "<month>"
            )
        );
        
        dat.add(
            this.Tab(
                4,
                tab_space,
                "<day>" +
                this.create_d.getDate().getDayOfMonth() +
                "<day>"
            )
        );
        
        dat.add(this.Tab(3, tab_space, "</date>"));
        dat.add(this.Tab(3, tab_space, "<time>"));
        dat.add(this.Tab(4, tab_space, "<hour>" + create_h.Hour() + "</hour>"));
        dat.add(this.Tab(4, tab_space, "<minute>" + create_h.Min() + "</minute>"));
        dat.add(this.Tab(4, tab_space, "<second>" + create_h.Sec() + "</second>"));
        dat.add(this.Tab(3, tab_space, "</time>"));
        dat.add(this.Tab(2, tab_space, "</create>"));
        
        if(dt || ht){
            
            dat.add(this.Tab(2, tab_space, "<modify>"));
            
            if(dt){
                
                dat.add(this.Tab(3, tab_space, "<date>"));
                
                dat.add(
                    this.Tab(
                        4, tab_space,
                        "<year>" +
                        this.modify_d.getDate().getYear() +
                        "<year>"
                    )
                );
                
                dat.add(
                    this.Tab(
                        4, tab_space,
                        "<month>" +
                        this.modify_d.getDate().getMonthValue() +
                        "<month>"
                    )
                );
                
                dat.add(
                    this.Tab(
                        4, tab_space,
                        "<day>" +
                        this.modify_d.getDate().getDayOfMonth() +
                        "<day>"
                    )
                );
                
                dat.add(this.Tab(3, tab_space, "</date>"));
                
            }//if(dt)
            
            if(ht){
                
                dat.add(this.Tab(3, tab_space, "<time>"));
                
                dat.add(
                    this.Tab(
                        4, tab_space,
                        "<hour>" +
                        modify_h.Hour() +
                        "</hour>"
                    )
                );
                
                dat.add(
                    this.Tab(
                        4, tab_space,
                        "<minute>" +
                        modify_h.Min() +
                        "</minute>"
                    )
                );
                
                dat.add(
                    this.Tab(
                        4, tab_space,
                        "<second>" +
                        modify_h.Sec() +
                        "</second>"
                    )
                );
                
                dat.add(this.Tab(3, tab_space, "</time>"));
                
            }//if(ht)
            
            dat.add(this.Tab(2, tab_space, "</modify>"));
            
        }//if(dt || ht)
        
        if(this.list.isEmpty()){
            
            dat.add(this.Tab(2, tab_space, "<document></document>"));
            
        } else {//if(this.list.isEmpty())
            
            for(xml_document_one t : this.list){
                
                dat.add(this.Tab(2, tab_space, "<document>"));
                
                dat.add(this.Tab(3, tab_space, "<title>" + txt.OutputForm(t.getTitle()) + "</title"));
                
                if(!t.getUrl().isEmpty()){
                    
                    dat.add(this.Tab(3, tab_space, "<links>"));
                    
                    for(xml_document_link x : t.getUrl()){
                        
                        dat.add(this.Tab(4, tab_space, "<page>" + txt.OutputForm(x.name()) + "</page>"));
                        dat.add(this.Tab(4, tab_space, "<url>" + x.lnk() + "</url>"));
                        
                    }//for(xml_document_link x : t.getUrl())
                    
                    dat.add(this.Tab(3, tab_space, "</links>"));
                    
                }//if(!t.getUrl().isEmpty())
                
                if(!t.getText().isEmpty()){
                    
                    dat.add(this.Tab(3, tab_space, "<content>"));
                    
                    for(String d : t.getText()){
                        
                        dat.add(this.Tab(4, tab_space, "<text>" + txt.OutputForm(d) + "</text>"));
                    
                    }
                    
                    dat.add(this.Tab(3, tab_space, "</content>"));
                    
                }//if(!t.getText().isEmpty())
                
                dat.add(this.Tab(2, tab_space, "</document>"));
                
            }//for(xml_document_one t : this.list)
            
        }//if(this.list.isEmpty())
        
        dat.add(this.Tab(1, tab_space, "</root>"));
        
        return dat;
        
    }//xmls()
    
    public Exec Save(Arq xhtml){return xhtml.Save(xmls(Order.tab_space));}
    
    public int Add(xml_document_one demo){
        
        Order o = new Order<xml_document_one>();
        
        for(xml_document_one d : this.list)
        {o.Add(d, d.getTitle());}
        
        var valid = o.Add(demo, demo.getTitle());
        
        if(valid){
            
            this.list.clear();
            this.list.addAll(o.Return());
            
        }//if(valid)
        
        return o.Position();
        
    }//Add(xml_document_one demo)
    
    public boolean Update(Data d, Hora h){
        
        var valid = d.CompareTo(this.create_d, true) &&
                    h.Compare(this.create_h);
        
        if(valid){
            
            this.modify_d = d;
            this.modify_h = h;
            
        }//if(valid)
        
        return valid;
        
    }//Update(Data d, Hora h)
    
    private boolean Update()
    {return this.Update(new Data(), new Hora(true));}
    
    public int Proc(String title){
        
        List<String> tem = new ArrayList();
        
        for(xml_document_one x : this.list)
        {tem.add(x.getTitle());}
        
        return Order.Proc(tem, title);
        
    }//Proc(String title)
    
    public int Edit(int position, xml_document_one value){
        
        var valid = -2;
        
        if(
            position >= 0 &&
            position < this.list.size() &&
            !this.list.isEmpty()
        )
        {
            
            Order<xml_document_one> o = new Order();
            
            for(int add = 0; add < this.list.size(); add++){
                
                if(add != position)
                {o.Add(this.list.get(add), this.list.get(add).getTitle());}
                
            }//for(int add = 0; add < this.list.size(); add++)
            
            var acept = o.Add(value, value.getTitle());
            
            if(acept){
                
                this.list.clear();
                this.list.addAll(o.Return());
                valid = o.Position();
                this.Update();
                
            }//if(acept)
            
        }//if - position
        
        return valid;
        
    }//Edit(int position, xml_document_one value)

    public void setTitle(String title) {this.title = title;}

    public String getTitle() {return title;}

    public Data CreateDate() {return create_d;}

    public Hora CreateHour() {return create_h;}

    public Data ModifyDate() {return modify_d;}

    public Hora ModifyHour() {return modify_h;}

    public boolean Doc() {return xml_doc;}
    
    public boolean Write(){return this.write_doc;}

    public List<xml_document_one> List() {return list;}
    
}//xml_document