//=====================================================================52. NQueens 2 OP================================================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int NQueenComb01(int n, int m, int floor, int queen, boolean[] rows, boolean[] cols, boolean[] diag, boolean[]adiag){
        if (queen == 0){
            return 1;
        }

        int count = 0;
        for (int room = 0; room < n; room++){
            int r = floor, c = room;
            if(!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += NQueenComb01(n, m, floor + 1, queen - 1, rows, cols, diag, adiag);
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int n = 4, queen = 4;
        boolean[] rows=new boolean[n];
        boolean[] cols=new boolean[n];
        boolean[] diag=new boolean[2*n-1];
        boolean[] adiag=new boolean[2*n-1];
        boolean[][] board = new boolean[n][n];

        System.out.println(NQueenComb01(n, n, 0, queen, rows, cols, diag, adiag));
    }   
}




//===============================================================================52. Nqueens 2=============================================================================



import java.io.*;
import java.util.*;

public class Main {
    public static int NQueenComb01(int n, int m, int idx, int tnq, String asf, boolean[] rows, boolean[] cols, boolean[] diag, boolean[]adiag){
        if (tnq == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < n * m; i++){
            int r = i / m, c = i % m;
            if(!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += NQueenComb01(n, m, i + 1, tnq - 1, asf + "(" + r + "," + c + ") ", rows, cols, diag, adiag);
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int n = 4, tnq = 4;
        boolean[] rows=new boolean[n];
        boolean[] cols=new boolean[n];
        boolean[] diag=new boolean[2*n-1];
        boolean[] adiag=new boolean[2*n-1];
        boolean[][] board = new boolean[n][n];

        System.out.println(NQueenComb01(n, n, 0, tnq, "", rows, cols, diag, adiag));
    }   
}
