/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package xml_rw;

/**
 *
 * @author josue
 */
public enum xml_config_file_cond {
    
    write("ready and write"),
    readonly("ready only"),
    not("not found");
    
    private String text;
    
    private xml_config_file_cond(String text){this.text = text;}
    
    public String Desc(){return this.text;}
    
}