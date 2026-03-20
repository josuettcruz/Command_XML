/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Font;

import java.awt.FontFormatException;
//import java.awt.GraphicsEnvironment;
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
    
    public void carregarFonte(String caminho_da_font, int font_type, int font_size){
        
        this.msg = new ArrayList();
        
        try {
            
            var plain = font_type >= 0 && font_type <= 3 ? font_type : 0;
            
            var size = font_size >= 0 && font_size <= 72 ? font_size : 12;
            
            this.msg.add(caminho_da_font);
            this.msg.add(Reg.Numb(plain));
            this.msg.add(Reg.Numb(size));
            
            // Localize o caminho do arquivo dentro do seu pacote
            InputStream is = getClass().getResourceAsStream(caminho_da_font);
            
            // Cria a fonte a partir do stream
            this.minhaFonte = Font.createFont(Font.TRUETYPE_FONT, is);
            
            this.minhaFonte = Font.createFont(
                Font.TRUETYPE_FONT,
                new File(caminho_da_font)
            ).deriveFont(plain, size);
            
            // Registra a fonte no sistema para que ela possa ser usada pelo nome
            // GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // ge.registerFont(this.minhaFonte);
            
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
    
    public Font Font(){
        
        if(this.minhaFonte == null)
        {return new java.awt.Font("Times New Roman",0,18);}
        else
        {return this.minhaFonte;}
        
    }//Font()
    
    public Font Font(Font f){
        
        return this.minhaFonte == null ? f : this.minhaFonte;
        
    }//Font(Font f)
    
    public boolean Val(){return this.minhaFonte != null;}
    
    public List<String> msg(){return this.msg;}
    
    public static Link StackOverflow(){
        
        var par = "https:";
        par += "//pt.stackoverflow.com";
        par += "/questions/77337";
        par += "/como-definir-uma-fonte-nova-fonteexterna-para-um-jtextpane";
        
        return new Link(par);
        
    }//StackOverflow()
    
    public static Link Reddit(){
        
        var par = "https:";
        par += "//www.reddit.com/r/javahelp/comments";
        par += "/16k8hem/adding_custom_font_to_java/?tl=pt-br";
        
        return new Link(par);
        
    }//Reddit()
    
    public static Link PesquisaGoogle(){
        
        var par = "https:";
        par += "//www.google.com";
        par += "/search?q=como+importar+uma+fonte+externa+para+o+java+netbeans";
        par += "&sca_esv=ae2767497e191e28&sxsrf=ANbL-n6ztHrFcANwGS5uvoQ1nu";
        par += "_FZ2fDUQ%3A1774038720420&udm=50&source=hp&fbs=ADc_l-acAb_3MMOA";
        par += "Ux0zmbUpgBqRlDhz5X-HV8KrktiKRKTkK4wzt7DrFKmOiUvaI8jyOAzd58ZcXb";
        par += "4LHWiRdLb3TbrpH5AZLmQbW5EUUMSbDwCeWbkAfpuCGBNUwVPPToPbKmB5bxQ2";
        par += "RUOc0SLht41-o1mdtTvCNMXrP9j0kVpa3CuSpiDsROg9Ges10D7y-qr8vE_aDp";
        par += "0l7goNGqD2axnsqMeU2tLKUg&aep=1&ntc=1&sa=X&ved=2ahUKEwjWiP6dqa-";
        par += "TAxU2lZUCHQa8J0YQ2J8OegQIFBAE&biw=1488&bih=695&dpr=1.25&mstk=A";
        par += "UtExfCo_ACGEJHar71cw9uvYR1pc_3RflyFgizOn8Lq_PXsNhDsIkFB9A2NWmj";
        par += "IBMfcc1Bx89QoOnIfosE61cTNTtRn1blqq6xnKS0grku1CDPtJNuWa81Yxt1PE";
        par += "07p91u76heB_Rs1SRzuNoJao-w-Ow2VXk6PwIaHEEY86zXb1Im32zCwtqDMgZ8";
        par += "xFojr7DLYHiE7LLpEAEUB8zZV31CAXekvh9dGNIG9JEVF02b8NNmVOP7z7URYI";
        par += "WskIoDjRQH-hGfEQtPk5Zyd7dTanwIYNyL1ujbNffL5ea9OQO6cDstZ_yBMSJW";
        par += "DU0Zy32K3aTTeWY5YIXGDuoOQiQ&csuir=1&mtid=wq69ab67Ifqu1sQP1fCIi";
        par += "AY";
        
        return new Link(par);
        
    }//PesquisaGoogle()
    
}//carregarFonte