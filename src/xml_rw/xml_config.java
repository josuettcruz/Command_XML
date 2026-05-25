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
        
        final List<String> l = Arq.Folder(arq.Arq());
        
        this.local = new String[l.size()];
        
        for(int position = 0; position < l.size(); position++)
        {this.local[position] = l.get(position);}
        
        this.list = new ArrayList();
        
        this.tab_space = tab;
        
        for(Tag t : new xml(arq.Read()).Tag()){
            
            if(t.CloseTag()){
                
                //code
                
            }//if(t.CloseTag())
            
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
                
                var a = "<file acept=\"";
                a += doc.Cond().Val();
                a += "\">";
                a += doc.Arq().Arq();
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