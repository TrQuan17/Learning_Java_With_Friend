/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Quan
 */
public class QuanBai {
    String name;
    int point;
    int exp;

    final static String co = "|  _  _    |\n" +
                             "| / \\/ \\   |\n" +
                             "| \\    /   |\n" +
                             "|  \\__/    |";
    final static String chuon = "|    _     |\n" +
                                "|   ( )    |\n" +
                                "| ( ) ( )  |\n" +
                                "|   |_|    |";
    
    
    final static String ro = "|    /\\    |\n" +
                             "|   /  \\   |\n" +
                             "|   \\  /   |\n" +
                             "|    \\/    |";
    
    final static String bich = "|   / \\    |\n" +
                               "|  /   \\   |\n" +
                               "|  \\   /   |\n" +
                               "|   /_\\    |";
    
    public QuanBai(String name, int point, int exp) {
        this.name = name;
        this.point = point;
        this.exp = exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        String s1 = "___________";
        String s2 = String.format("|%-10s|", ConvertExptoPocker(exp));
        String s3 = ConvertPointtoType(point);
        
        return s1 + "\n" + s2 + "\n" + s3 + "\n" + s1 + "\n";
    }
    
    public static String ConvertExptoPocker(int exp) {
        switch(exp) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12: 
                return "Q";
            case 13: 
                return "K";
            default:
                return exp + "";
        }
    }
    
    public static String ConvertPointtoType(int point) {
        switch(point) {
            case 1:
                return bich;
            case 2: 
                return chuon;
            case 3:
                return ro;
            case 4:
                return co;
            default:
                return "";
        }
    }
    
    public static String Analysis(int point, int exp) {
        String type = "";
        switch(point) {
            case 1:
                type = "Bich";
                break;
            case 2:
                type = "Chuon";
                break;
            case 3:
                type = "Ro";
                break;
            case 4:
                type = "Co";
                break;
        }
            return ConvertExptoPocker(exp) + " " + type;
    }
}


