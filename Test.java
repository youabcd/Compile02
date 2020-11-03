import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuffer;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Test {
    public static String str=null;
    public static String k="C:\\Users\\asus\\Desktop\\testin.txt";
    public static ArrayList<String> inStack=new ArrayList<String>();
    public static void main(String[] args) {
        str=read(args[0]);
        //System.out.println(str);
        int length=str.length();
        inStack.add("#");
        int i;
        for(i=1;i<length;i++){
            char inVt=inStack.get(inStack.size()-1).charAt(0);
            if(i==length-1&&inVt=='N'&&inStack.size()==2){
                break;
            }
            char outVt=str.charAt(i);
            //System.out.println(inVt+" "+outVt);
            if(Check.judge(inVt)){
                int res=Check.Compare(inVt,outVt);
                if(res==0||res==1){
                    inStack.add(String.valueOf(outVt));
                    System.out.println("I"+outVt);
                    continue;
                }
                else if(res==2){
                    if(Reduce()==0) {
                        i--;
                        System.out.println("R");
                        //System.out.println(inStack);
                    }
                    else{
                        System.out.println("RE");
                        break;
                    }
                }
                else{
                    System.out.println("E");
                    break;
                }
            }
            else{
                inVt=inStack.get(inStack.size()-2).charAt(0);
                if(Check.judge(inVt)){
                    int res=Check.Compare(inVt,outVt);
                    if(res==0){
                        inStack.add(String.valueOf(outVt));
                        System.out.println("I"+outVt);
                        continue;
                    }
                    else if(res==1){
                        while(inStack.get(inStack.size()-1)!="("){
                            inStack.remove(inStack.size()-1);
                        }
                        inStack.remove(inStack.size()-1);
                    }
                    else if(res==2){
                        if(Reduce()==0) {
                            i--;
                            System.out.println("R");
                            //System.out.println(inStack);
                        }
                        else{
                            System.out.println("RE");
                            break;
                        }
                    }
                    else{
                        System.out.println("E");
                        break;
                    }
                }
                else{
                    System.out.println("E");
                    break;
                }
            }
        }
    }
    public static int Reduce(){
        char top=inStack.get(inStack.size()-1).charAt(0);
        char nexttop=inStack.get(inStack.size()-2).charAt(0);
        if(top=='i'){
            inStack.set(inStack.size()-1,"N");
            return 0;
        }
        if(top==')'){
            if(inStack.size()<4){
                return -1;
            }
            inStack.remove(inStack.size()-1);
            inStack.remove(inStack.size()-1);
            inStack.remove(inStack.size()-1);
            inStack.add("N");
            return 0;
        }
        if(nexttop=='+'){
            if(inStack.size()<4){
                return -1;
            }
            inStack.remove(inStack.size()-1);
            inStack.remove(inStack.size()-1);
            inStack.remove(inStack.size()-1);
            inStack.add("N");
            return 0;
        }
        if(nexttop=='*'){
            if(inStack.size()<4){
                return -1;
            }
            inStack.remove(inStack.size()-1);
            inStack.remove(inStack.size()-1);
            inStack.remove(inStack.size()-1);
            inStack.add("N");
            return 0;
        }
        return -1;
    }
    private static String read(String file) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader raf = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            raf = new BufferedReader(isr);
            String s;
            s="#";
            s = s+raf.readLine();
            s=s+"#";
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
