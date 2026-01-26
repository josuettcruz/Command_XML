/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author josue
 */
public class Reg {
    
    public final static String http = "https://github.com/josuettcruz/Command_XML";
    
    public final static String ide = "Apache NetBeans IDE 27";
    
    public final static String categories = "Java with Ant";
    
    public final static String choose = "Java Application";
    
    public final static Data create = new Data(2025,10,27);
    
    public final static Data modify = new Data(2026,1,26);
    
    private final static int result = 28;
    
    private static boolean coppy_no_user = true;
    
    public static boolean coppy(String ctrl_c){
        
        if(coppy_no_user){
            
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            
            StringSelection selection = new StringSelection(ctrl_c);
            
            clipboard.setContents(selection,null);
            
            coppy_no_user = false;
            return true;
            
        } else {//if(coppy_no_user)
            
            return false;
            
        }//if(coppy_no_user)
        
    }//coppy(String ctrl_c)
    
    public static String Tab(String entrada, int tab){
        
        var pg = (tab - entrada.length()) > 1 ? tab - entrada.length() : 1;
        
        return " ".repeat(pg);
        
    }//Tab(boolean print, String entrada, int tab)
    
    public static String Tab(String before, String after, int tab){
        
        var txt = before;
        txt += Tab(before, tab);
        
        txt += after;
        
        return txt;
        
    }//Tab(boolean aspas, String before, String after)
    
    public static String Tab(String before, String after){
        
        return Tab(before, after, result);
        
    }//Tab(boolean aspas, String before, String after)
    
    public static void Print(String before, String after, int tab){
            
        System.out.print(before);
        System.out.print(Tab(before, tab));
        System.out.println(after);
        
    }//Print(boolean aspas, String before, String after)
    
    public static void Print(String before, String after){
        
        Print(before, after, result);
        
    }//Print(boolean aspas, String before, String after)
    
    public static String Numb(int numb){
        
        int num;
        
        var txt = "";
        
        if(numb < 0){
            
            num = numb - (numb*2);
            txt += "-";
            
        } else {//if(numb < 0)
            
            num = numb;
            
        }//if(numb < 0)
        
        if(num < 10){
            
            txt += "0";
            
        }
        
        txt += num;
        
        return txt;
        
    }//Numb(int numb)
    
    public static String Numb(int numb, int max){
        
        int num;
        
        var txt = "";
        
        if(numb < 0){
            
            num = numb - (numb*2);
            txt += "-";
            
        } else {//if(numb < 0)
            
            num = numb;
            
        }//if(numb < 0)
        
        if(num < 10 && max >= 10){
            txt += "0";
        }
        
        if(num < 100 && max >= 100){
            txt += "0";
        }
        
        if(num < 1000 && max >= 1000){
            txt += "0";
        }
        
        if(num < 10000 && max >= 10000){
            txt += "0";
        }
        
        if(num < 100000 && max >= 100000){
            txt += "0";
        }
        
        if(num < 1000000 && max >= 1000000){
            txt += "0";
        }
        
        txt += num;
        
        return txt;
        
    }//Numb(int numb, int max)
    
    public static String Numb(int numb, int max, String sep){
        
        int num;
        
        var txt = "";
        
        if(numb < 0){
            
            num = numb - (numb*2);
            txt += "-";
            
        } else {//if(numb < 0)
            
            num = numb;
            
        }//if(numb < 0)
        
        if(num < 10 && max >= 10){
            txt += "0";
        }
        
        if(num < 100 && max >= 100){
            txt += "0";
        }
        
        if(num < 1000 && max >= 1000){
            txt += "0";
        }
        
        if(num < 10000 && max >= 10000){
            txt += "0";
        }
        
        if(num < 100000 && max >= 100000){
            txt += "0";
        }
        
        if(num < 1000000 && max >= 1000000){
            txt += "0";
        }
        
        txt += num;
        
        txt += sep;
        
        txt += max;
        
        return txt;
        
    }//Numb(int numb, int max, String sep)
    
}