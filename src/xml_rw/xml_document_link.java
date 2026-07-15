/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import model.Link;

/**
 *
 * @author josue
 */
public class xml_document_link {
    
    private String title;
    private Link url;
    
    public xml_document_link(String title, Link url){
        
        this.title = title;
        this.url = url;
        
    }//xml_document_link(String title, Link url)

    public String name() {return this.title;}

    public Link lnk() {return this.url;}
    
}//xml_document_link 