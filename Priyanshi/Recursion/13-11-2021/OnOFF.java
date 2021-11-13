import java.util.*;

public class Main
{  
    public static void main(String[] args){
        int n = 5;
        int k = 7;
        System.out.println(onOFF(n, k));
        System.out.println(OFFon(n, k));
        System.out.println(check(n, k));
    
    }
    public static boolean check(int x, int k){
        // int num = x >>> k;
        // if(num == 0)
        //     return false;
        // return true;
        
        if((x & (1 << k)) == 0)
            return false;
        return true;
        
        
        
    }
    public static int onOFF(int x, int k){
        int tlk = (1 << k);
        if(check(x, k)){
            x = (x ^ tlk);
        }
        
        return x;
        
    }
    public static int OFFon(int x, int k){
        int tlk = (1 << k);
        if(!check(x, k)){
            x = (x ^ tlk);
        }
        return x;
    }
}
