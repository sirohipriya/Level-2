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



//=============================================================================51. NQueen======================================================================================




class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        explore(grid, result, n, 0);
        return result;
    }
    
    void explore(boolean[][] grid, List<List<String>> result, int n, int row){
        if(n == row){
            result.add(getGridAsListOfStrings(grid));
            return;
        }
        
        for(int i=0; i < n; i++){
            if(canPlaceQueen(grid, row, i, n)){
                grid[row][i] = true;
                explore(grid, result, n, row+1);
                grid[row][i] = false;
            }
        }
    }
    
    boolean canPlaceQueen(boolean[][] grid, int row, int col, int n){
        for(int i=row-1; i >=0; i--)
            if(grid[i][col]) return false;
        
        for(int i=row-1, j=col-1; i >=0 && j >= 0; i--, j--)
            if(grid[i][j]) return false;        
        
        for(int i=row-1, j=col+1; i >=0 && j < n; i--, j++)
            if(grid[i][j]) return false;
        
        return true;
    }
    
    List<String> getGridAsListOfStrings(boolean[][] grid){
        List<String> ans = new ArrayList<>();
        for(int i=0; i < grid.length; i++){
            StringBuilder currRow = new StringBuilder();
            for(int j=0; j < grid.length; j++){
                if(grid[i][j]) 
                    currRow.append("Q");
                else
                    currRow.append(".");
            }
            ans.add(currRow.toString());
        }
        return ans;
    }
}



//=============================================================================Sudoku solver=================================================================================




import java.util.*;

public class sudoku {

public boolean isSafe(char[][] board, int num, int r, int c) {
		
		for(int j=0; j<9; ++j) {
			if(board[r][j]-'0'==num) {
				return false;
			}
		}
		
		for(int i=0; i<9; ++i) {
			if(board[i][c]-'0'==num) {
				return false;
			}
		}
		
		r=(r/3)*3;
		c=(c/3)*3;
		
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				if(board[r+i][c+j]-'0'==num) {
					return false;
				}
			}
		}
		
		return true;
	}
    
    public boolean solveSudoku(char[][] board, int idx, ArrayList<Integer> cells){
        if(idx==cells.size()){
            return true;
        }
        
        int r=cells.get(idx)/9, c=cells.get(idx)%9;
        
        for(int num=1; num<=9; ++num){
            if(isSafe(board, num, r, c)){
                board[r][c]=(char)('0'+num);
                if(solveSudoku(board, idx+1, cells)){
                    return true;
                }
                board[r][c]='.';
            }
        }
        
        return false;
        
    }
    
    public void solveSudoku(char[][] board){
        ArrayList<Integer> cells=new ArrayList<>();
        
        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                if(board[i][j]=='.'){
                    cells.add(i*9+j);
                }
            }
        }
        
        solveSudoku(board, 0, cells);
    }
}




