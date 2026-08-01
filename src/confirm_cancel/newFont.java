/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_mf.*;
import xml_rw.*;
import model.*;
import form.*;
import static form.pag2.confirm;
import static form.pag2.cancel;
import static form.pag2.enter;

import static confirm_cancel.form_selected.*;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class newFont implements Painel_2{
    
    private form_selected form_selection;
    private String local_font;
    
    private xml_config xml;
    private xml_document doc;
    private xml_document_one one;
    
    private java.awt.Font font_title;
    private java.awt.Font font_text;
    
    private boolean init(Font f[]){
        
        var try_true = false;
        
        try{
            
            this.font_title = f[0];
            this.font_text = f[1];
            
            try_true = true;

        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
        return try_true;
        
    }//session(xml_document all, xml_document_one one, Font f[])
    
    public newFont(xml_config con, String local, Font[] f){
        
        if(this.init(f)){
            
            this.form_selection = folder_xml;
            this.xml = con;
            
            this.local_font = local;
            
        }//if(this.init(f))
        
    }//newFont(xml_config con, Font[] font, String local, Font[] f)
    
    public newFont(xml_document doc, String local, Font[] f){
        
        if(this.init(f)){
            
            this.form_selection = ReadWrite;
            this.doc = doc;
            
            this.local_font = local;
            
        }//if(this.init(f))
        
    }//public newFont(xml_config con, String local, Font[] f)
    
    public newFont(xml_document doc, xml_document_one one, String local, Font[] f){
        
        if(this.init(f)){
            
            this.form_selection = session;
            this.doc = doc;
            this.one = one;
            
            this.local_font = local;
            
        }//if(this.init(f))
        
    }//newFont(xml_document doc, xml_document_one one, String local, Font[] f)
    
    private void addFont(carregarFonte cod){
        
        final var msg_err_font = "FontFormatException";
        
        if(cod.Val()) Action.newFont(cod.Font()); 
        
        switch(this.form_selection){
            
            case folder_xml ->{
                
                if(xml == null){
                    
                    Action.Err("Erro", "xml == null");
                    
                } else if(cod.Val()){//if(xml == null)
                    
                    controller.p1s(
                        new folder_xml(
                            this.xml,
                            Action.MyFont()
                        )
                    );
                    
                } else {//if(xml == null)
                    
                    controller.p1s(
                        new folder_xml(
                            this.xml,
                            Action.MyFont(),
                            msg_err_font
                        )
                    );
                    
                }//if(xml == null)
                
            }//case folder_xml
            
            case ReadWrite ->{
                
                if(doc == null){
                    
                    Action.Err("Erro", "doc == null");
                    
                } else if(cod.Val()){//if(xml == null)
                    
                    controller.p1m(
                        new ReadWrite(
                            this.doc,
                            Action.MyFont()
                        )
                    );
                    
                } else {//if(xml == null)
                    
                    controller.p1s(
                        new ReadWrite(
                            this.doc,
                            Action.MyFont(),
                            msg_err_font
                        )
                    );
                    
                }//if(xml == null)
                
            }//case ReadWrite
            
            case session ->{
                
                if(doc == null || one == null){
                    
                    Action.Err("Erro", "doc == null || one == null");
                    
                } else if(cod.Val()){//if(xml == null)
                    
                    controller.p3(
                        new session(
                            this.doc,
                            this.one,
                            Action.MyFont()
                        )
                    );
                    
                } else {//if(xml == null)
                    
                    xml_document_one temp = this.one;
                    
                    if(this.one.getTitle().isBlank()){
                        
                        temp.setTitle(msg_err_font);
                        
                    } else {//if(this.one.getTitle().isBlank())
                        
                        var array = txt.phrase(this.one.getTitle(), true);
                        
                        var contain = false;
                        
                        var txt1 = "";
                        
                        for(String t : txt.phrase(
                            txt.arq(
                                array.get(
                                    array.size()-1)
                                )
                            )
                        ) txt1 += t;
                        
                        var txt2 = "";
                        
                        for(String t : txt.phrase(
                                txt.arq(
                                    msg_err_font
                                )
                            )
                        ) txt2 += t;
                        
                        if(array.size() > 1) contain = txt1.equals(txt2);
                        
                        temp.setTitle(
                            contain
                            ? this.one.getTitle()
                            : this.one.getTitle()
                            + " - "
                            + msg_err_font
                        );
                        
                    }//if(this.one.getTitle().isBlank())
                    
                    if(!cod.msg().isEmpty()){
                        
                        List<String> text = new ArrayList();
                        
                        text.add(new Data().DataAbreviada(false));
                        text.add(new Hora(true).Timer());
                        
                        text.addAll(cod.msg());
                        
                        if(!this.one.getText().isEmpty()){
                            
                            text.add("");
                            text.addAll(this.one.getText());
                            
                        }//if(!this.one.getText().isEmpty())
                        
                        temp.setText(text);
                        
                    }//if(!cod.msg().isEmpty())
                    
                    controller.p3(
                        new session(
                            this.doc,
                            temp,
                            Action.MyFont()
                        )
                    );
                    
                }//if(xml == null)
                
            }//case session
            
        }//switch(this.form_selection)
        
    }//addFont(carregarFonte cod)
    
    private void cancel(){
        
        switch(this.form_selection){
            
            case folder_xml ->{
                
                if(xml == null){
                    
                    Action.Err("Erro", "xml == null");
                    
                } else {//if(xml == null)
                    
                    controller.p1s(
                        new folder_xml(
                            this.xml,
                            Action.MyFont()
                        )
                    );
                    
                }//if(xml == null)
                
            }//case folder_xml
            
            case ReadWrite ->{
                
                if(doc == null){
                    
                    Action.Err("Erro", "doc == null");
                    
                } else {//if(xml == null)
                    
                    controller.p1m(
                        new ReadWrite(
                            this.doc,
                            Action.MyFont()
                        )
                    );
                    
                }//if(xml == null)
                
            }//case ReadWrite
            
            case session ->{
                
                if(doc == null || one == null){
                    
                    Action.Err("Erro", "doc == null E/OU one == null");
                    
                } else {//if(xml == null)
                    
                    controller.p3(
                        new session(
                            this.doc,
                            this.one,
                            Action.MyFont()
                        )
                    );
                    
                }//if(xml == null)
                
            }//case session
            
        }//switch(this.form_selection)
        
    }//cancel()
    
    private void confirm(int size){
        
        if(size == 0){
            
            this.cancel();
            
        } else {//if(size == 0)
            
            this.addFont(
                new carregarFonte(
                    this.local_font,
                    0,
                    size
                )
            );
            
        }//if(size == 0)
        
    }//confirm(Domain dom)

    @Override
    public String Title(boolean title) {
        
        var text = Hora.Good();
        text += "! ";
        
        if(title){
            
            text += Reg.categories;
            
        } else {//if(title)
            
            text += Reg.categories;
            text += " - Escolha o tamanho da fonte:";
            
        }//if(title)
        
        return text;
        
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
        
        List<Domain> dom = new ArrayList();
        
        Integer size[] = {8, 10, 12, 14, 18, 20, 22};
        dom.add(new Domain(0, "Cancelar"));
        
        for(Integer val : size){
            
            var string = "Tamanho: ";
            string += Reg.Numb(val);
            
            dom.add(new Domain(val,string));
            
        }//for(Integer val : size)
        
        return dom;
        
    }

    @Override
    public boolean SelectionMultiple() {
        return false;
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        switch(op){
            
            case confirm, enter ->{
                
                var proc = 0;
                var loop = true;
                
                do{
                    
                    if(value.get(proc).Select()){
                        
                        this.confirm(value.get(proc).index());
                        
                        loop = false;
                        
                    }//if(value.get(proc).Select())
                    
                    proc++;
                    
                }while(loop && proc > 0 && proc < value.size());
                
            }//case confirm, enter
            
            case cancel -> this.cancel();
            
        }//switch(op)
        
    }
    
}//newFont