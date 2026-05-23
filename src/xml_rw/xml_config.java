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
    private List<String> export_xml;
    
    private void init(){
        
        this.list = new ArrayList();
        this.export_xml = new ArrayList();
        
    }//init()
    
    public xml_config(Read arq){
        
        this.init();
        
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
            
        }//
        /* for(Tag t : new xml(arq.Read()).Tag()) **
        ** line "40"                              **
        ** Tudo vai ficar como comentário!        **
        ** 23/05/2026 - 08:02                     */
        
    }//xml_config()
    
    private void Tab(int tab, String tema){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*2);
            
        }//if(tab > 1)
        
        value += tema;
        
        this.export_xml.add(value);
    
    }//Tab(int tab, String tema)
    
    public Exec Save(Arq save){
        
        this.export_xml.clear(); //!important
        
        this.Tab(1,"<root>");
        this.Tab(2,"<Temp>");
        this.Tab(3,"<msg>O projeto ainda não está pronto.</msg>");
        this.Tab(3,"<msg>Ainda falta muita coisa para terminar.</msg>");
        
        this.Tab(
            3,
            "<obs>Esse exboço deve ser alterado e não vale para a futura funçã"
                    + "o dessa classe</obs>"
        );
        
        this.Tab(2,"</Temp>");
        this.Tab(2,"<DateTime>");
        this.Tab(3,"<Date>" + new Data().Load() + "</Date>");
        this.Tab(3,"<Hour>" + new Hora(true).Timer() + "</Hour>");
        this.Tab(2,"</DateTime>");
        this.Tab(1,"</root>");
        
        return save.Save(this.export_xml);
        
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