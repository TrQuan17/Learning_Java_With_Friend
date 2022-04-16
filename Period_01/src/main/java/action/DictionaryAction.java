
package action;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

import bean.Dictionary;
import java.util.ArrayList;
public class DictionaryAction {
    ArrayList<Dictionary> dic;   
    
    public DictionaryAction() {
        dic = new ArrayList<Dictionary>();
    }
    
    public void Init() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap so tu trong tu dien:");
        int wordcount = 0;
        while(true) {
            try {   
                wordcount = scan.nextInt();
                if (wordcount <= 0) {
                    System.out.println("So phan tu khong hop le!");
                } else {
                    break;
                }
            } catch(Exception e) {
                System.out.println("Dinh dang khong hop le!");
                scan.next();
            }  
        }
        for(int i = 0; i < wordcount; i++) {
            try {
                Dictionary word = new Dictionary();
                word.Tu = InputWord("Nhap tu tieng anh:");
                if(isExist(word.Tu, dic)) {
                    throw new Exception("Tu nay da ton tai!");
                }
                word.Nghia = InputWord("Nhap nghia cua tu:");
                word.PhienAm = InputWord("Nhap phien am cua tu:");
                dic.add(word);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
    }
    
    public void ShowDictionary() {
        System.out.printf("%-15s %-15s %-15s\n", "Tu", "Nghia", "Phiem Am");
        System.out.println("----------------------------------------");
        for(Dictionary i : dic) {
            System.out.printf("%-15s %-15s %-15s\n",i.Tu,i.Nghia, i.PhienAm);
            System.out.println("----------------------------------------");
        }
    }
    
    public void SearchWord() {
        String word = InputWord("Nhap tu can tim kiem: ");
        for(Dictionary i : dic) {
            if(word.toLowerCase().equals(i.Tu.toLowerCase())) {
                System.out.println(i.Tu + " =========");
                System.out.printf("Nghia: %-15s\n",i.Nghia);
                System.out.printf("Phiem am: %-15s\n", i.PhienAm);
                System.out.println("----------");
            } else {
                System.out.println("Khong tim thay!");
            }
        }
    }
    
    static String InputWord(String mess) {
        while(true) {
            System.out.println(mess);
            Scanner scan = new Scanner(System.in);
            String word = scan.nextLine();
            Pattern p = Pattern.compile("^[A-Za-z\\s]{2,100}$");
            Matcher m = p.matcher(word);
            boolean b = m.find();
            if(b) return word.strip();
            else {
                System.out.println("Tu nhap khong hop le!");
            }
        }
    }
    
    static boolean isExist(String word, ArrayList<Dictionary> list) {
        for(Dictionary i : list) {
            if(word.equals(i.Tu)) {
                return true;
            }
        }
        return false;
    }
}
