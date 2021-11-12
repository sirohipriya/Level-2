//===============================================================Infinite Permutations=======================================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int cc_infiPermutation(int[] arr, int tar, String psf){
        if (tar == 0){
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int ele : arr)
            if (tar - ele >= 0)
                count += cc_infiPermutation(arr, tar - ele, psf + ele);

        return count;
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        String psf = "";

        System.out.println(cc_infiPermutation(arr, tar, psf));

    }
}



//=============================================================================Infinite Combinations=====================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int cc_infiCombination(int[] arr, int idx, int tar, String psf){
        if (tar == 0){
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++){
            if (tar - arr[i] >= 0){
                count += cc_infiCombination(arr, i, tar - arr[i], psf + arr[i]);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        String psf = "";

        System.out.println(cc_infiCombination(arr, 0, tar, psf));
    }
}


//================================================================Single Combinations========================================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int cc_singleCombination(int[] arr, int idx, int tar, String psf){
        if (tar == 0){
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < arr.length; i++){
            if (tar - arr[i] >= 0){
                count += cc_singleCombination(arr, i + 1, tar - arr[i], psf + arr[i]);
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        String psf = "";

        System.out.println(cc_singleCombination(arr, 0, tar, psf));
    }
}



//=============================================================================Single Permutations===========================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int cc_singlePermutation(int[] arr, int tar, String psf){
        if (tar == 0){
            System.out.println(psf);
            return 1;
        }
    
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            int ele = arr[i];
            if (arr[i] > 0 && tar - ele >= 0){
                arr[i] = -arr[i];
                count += cc_singlePermutation(arr, tar - ele, psf + ele);
                arr[i] = -arr[i];
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        String psf = "";

        System.out.println(cc_singlePermutation(arr, tar, psf));
    }
}



