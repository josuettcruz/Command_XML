/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;
import file.*;
import model.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author josue
 */
public class init {
    
    public static boolean look = new Data().CompareTo(Reg.modify);
    
    private static String Local(String loc){
        
        var txt = "";
        var i = 0;
        var l = 0;
        var val = true;
        var space = false;
        
        do{
            
            switch(loc.charAt(i)){
                
                case ' ' ->{
                    
                    if(i > 0 && !txt.isBlank()){
                        
                        space = true;
                        
                    }//if(i > 0 && !txt.isBlank())
                    
                }//case ' '
                
                case '\n',
                     '\f',
                     '\t',
                     '\\',
                     '|',
                     '/',
                     ':',
                     '<',
                     '>',
                     '{',
                     '}',
                     '[',
                     ']',
                     'ª',
                     'º',
                     '\'',
                     '"' -> {
                    
                    if(l >= 2){
                        
                        val = false;
                        
                    } else {//if(txt.length() >= 2)
                        
                        txt += "_";
                        
                    }//if(txt.length() >= 2)
                    
                }//cases
                
                default ->{
                    
                    l++;
                    
                    if(space){
                        
                        txt += " ";
                        space = false;
                        
                    }//if(space)
                    
                    txt += loc.charAt(i);
                    
                }//default
                
            }//switch(loc.charAt(i))
            
            i++;
            
        }while(i > 0 && i < loc.length() && val);
        
        if(i >= 2 && i <= 10 && l > 1){
            
            return txt;
            
        } else {//if(i >= 2)
            
            return "run";
            
        }//if(i >= 2)
        
    }//Local(String loc)
    
    public static List<String> Print(){
        
        Data d = new Data();
        Hora h = new Hora(true);
        
        Integer divide = d.DataCompleta("#").indexOf("#");
        
        var week = "Hojé é ";
        week += d.DataCompleta("#").substring(0,divide);
        week += ",";
        
        var node = Reg.modify.DataCompleta(false, "#");
        var tam = node.indexOf("#");
        
        List<String> print = new ArrayList();
        print.add(Reg.Tab("Apache NetBeans IDE 27", "Java with Ant Application"));
        print.add(Reg.Tab("Data de criação:", Reg.create.DataCompleta(true)));
        print.add(Reg.Tab("Última modificação", "feita no dia " + node.substring(0, tam) + ": " + Reg.modify.DataLinha(false) + "!"));
        print.add(Reg.Tab(week, d.DataCompleta(false)));
        print.add(Reg.Tab(h.TimerGood(Reg.Tab(h.TimerGood(false), week.length()-2)), h.Good()));
        
        return print;
        
    }//Print(boolean second)
    
    public static void run(String title){
        
        var text = "jar - ";
        text += new Data().Load();
        text += " - ";
        text += Reg.Numb(LocalTime.now().getHour());
        text += "h";
        text += Reg.Numb(LocalTime.now().getMinute());
        text += "m - ";
        text += Local(title);
        
        Reg.coppy(text);
        
        final var condition = "..\\info.txt";
        
        if(Arq.Exist(condition)){
            
            Arq tema = new Arq(condition);
            
            if(tema.Val()){
                
                var d = new Data().DataCompleta(true);
                
                List<String> view = new ArrayList();
                
                boolean old_line = false;
                boolean new_line = false;
                
                if(!tema.Read().Read(1).equalsIgnoreCase(d)){
                    
                    Hora com = new Hora(false);
                    
                    var h = com.Good("A", "P");
                    h += "M ";
                    h += com.TimerGood(false);
                    
                    if(Local(title).equalsIgnoreCase(title)){
                        
                        h += " - ";
                        h += title;
                        
                    } else {
                        
                        h += " \"";
                        h += title;
                        h += "\" [";
                        h += Local(title);
                        h += "]";
                        
                    }
                    
                    view.add(d);
                    view.add("-".repeat(d.length()));
                    view.add("-".repeat(h.length()));
                    view.add(h);
                    
                }//if(!tema.Read().Read(1).equalsIgnoreCase(d))
                
                var test = 0;
                var nold = true;
                var old = true;
                
                do{
                    
                    var done = txt.text(tema.Read().Read(test), true).isBlank();
                    
                    if(done){
                        
                        old = false;
                        
                    } else {//if(done)
                        
                        nold = false;
                        
                    }//if(done)
                    
                    test++;
                    
                }while(test > 0 && test < tema.Read().Max() && old && nold);
                
                if(old) view.add("");
                
                for(int i = 1; i <= tema.Read().Max(); i++){
                    
                    var t = txt.text(tema.Read().Read(i), true);
                    
                    if(t.isBlank() && old_line){
                        
                        new_line = true;
                        
                    } else if(new_line){//if(t.isBlank() && old_line)
                        
                        view.add("");
                        view.add(t);
                        new_line = false;
                        
                    } else {//if(t.isBlank() && old_line)
                        
                        view.add(t);
                        old_line = true;
                        
                    }//if(t.isBlank() && old_line)
                    
                }//for(int i = 1; i <= line.Max(); i++)
                
                tema.Save(view);
                
            } else {//if(tema.Val())
                
                System.err.println(tema.Type());
                System.err.println(tema.Message());
                
            }//if(tema.Val())
            
        }//if(Arq.Exist(info))
        
    }//run(String title)
    
    public static void LocalUser(){
        
        if(look){
            
            Scanner enter = new Scanner(System.in);
            
            System.out.println("Dê enter,");
            System.out.println("para não copiar");
            System.out.println("o título do link para a");
            System.out.println("área de transferênvia!");
            
            var read = enter.nextLine().trim();
            
            if(read.length() == 0){
                
                Hora h = new Hora(true);
                
                var before = "Agora são ";
                before += h.TimerGood(false);
                before += " da ";
                before += h.Good("manhã", "tarde", "noite");
                before += "!";
                
                var after = "Tenha um";
                after += h.Good(" ótimo dia", "a ótima tarde", "a boa noite");
                after += "!";
                
                System.out.println(before);
                System.out.println(after);
                
            } else if(read.length() < 10){//if(read.length() == 0)
                
                Reg.Print(new Hora(true).TimerGood(true), "O nome do arquivo, foi para a área de tranferência!", 22);
                
                run(read);
                
            } else {//if(read.length() == 0)
                
                var dig = new Hora(true);
                
                var temp = dig.Good();
                
                var day = "Hoje é ";
                day += Reg.modify.DataCompleta(true);
                
                System.out.println();
                System.out.println(day);
                
                Reg.Print(dig.TimerGood(false), temp, day.length() - temp.length());
                
                System.out.println();
                System.out.println("Essa é a quantidade de caracteres no texto digitado!");
                System.out.println("(Área de Transferência)");
                System.out.println();
                
                Reg.coppy(Reg.Numb(read.length()));
                
            }//if(length() == 0)
            
        } else {//if(look)
            
            for(String println : init.Print())
                System.out.println(println);
            
        }//if(look)
        
    }//LocalUser()
    
}