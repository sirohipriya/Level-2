//=====================================================================NQueen Combination===================================================================================================


import java.io.*;
import java.util.*;

public class Main {
    public static int NQueenComb(boolean[][] board, int idx, int tnq, String asf){
        if (tnq == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = idx; i < n * m; i++){
            int r = i / m, c = i % m;
            if(isSafe(board, r, c)){
                board[r][c] = !board[r][c];
                count += NQueenComb(board, i + 1, tnq - 1, asf + "(" + r + "," + c + ") ");
                board[r][c] = !board[r][c];
            }
        }
        return count;
    }
    public static boolean isSafe(boolean[][] board, int sr, int sc){
        int n = board.length, m = board[0].length;
        int[][] dir= {{0, -1}, {-1, 0}, {-1, -1}, {-1, 1}};
        for(int[] d : dir){
            int r = sr;
            int c = sc;
            while(r >= 0 && c >= 0 && r < n && c < m){
                if(board[r][c]){
                    return false;
                }
                r += d[0];
                c += d[1];
            }
        }
        return true;
    }
    public static void main(String[] args){
        int n = 4, tnq = 4;
        boolean[][] board = new boolean[n][n];

        System.out.println(NQueenComb(board, 0, tnq, ""));
    }   
}



//==============================================================================NQueen Combination 01====================================================================================



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



//============================================================================NQueen Permutation==============================================================================



import java.io.*;
import java.util.*;

public class Main {
    public static int NQueenPer(boolean[][] board, int idx, int tnq, String asf){
        if (tnq == 0){
            // System.out.println(asf);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = idx; i < n * m; i++){
            int r = i / m, c = i % m;
            if(isSafe(board, r, c)){
                board[r][c] = !board[r][c];
                count += NQueenPer(board, 0, tnq - 1, asf + "(" + r + "," + c + ") ");
                board[r][c] = !board[r][c];
            }
        }
        return count;
    }
    public static boolean isSafe(boolean[][] board, int sr, int sc){
        int n = board.length, m = board[0].length;
        //add directions here
        int[][] dir = { { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        for(int[] d : dir){
            int r = sr;
            
            int c = sc;
            while(r >= 0 && c >= 0 && r < n && c < m){
                if(board[r][c]){
                    return false;
                }
                r += d[0];
                c += d[1];
            }
        }
        return true;
    }
    public static void main(String[] args){
        int n = 4, tnq = 4;
        boolean[][] board = new boolean[n][n];

        System.out.println(NQueenPer(board, 0, tnq, ""));
    }   
}




//=============================================================================NQueen Permutation 01==========================================================================



import java.io.*;
import java.util.*;

public class Main {
    public static int NQueenPerm01(int n, int m, int idx, int tnq, String asf, boolean[] rows, boolean[] cols, boolean[] diag, boolean[]adiag){
        if (tnq == 0){
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < n * m; i++){
            int r = i / m, c = i % m;
            if(!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += NQueenPerm01(n, m, 0, tnq - 1, asf + "(" + r + "," + c + ") ", rows, cols, diag, adiag);
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

        System.out.println(NQueenPerm01(n, n, 0, tnq, "", rows, cols, diag, adiag));
    }   
}


//=======================================================================NQueen Op===========================================================================================


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



//============================================================================NQueen Rect===================================================================================


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
        int n = 3, m = 4, tnq = 2;
        boolean[] rows=new boolean[n];
        boolean[] cols=new boolean[m];
        boolean[] diag=new boolean[m + n-1];
        boolean[] adiag=new boolean[m + n -1];
        boolean[][] board = new boolean[n][n];

        System.out.println(NQueenComb01(n, m, 0, tnq, "", rows, cols, diag, adiag));
    }   
}



//=======================================================================NQueen Rect Op Sub======================================================================================



import java.io.*;
import java.util.*;

public class Main {
    public static int NQueenComb01(int n, int m, int floor, int queen, String asf, boolean[] rows, boolean[] cols, boolean[] diag, boolean[]adiag){
        if(queen == 0 || floor == n){
            if (queen == 0){
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int room = 0; room < m; room++){
            int r = floor, c = room;
            if(!rows[r] && !cols[c] && !diag[r + c] && !adiag[r - c + m - 1]){
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = true;
                count += NQueenComb01(n, m, floor + 1, queen - 1,asf + "(" + r + "," + c + ") ", rows, cols, diag, adiag);
                rows[r] = cols[c] = diag[r + c] = adiag[r - c + m - 1] = false;
            }
        }
        count += NQueenComb01(n, m, floor + 1, queen, asf, rows, cols, diag, adiag);

        return count;
    }
    public static void main(String[] args){
        int n = 3, m = 4, queen = 2;
        boolean[] rows=new boolean[n];
        boolean[] cols=new boolean[m];
        boolean[] diag=new boolean[n + m -1];
        boolean[] adiag=new boolean[n + m -1];
        boolean[][] board = new boolean[n][m];

        System.out.println(NQueenComb01(n, m, 0, queen, "", rows, cols, diag, adiag));
    }   
}



