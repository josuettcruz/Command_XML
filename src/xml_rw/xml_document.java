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
    
    public void Event(Read r){
        
        var o = new Order<xml_document_one>();
        
        for(Tag t : new xml(r.Read()).Tag()){
            
            //continue this
            
        }//for(Tag t : new xml(r.Read()).Tag())
        
        this.list.addAll(o.Return());
            
    }//Event(Read r)
    
    public String Tab(int tab, String tema){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*Order.tab_space);
            
        }//if(tab > 1)
        
        value += tema;
        
        return value;
    
    }//Tab(int tab, String tema)
    
    public List<String> xmls(){
        
        var dt = create_d.getDate() != modify_d.getDate();
        var ht = create_h.getHora() != modify_h.getHora();
        
        List<String> dat = new ArrayList();
        
        dat.add(Reg.xmls);
        dat.add(this.Tab(1, "<root>"));
        dat.add(this.Tab(2, "<create>"));
        dat.add(this.Tab(3, "<date>"));
        dat.add(this.Tab(4, "<year>" + this.create_d.getDate().getYear() + "<year>"));
        dat.add(this.Tab(4, "<month>" + this.create_d.getDate().getMonthValue() + "<month>"));
        dat.add(this.Tab(4, "<day>" + this.create_d.getDate().getDayOfMonth() + "<day>"));
        dat.add(this.Tab(3, "</date>"));
        dat.add(this.Tab(3, "<time>"));
        dat.add(this.Tab(4, "<hour>" + create_h.Hour() + "</hour>"));
        dat.add(this.Tab(4, "<minute>" + create_h.Min() + "</minute>"));
        dat.add(this.Tab(4, "<second>" + create_h.Sec() + "</second>"));
        dat.add(this.Tab(3, "</time>"));
        dat.add(this.Tab(2, "</create>"));
        
        if(dt || ht){
            
            dat.add(this.Tab(2, "<modify>"));
            
            if(dt){
                
                dat.add(this.Tab(3, "<date>"));
                
                dat.add(
                    this.Tab(
                        4,
                        "<year>" +
                        this.modify_d.getDate().getYear() +
                        "<year>"
                    )
                );
                
                dat.add(
                    this.Tab(
                        4,
                        "<month>" +
                        this.modify_d.getDate().getMonthValue() +
                        "<month>"
                    )
                );
                
                dat.add(
                    this.Tab(
                        4,
                        "<day>" +
                        this.modify_d.getDate().getDayOfMonth() +
                        "<day>"
                    )
                );
                
                dat.add(this.Tab(3, "</date>"));
                
            }//if(dt)
            
            if(ht){
                
                dat.add(this.Tab(3, "<time>"));
                
                dat.add(
                    this.Tab(
                        4,
                        "<hour>" +
                        modify_h.Hour() +
                        "</hour>"
                    )
                );
                
                dat.add(
                    this.Tab(
                        4,
                        "<minute>" +
                        modify_h.Min() +
                        "</minute>"
                    )
                );
                
                dat.add(
                    this.Tab(
                        4,
                        "<second>" +
                        modify_h.Sec() +
                        "</second>"
                    )
                );
                
                dat.add(this.Tab(3, "</time>"));
                
            }//if(ht)
            
            dat.add(this.Tab(2, "</modify>"));
            
        }//if(dt || ht)
        
        if(this.list.isEmpty()){
            
            dat.add("<document></document>");
            
        } else {
            
            for(xml_document_one t : this.list){
                
                //continue this
                
            }
            
        }
        
        dat.add(this.Tab(1, "</root>"));
        
        return dat;
        
    }//xmls()
    
    public Exec Save(Arq xhtml){return xhtml.Save(xmls());}
    
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
