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




import java.io.*;
import java.util.*;

public class Main {
    
    public static int queenPer_Sub(boolean[] board, int idx, int tnq, int qpsf, String asf){
        if (qpsf == tnq || idx == board.length)
        {
            if(qpsf == tnq){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
             if (!board[idx]){
                  board[idx] = !board[idx];
                  count += queenPer_Sub(board, 0, tnq, qpsf + 1, asf + "b" + idx + "q" + qpsf + " ");
                  board[idx] = !board[idx];
             }
        count += queenPer_Sub(board, idx + 1, tnq, qpsf, asf);


        return count;
    }

    public static void main(String[] args) {
        int n = 5, tnq = 3;
        boolean[] board = new boolean[n];

        System.out.println(queenPer_Sub(board, 0, tnq, 0, ""));
    }
}


//====================================================================Queen Combinations Sub 2D===============================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int queenCombination2D_sub(boolean[][] board, int idx, int tnq, String asf){
        int count = 0, n = board.length, m = board[0].length;
        if (tnq == 0 || idx == n * m){
            if(tnq == 0){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        
        int r = idx / m, c = idx % m;
        count += queenCombination2D_sub(board, idx + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
        count += queenCombination2D_sub(board, idx + 1, tnq, asf);

        return count;
    }
    public static void main(String[] args){
        int n = 4, tnq = 4;
        boolean[][] board = new boolean[n][n];

        System.out.println(queenCombination2D_sub(board, 0, tnq, ""));
    }   
}



//===================================================================Queen Permuta
