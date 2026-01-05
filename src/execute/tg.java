/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package execute;

/**
 *
 * @author josue
 */
public enum tg {
    
    txt("txt", "Conteúdo"),
    tag("tag", "Elemento"),
    attr("attr", "Atributo"),
    val("val", "Valor do atributo");
    
    private final String[] ex = {"",""};
    
    private tg(String code, String detals){
        
        this.ex[0] = code;
        
        this.ex[1] = detals;
        this.ex[1] += "!";
        
    }//tg(String code, String detals)
    
    public String Val(boolean text){
        
        int v = text ? 1 : 0;
        
        return this.ex[v];
        
    }//Val(boolean text)
    
}//tg