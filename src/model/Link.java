/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class Link {
    
    private String url;
    private List<String> lnk;
    
    public Link(String link){
        
        this.url = "";
        
        this.lnk = new ArrayList();
        
        if(link.contains("\n") || link.contains("\t")){
            
            var txt = "";
            boolean space = false;
            
            this.lnk.add("Em um link não pode haver quebra de linha e nem tabulação!");
            
            for(int i = 0; i < link.length(); i++){
                
                switch(link.charAt(i)){
                    
                    case '\n' ->{
                        
                        if(!txt.isBlank()){
                            
                            this.lnk.add("\\n - " + txt);
                            txt = "";
                            
                        }//if(!txt.isBlank())
                        
                    }//case '\n'
                    
                    case '\t' ->{
                        
                        if(!txt.isBlank()){
                            
                            this.lnk.add("\\t - " + txt);
                            txt = "";
                            
                        }//if(!txt.isBlank())
                        
                    }//case '\t'
                    
                    case ' ' ->{
                        
                        if(!txt.isBlank())
                            space = true;
                        
                    }//case ' '
                    
                    case '\r' ->{
                        
                        if(space){
                            txt += " ";
                            space = false;
                        }
                        
                        txt += "-";
                        
                    }//case '\r'
                    
                    default ->{
                        
                        if(space){
                            txt += " ";
                            space = false;
                        }
                        
                        txt += link.charAt(i);
                        
                    }//default
                    
                }//switch(link.charAt(i))
                
            }//for(int i = 0; i < link.length(); i++)
            
            if(!txt.isBlank())
                this.lnk.add(txt);
            
        } else if(link.contains("\r")){
            
            this.lnk.add(link.replace("\r", "-"));  
            this.lnk.add("Existe um caracter desconhecido!");
            
        } else if(link.contains(" ")){
            
            this.lnk.add(link);
            this.lnk.add("Em um link, os espaços são substituídos por:");
            this.lnk.add("\"_\"");
            
        } else if(link.contains("/")){
            
            for(String pg : link.split("/")){
                
                if(!pg.isBlank())
                    this.lnk.add(pg);
            
            }//for(String lnk : this.url)
            
            if(this.lnk.size() > 1){
                
                this.url = link;
                
            } else {//if(this.lnk.size() > 2)
                
                this.lnk.clear();
                this.lnk.add("Link inválido!");
                
                for(String p : link.split("/")){
                    
                    if(p.trim().length() >= 2)
                        this.lnk.add(p);
                    
                }//for(String p : this.url.split("/"))
                
            }//if(this.lnk.size() > 2)
                
            
        } else {
            
            this.lnk.add(link);
            this.lnk.add("\"/\" É obrigatório em um link!");
            
        }//if(link.contains("\n") || link.contains("\t"))
        
    }//Link(String link)
    
    public List<String> Link(boolean www){
        
        if(this.Val(true) && www){
            
            List<String> page = new ArrayList();
            
            boolean get = false;
            
            for(String insert : this.lnk){
                
                if(get){
                    
                    page.add(insert);
                    
                } else {//if(get)
                    
                    get = true;
                    
                }//if(get)
                
            }//for(String insert : this.lnk)
            
            return page;
            
        } else {//for(String insert : this.lnk)
            
            return this.lnk;
            
        }//for(String insert : this.lnk)
        
    }//Link(boolean www)
    
    private String Fail(String sep){
        
        String txt = "";
        
        boolean space = false;
        
        for(String msg : this.lnk){
            
            if(space){
                
                txt += sep;
                
            } else {
                
                space = true;
                
            }
            
            txt += msg;
            
        }//for(String msg : this.lnk)
        
        return txt;
        
    }//Fail(String sep)
    
    public boolean Val(boolean web){
        
        var valid = true;
        
        if(this.lnk.size() > 1 && web) valid = this.lnk.get(1).contains(".");
        
        var pg = this.lnk.get(0);
        
        var val_1 = pg.contains("http");
        
        var val_2 = false;
        
        if(pg.length() >= 2){
            
            var point = this.lnk.get(0).length()-1;
            
            val_2 = pg.charAt(point) == ':';
            
        }//if(pg.length() >= 2)
        
        return valid && val_1 && val_2;
        
    }//Val(boolean web)
    
    public boolean Val(){
        
        return !this.url.isBlank() && this.lnk.get(0).contains("http");
        
    }//Val()
    
    public String getLink(){
        
        return this.Val() ? this.url : this.Fail("\n");
        
    }//getLink()
    
    public boolean http(boolean secury){
        
        final String co = this.lnk.get(0);
        final int content = this.lnk.get(0).length();
        
        final String yes_secury = "https";
        final String no_secury = "http";
        
        final int yes_tot = yes_secury.length();
        final int no_tot = no_secury.length();
        
        var yes = content > yes_tot ? yes_tot : content;
        var no = content > no_tot ? no_tot : content;
        
        if(this.Val() && secury){
            
            String value = co.substring(0, yes);
            
            return value.equalsIgnoreCase(yes_secury);
            
        } else if(this.Val()){//if(this.Val() && secury)
            
            String value = co.substring(0, no);
            
            return value.equalsIgnoreCase(no_secury);
            
        } else {//if(this.Val() && secury)
            
            return false;
            
        }//if(this.Val() && secury)
        
    }//http(boolean secury)
    
    private String page_false(){
        
        return this.Val() ? this.lnk.get(this.lnk.size()-1) : this.Fail("\n");
        
    }//page_false()
    
    private String page_true(){
        
        int g = 0;
        boolean loop = true;
        String text = "www.web.com.br";
        
        do{
            
            if(this.lnk.get(g).contains(".")){
                
                text = this.lnk.get(g);
                loop = false;
                
            }//if(this.lnk.get(g).contains("."))
            
            g++;
            
        }while(g > 0 && g < this.lnk.size() && loop);
        
        if(loop){
            
            return "invalid";
            
        } else if(this.Val()){//if(loop)
            
            return text;
            
        } else {//if(loop)
            
            return this.Fail("\n");
            
        }//if(loop)
        
    }//page_true()
    
    public String page(boolean home){
        
        return home ? this.page_true() : this.page_false();
        
    }//page(boolean home)
    
    public String page(String contain){
        
        if(this.Val() && !contain.contains(" ")){
            
            String text = "";
            
            int w = this.lnk.size()-1;
            boolean loop = true;
            
            do{
                
                var pg = this.lnk.get(w).toLowerCase();
                
                if(pg.contains(contain.toLowerCase())){
                    
                    text = this.lnk.get(w);
                    loop = false;
                    
                }//if(pg.contains(contain.toLowerCase()))
                
                w--;
                
            }while(w < this.lnk.size()-1 && w >= 0 && loop);
            
            if(loop)
                text = "";
            
            return text;
            
        } else {
            
            return "";
            
        }
        
    }//page(String contain)
    
    public boolean Web(String contain){
        
        return !this.page(contain).isBlank();
        
    }//WebVal(String contain, boolean initial)
    
}//Link