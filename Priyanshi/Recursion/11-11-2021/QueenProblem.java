//===========================================================================Queen Combination=========================================================================

import java.io.*;
import java.util.*;

public class Main {
      public static int queenCombination(boolean[] board, int idx, int tnq, int qpsf, String asf){
        if (qpsf == tnq)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < board.length; i++){
            count += queenCombination(board, i + 1, tnq, qpsf + 1, asf + "b" + i + "q" + qpsf + " ");
        }

        return count;
    }
    public static void main(String[] args){
        int n = 5, tnq = 3;
        boolean[] board = new boolean[n];

        System.out.println(queenCombination(board, 0, tnq, 0, ""));
    } 
}


//===============================================================================Queen permutation=========================================================================


import java.io.*;
import java.util.*;

public class Main {
      public static int queenPer(boolean[] board, int idx, int tnq, int qpsf, String asf){
        if (qpsf == tnq)
        {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < board.length; i++){
             if (!board[i]){
                  board[i] = !board[i];
                  count += queenPer(board, 0, tnq, qpsf + 1, asf + "b" + i + "q" + qpsf + " ");
                  board[i] = !board[i];
             }
        }

        return count;
    }
    public static void main(String[] args){
        int n = 5, tnq = 3;
        boolean[] board = new boolean[n];

        System.out.println(queenPer(board, 0, tnq, 0, ""));
    }  
}


//======================================================================Queen Combination 2D=================================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int queenCombination2D(boolean[][] board, int idx, int tnq, String asf){
        if (tnq == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = idx; i < n * m; i++){
            int r = i / m, c = i % m;
            count += queenCombination2D(board, i + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
        }
        return count;
    }
    public static void main(String[] args){
        int n = 4, tnq = 4;
        boolean[][] board = new boolean[n][n];

        System.out.println(queenCombination2D(board, 0, tnq, ""));
    }   
}


//==========================================================================Queen permutation 2D============================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int queenPerm2D(boolean[][] board, int idx, int tnq, String asf){
        if (tnq == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = idx; i < n * m; i++){
            int r = i / m, c = i % m;
            if (!board[r][c]){
                  board[r][c] = !board[r][c];
                  count += queenPerm2D(board, 0, tnq - 1, asf + "(" + r + "," + c + ") ");
                  board[r][c] = !board[r][c];
            }
        }
        return count;
    }
    public static void main(String[] args){
        int n = 4, tnq = 4;
        boolean[][] board = new boolean[n][n];

        System.out.println(queenPerm2D(board, 0, tnq, ""));
    }  
}
