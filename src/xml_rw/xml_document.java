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
    
    public xml_document(Read xhtml){
        
        Data d = new Data(1972,1,1);
        Hora h = new Hora(0,0,0);
        
        this.list = new ArrayList();
        this.title = "";
        
        this.create_d = d;
        this.modify_d = d;
        
        this.create_h = h;
        this.modify_h = h;
        
        if(Reg.xml(xhtml)) this.Event(xhtml);
        
    }//xml_document(String title, Read document)
    
    private String AddRepeat(String repeated){
        
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
            
            if(numeral.Val()){
                
                value += before;
                value += "_";
                value += Reg.Numb(numeral.Num()+1, 100);
                
            } else {//if(numeral.Val())
                
                value += before;
                value += "_";
                value += after;
                value += "001";
                
            }//if(numeral.Val())
            
        } else {//if(repeated.contains("_"))
            
            value += repeated;
            value += "_1";
            
        }//if(repeated.contains("_"))
        
        return value;
        
    }//AddRepeat(String repeated)
    
    public void Event(Read r){
        
        var o = new Order<xml_document_one>();
        
        List<xml_document_link> url = new ArrayList();
        List<String> textarea = new ArrayList();
        
        var title = "";
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
        
        for(Tag t : new xml(r.Read()).Tag()){
            
            if(
                t.Tag() &&
                t.txt().equalsIgnoreCase("document") &&
                title.isBlank()
            ){//if(t.Tag())
                
                var validate = o.Add(
                    new xml_document_one(
                            title,
                            url,
                            textarea
                        ),
                        title
                    );
                
                if(validate){
                    
                    url.clear();
                    textarea.clear();
                    
                    title = "";
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
                    
                } else {//if(ok || cont <= 100)
                    
                    var tent = false;
                    
                    var cont = 0;
                    
                    do{
                        
                        tent = o.Add(
                            new xml_document_one(
                                this.AddRepeat(title),
                                url,
                                textarea
                            ),
                            this.AddRepeat(title)
                        );
                        
                        cont++;
                        
                    }while(!tent && cont <= 100);
                    
                    if(tent){
                        
                        url.clear();
                        textarea.clear();
                        
                        title = "";
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
                        
                    }//if(tent)
                    
                }//if(ok || cont <= 100)
                
            } else if(t.OpenTag()){//if(t.Tag())
                
                tag = t.txt();
                
            } else if(t.CloseTag()){//if(t.Tag())
                
                tag = "null";
                
            } else if(t.Text()){//if(t.Tag())
                
                switch(tag){
                    
                    //11:40 - Sáb, 30/05/2026
                    
                }//switch(tag)
                
            }//if(t.Tag())
            
        }//for(Tag t : new xml(r.Read()).Tag())
        
        this.list.addAll(o.Return());
            
    }//Event(Read r)
    
    public String Tab(int tab, int tab_space, String tema){
        
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
                
                dat.add(this.Tab(3, tab_space, "<title>" + t.getTitle() + "</title"));
                
                if(!t.getUrl().isEmpty()){
                    
                    dat.add(this.Tab(3, tab_space, "<links>"));
                    
                    for(xml_document_link x : t.getUrl()){
                        
                        dat.add(this.Tab(4, tab_space, "<page>" + x.name() + "</page>"));
                        dat.add(this.Tab(4, tab_space, "<url>" + x.lnk() + "</url>"));
                        
                    }//for(xml_document_link x : t.getUrl())
                    
                    dat.add(this.Tab(3, tab_space, "</links>"));
                    
                }//if(!t.getUrl().isEmpty())
                
                if(!t.getText().isEmpty()){
                    
                    dat.add(this.Tab(3, tab_space, "<content>"));
                    
                    for(String x : t.getText())
                    {dat.add(this.Tab(4, tab_space, "<text>" + x + "</text>"));}
                    
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
    
    private void Update(){
        
        Data d = new Data();
        Hora h = new Hora(true);
        
        if(d.CompareTo(this.create_d, true) && h.Compare(this.create_h)){
            
            this.modify_d = d;
            this.modify_h = h;
            
        }//if(d.CompareTo(this.create_d, true) && h.Compare(this.create_h))
        
    }//Update()
    
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

    public String Title(boolean txt_title) {return this.title;}

    public List<xml_document_one> List() {return list;}
    
}
