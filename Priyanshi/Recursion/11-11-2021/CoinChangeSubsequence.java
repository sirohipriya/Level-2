//==========================================================================Infinite Permutations Sub===========================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int cc_infiPermutation_sub(int[] arr,int idx, int tar, String psf){
        if (tar == 0 || idx == arr.length){
            if (tar == 0){
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        
        int count = 0;
        if (tar - arr[idx] >= 0){
            count += cc_infiPermutation_sub(arr, 0, tar - arr[idx], psf + arr[idx]);
        }
        count += cc_infiPermutation_sub(arr, idx + 1, tar, psf);
        
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        String psf = "";
        
        System.out.println(cc_infiPermutation_sub(arr, 0, tar, psf));
    }
}



//=========================================================================Infinite Combinations Sub=========================================================================



import java.io.*;
import java.util.*;

public class Main {
    public static int cc_infiCombination_sub(int[] arr,int idx, int tar, String psf){
        if (tar == 0 || idx == arr.length){
            if (tar == 0){
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
    
        int count = 0;
        if (tar - arr[idx] >= 0)
            count += cc_infiCombination_sub(arr, idx, tar - arr[idx], psf + arr[idx]);
        count += cc_infiCombination_sub(arr, idx + 1, tar, psf);
    
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        String psf = "";
        
        System.out.println(cc_infiCombination_sub(arr, 0, tar, psf));
    }
}



//=================================================================Single Permutations Sub===================================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int cc_singlePermutation_sub(int[] arr,int idx, int tar, String psf){
        if (tar == 0 || idx == arr.length){
            if (tar == 0){
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        
        int count = 0;
        
        int ele = arr[idx];
        if (arr[idx] > 0 && tar - ele >= 0){
            arr[idx] = -arr[idx];
            count += cc_singlePermutation_sub(arr, 0, tar - ele, psf + ele);
            arr[idx] = -arr[idx];
        }
        count += cc_singlePermutation_sub(arr, idx + 1, tar, psf);
        
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        String psf = "";
        
        System.out.println(cc_singlePermutation_sub(arr, 0, tar, psf));
    }
}



//======================================================================Single Combinations Sub===============================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int cc_singleCombination_sub(int[] arr,int idx, int tar, String psf){
        if (tar == 0 || idx == arr.length){
            if (tar == 0){
                System.out.println(psf);
                return 1;
            }
            return 0;
        }
        
        int count = 0;
        if (tar - arr[idx] >= 0){
            count += cc_singleCombination_sub(arr, idx + 1, tar - arr[idx], psf + arr[idx]);
        }
        count += cc_singleCombination_sub(arr, idx + 1, tar, psf);
        
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        String psf = "";
        
        System.out.println(cc_singleCombination_sub(arr, 0, tar, psf));
    }
}
