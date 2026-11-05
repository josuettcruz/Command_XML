/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_rw.xml_document;

import form.Domain;
import form.Painel_2;
import form.controller;
import form.pag2;
import java.awt.Font;
import java.util.List;
import java.util.ArrayList;
import xml_mf.Action;
import model.Reg;

import static form.pag2.confirm;
import static form.pag2.cancel;
import static form.pag2.enter;
import static form.pag2.del;
import static form.pag2.backspace;

/**
 *
 * @author josue
 */
public class DeleteSaveTemp implements Painel_2{
    
    private Font font_title;
    private Font font_text;
    private xml_document doc;
    
    private boolean err;
    
    public DeleteSaveTemp(xml_document doc, Font[] f){
        
        try{
            
            this.font_title = f[0];
            this.font_text = f[1];
            this.doc = doc;
            
            /* Esse painel vai exibir:            **
            ** todos os itens marcados com "~"    **
            ** e só irá aparecer,                 **
            ** quando um ou mais itens dentro do  **
            ** documento DOC tiver essa marcação! */
            
            this.err = false;
            
        }catch(NullPointerException msg){//throw

            Action.Err("NullPointerException", msg.getMessage());
            
        }catch(Exception msg){//throw

            Action.Err("Exception", msg.getMessage());
            
        }//throw
        
    }//DeleteSaveTemp(xml_document doc)
    
    public Font[] Font(){
        
        java.awt.Font font[] = {
            this.font_title,
            this.font_text
        };
        
        return font;
        
    }//Font()
    
    private String className(){return "DeleteSaveTemp";}
    
    private List<String> ErrMessage(){
        
        List<String> tema = new ArrayList();
        
        tema.add("Erro inesperado!");
        tema.add("classe \"" + this.className() + "\"");
        tema.add("Pacote \"xml_rw.xml_document\"");
        
        return tema;
        
    }//ErrMessage()

    @Override
    public String Title(boolean title) {
        return "ESCLUIR ou RESTAURAR";
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
    public List<Domain> ListMode() {
        
        List<Domain> lts = new ArrayList();
        
        for(var i = 0; i < this.doc.List().size(); i++){
            
            var t = this.doc.List().get(i).getTitle();
            
            if(t.charAt(0) == '~' && t.length() > 1)
            lts.add(new Domain(i,t.substring(1)));
            
        }//for(var i = 0; i < this.doc.List().size(); i++)
        
        if(lts.isEmpty()){
            
            this.err = true;
            
            for(var i = 0; i < this.ErrMessage().size(); i++)
            {lts.add(new Domain(i,this.ErrMessage().get(i)));}
            
        }//if(lts.isEmpty())
        
        return lts;
        
    }

    @Override
    public boolean SelectionMultiple() {return true;}

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        if(this.err){
            
            controller.Msg(this.className(), this.ErrMessage(), false);
            
        } else {//if(this.err)
            
            switch(op){
                
                case cancel, enter ->{
                    
                    Action.ReadWrite(this.doc);
                    
                }//case cancel, enter
                
                default ->{
                    
                    List<Integer> tem = new ArrayList();
                    
                    for(Domain d : value){
                        
                        switch(op){
                            
                            case confirm -> tem.add(d.index());
                            
                            case del, backspace ->{
                                
                                if(d.Select())
                                {tem.add(d.index());}
                                
                            }//case del, backspace
                            
                        }//switch(op)
                        
                    }//for(Domain d : value)
                    
                    if(tem.isEmpty()){
                        
                        Action.ReadWrite(this.doc);
                        
                    } else{//if(tem.isEmpty())
                        
                        xml_document val = this.doc;
                        
                        String txt;
                        
                        if(tem.size() == 1){
                            
                            val.Del(tem.get(0));
                            
                            txt = this.doc.List().get(tem.get(0)).getTitle();
                            
                        } else {//if(tem.size() == 1)
                            
                            val.Del(tem);
                            
                            txt = Reg.Numb(
                                tem.size(),
                                this.doc.List().size(),
                                " de "
                            );
                            
                            txt += " inte";
                            txt += tem.size() == 1 ? "m" : "ns";
                            txt += " excluídos!";
                            
                        }//if(tem.size() == 1)
                        
                        Action.ReadWrite_submit(val, txt);
                        
                    }//if(tem.isEmpty())
                    
                }//default
                
            }//switch(op)
            
        }//if(this.err)
        
    }
    
}//DeleteSaveTemp