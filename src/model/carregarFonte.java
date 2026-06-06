/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Font;

import java.awt.FontFormatException;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class carregarFonte {
    
    private Font minhaFonte;
    private List<String> msg;
    private List<Link> lnk;
    
    public void carregarFonte(
        String caminho_da_font,
        int font_type,
        int font_size
    )
    {
        
        this.msg = new ArrayList();
        this.lnk = new ArrayList();
        
        try {
            
            var plain = font_type >= 0 && font_type <= 3 ? font_type : 0;
            
            var size = font_size >= 8 && font_size <= 72 ? font_size : 12;
            
            this.msg.add(caminho_da_font);
            this.msg.add(Reg.Numb(plain));
            this.msg.add(Reg.Numb(size));
            
            InputStream is = getClass().getResourceAsStream(caminho_da_font);
            
            this.minhaFonte = Font.createFont(Font.TRUETYPE_FONT, is);
            
            this.minhaFonte = Font.createFont(
                Font.TRUETYPE_FONT,
                new File(caminho_da_font)
            ).deriveFont(plain, size);
            
        } catch (FontFormatException e) {//throws
            
            this.msg.add("\"" + e.hashCode() + "\"");
            this.msg.add("FontFormatException");
            this.msg.add(e.getMessage());
            
            if(!e.getMessage().equalsIgnoreCase(e.getLocalizedMessage()))
            {this.msg.add(e.getLocalizedMessage());}
            
        } catch (IOException e) {//throws
            
            this.msg.add("\"" + e.hashCode() + "\"");
            this.msg.add("IOException");
            this.msg.add(e.getMessage());
            
            if(!e.getMessage().equalsIgnoreCase(e.getLocalizedMessage()))
            {this.msg.add(e.getLocalizedMessage());}
            
        } catch (Exception e) {//throws
            
            this.msg.add("\"" + e.hashCode() + "\"");
            this.msg.add("Exception");
            this.msg.add(e.getMessage());
            
            if(!e.getMessage().equalsIgnoreCase(e.getLocalizedMessage()))
            {this.msg.add(e.getLocalizedMessage());}
            
        }//throws
        
    }//carregarFonte(String caminho_da_font)
    
    public Font MyFont(Font f){
        
        return this.minhaFonte == null ? f : this.minhaFonte;
        
    }//MyFont(Font f)
    
    public Font Font(){
        
        return this.MyFont(new java.awt.Font("Times New Roman",0,18));
        
    }//Font()
    
    public boolean Val(){
        
        return this.minhaFonte != null;
    
    }//Val()
    
    public List<String> msg(){
        
        return this.msg;
    
    }//msg()
    
    public boolean Page(String page){
        
        Link l = new Link(page);
        
        if(l.Val()){
            
            this.lnk.add(l);
            
            return true;
            
        } else {//if(l.Val())
            
            return false;
            
        }//if(l.Val())
        
    }//Page(String page)
    
    public Link lnk(int get){
        
        int num;
        
        if(get == 0){
            
            num = 1;
            
        } else if(get < 0){//if(get == 0)
            
            num = get - (get*2);
            num--;
            
        } else {//if(get == 0)
            
            num = get-1;
            
        }//if(get == 0)
        
        if(this.lnk.isEmpty()){
            
            return new Link("Lista Vazia!");
            
        } else if(num > this.lnk.size()){//if
            
            return new Link(Reg.Numb(num) + "\n" + Reg.Numb(this.lnk.size()));
            
        } else if(num == 0){//if
            
            return new Link("invalid");
            
        } else {//if
            
            return this.lnk.get(num);
            
        }//if
        
    }
    
    public int Max(){
        
        return this.lnk.isEmpty() ? 0 : this.lnk.size();
    
    }//Max()
    
    public static Link StackOverflow(){
        
        var par = "https:/";
        par += "/pt.stackoverflow.com";
        par += "/questions/77337";
        par += "/como-definir-um";
        par += "a-fonte-nova-fon";
        par += "teexterna-para-";
        par += "um-jtextpane";
        
        return new Link(par);
        
    }//StackOverflow()
    
    public static Link Reddit(){
        
        var par = "https:/";
        par += "/www.reddit.com";
        par += "/r/javahelp/comments";
        par += "/16k8hem/adding_cust";
        par += "om_font_to_java/";
        par += "?tl=pt-br";
        
        return new Link(par);
        
    }//Reddit()
    
}//carregarFonte