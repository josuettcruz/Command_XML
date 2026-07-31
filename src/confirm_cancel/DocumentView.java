/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_rw.xml_document;
import xml_rw.xml_document_one;
import xml_mf.Action;
import xml_mf.ReadWrite;
import xml_mf.session;

import form.*;
import static form.pag2.confirm;
import static form.pag2.cancel;
import static form.pag2.enter;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import model.Reg;

/**
 *
 * @author joaot
 */
public class DocumentView implements Painel_2{
    
    private xml_document xml;
    private xml_document_one tag;
    
    private Font font_title;
    private Font font_text;
    
    public DocumentView(xml_document doc, xml_document_one one, Font f[]){
        
        try{

            this.xml = doc;
            this.tag = one;
            
            this.font_title = f[0];
            this.font_text = f[1];

        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//DocumentView(xml_document doc, xml_document_one one)
    
    public Font[] Font(){
        
        java.awt.Font font[] = {
            this.font_title,
            this.font_text
        };
        
        return font;
        
    }//Font()
    
    private void Enter(Domain option){
        
        switch(option.index()){
            
            case 0 -> controller.p1m(new ReadWrite(this.xml, this.Font()));
            
            case 1 ->{
                
                if(this.xml.Write()){
                    
                    controller.p3(
                        new session(
                            this.xml,
                            this.tag,
                            this.Font()
                        )
                    );
                    
                }//if(this.xml.Write())
                
            }//case 1
            
            case 2 ->{
                
                if(this.xml.Write()){
                    
                    controller.p3(
                        new session(
                            this.xml,
                            new xml_document_one(),
                            this.Font()
                        )
                    );
                    
                }//if(this.xml.Write())
                
            }//case 2
            
            case 3 ->{
                
                if(Reg.java) System.err.println("Código Java incompleto!"); 
                
                Action.Exit();
                
            }//case 3
            
        }//switch(option.index())
        
    }//enter(Domain option)
    
    private void Action(List<Domain> option){
        
        var proc = 0;
        var next = true;
        
        do{
            
            if(option.get(proc).Select()){
                
                this.Enter(option.get(proc));
                
                next = false;
                
            }//if(option.get(proc).Select())
            
            proc++;
            
        }while(next && proc > 0 && proc < option.size());
        
    }//Action(Domain option)

    @Override
    public String Title(boolean title) {
        return Action.OverrideTitle(this.xml, title);
    }

    @Override
    public Font FontTitle() {
        return this.font_title;
    }

    @Override
    public Font ListFont() {
        return this.font_text;
    }

    @Override
    public boolean SelectionMultiple() {
        return false;
    }

    @Override
    public List<Domain> ListMode() {
        
        List<Domain> option = new ArrayList();
        
        option.add(new Domain(0,"Voltar"));
        
        if(this.xml.Write()){
            
            option.add(new Domain(1,"Abrir"));
            option.add(new Domain(2,"Criar Novo"));
            
        }//if(this.xml.Write())
        
        option.add(new Domain(3,"Exportar"));
        
        return option;
        
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        switch(op){
            
            case confirm, enter -> this.Action(value);
            
            case cancel -> this.Enter(value.get(0));
            
        }//switch(op)
        
    }
    
}//DocumentView