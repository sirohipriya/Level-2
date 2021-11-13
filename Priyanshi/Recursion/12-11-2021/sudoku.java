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
