//==========================================================================Queen Combination Sub================================================================================


import java.io.*;
import java.util.*;

public class Main {
    
    public static int queenCombination_sub(boolean[] board, int idx, int tnq, int qpsf, String asf) {
        if (qpsf == tnq || idx == board.length) {
            if (qpsf == tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += queenCombination_sub(board, idx + 1, tnq, qpsf + 1, asf + "b" + idx + "q" + qpsf + " ");

        count += queenCombination_sub(board, idx + 1, tnq, qpsf, asf);

        return count;
    }

    public static void main(String[] args) {
        int n = 5, tnq = 3;
        boolean[] board = new boolean[n];

        System.out.println(queenCombination_sub(board, 0, tnq, 0, ""));
    }
}


//==================================================================================Queen Permutations Sub=======================================================================
