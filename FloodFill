//======================================================================FloodFill 01=========================================================================================


import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws Exception{
        
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
        String[] dirS = { "d", "u", "r", "l", "S", "E", "N", "W" };
        
        boolean[][] vis = new boolean[3][3];
        int res = floodFill(0, 0, 2, 2, vis, dir, dirS, "");
        System.out.println(res);
    }

    public static int floodFill(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS, String psf) {
        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }
        
        int count = 0;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c])
                count += floodFill(r, c, er, ec, vis, dir, dirS, psf + dirS[d]);
        }
        vis[sr][sc] = false;
        return count;
    }
}



//==============================================================================FLoodFill SinglePath========================================================================


import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws Exception{
        
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
        String[] dirS = { "d", "u", "r", "l", "S", "E", "N", "W" };
        
        boolean[][] vis = new boolean[3][3];
        boolean res = floodFill_singlePath(0, 0, 2, 2, vis, dir, dirS, "StartingPoint" + "");
        System.out.println(res);
    }

    public static boolean floodFill_singlePath(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS, String psf) {
        if (sr == er && sc == ec) {
            System.out.println(psf + "->" + "EndingPoint");
            return true;
        }
        
        int count = 0;
        vis[sr][sc] = true;
        boolean res = false;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c])
                res = res || floodFill_singlePath(r, c, er, ec, vis, dir, dirS, psf + " -> " + dirS[d]);
        }
        
        vis[sr][sc] = false;
        return res;
    }
}


//===============================================================================Longest Shortest path=======================================================================



import java.io.*;
import java.util.*;

public class Main {
    
    public static class floodFillPair {
        String lpath = "";
        String spath = "";
        int lLen = 0;
        int sLen = (int) 1e9;
        boolean isPathFound = false;
    }
    
     public static void main(String[] args) throws Exception{
        
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
        String[] dirS = { "d", "u", "r", "l", "S", "E", "N", "W" };
        
        boolean[][] vis = new boolean[3][3];
        
        floodFillPair ans = floodFill_LS_Path(0, 0, 2, 2, vis, dir, dirS);
        System.out.println("Longest Path: " + ans.lpath + " @ " + ans.lLen);
        System.out.println("Shortest Path: " + ans.spath + " @ " + ans.sLen);
    }

    public static floodFillPair floodFill_LS_Path(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS) {
        if (sr == er && sc == ec) {
            floodFillPair base = new floodFillPair();
            base.isPathFound = true;
            base.sLen = 0;
            return base;
        }
        
        int count = 0;
        vis[sr][sc] = true;
        floodFillPair ans = new floodFillPair();
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c]) {
                floodFillPair recRes = floodFill_LS_Path(r, c, er, ec, vis, dir, dirS);
                if (recRes.isPathFound) {
                    ans.isPathFound = true;
                    if (recRes.lLen + 1 > ans.lLen) {
                        ans.lLen = recRes.lLen + 1;
                        ans.lpath = dirS[d] + recRes.lpath;
                    }
                    if (recRes.sLen + 1 < ans.sLen) {
                        ans.sLen = recRes.sLen + 1;
                        ans.spath = dirS[d] + recRes.spath;
                    }
                }
            }
        }
        vis[sr][sc] = false;
        return ans;
    }

}



//====================================================================FLoodFill with Jump 01======================================================================================



import java.io.*;
import java.util.*;

public class Main {
    
     public static void main(String[] args) throws Exception{
        
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
        String[] dirS = { "d", "u", "r", "l", "S", "E", "N", "W" };
        
        boolean[][] vis = new boolean[3][3];
        
        int ans = floodFill_jump(0, 0, 2, 2, vis, dir, dirS, "");
        System.out.println(ans);
     }

    public static int floodFill_jump(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS,
            String psf) {

        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int rad = 1; rad <= Math.max(er, ec); rad++)
            for (int d = 0; d < dir.length; d++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec && !vis[r][c])
                    count += floodFill_jump(r, c, er, ec, vis, dir, dirS, psf + rad + dirS[d]);
            }
        vis[sr][sc] = false;
        return count;
    }

}


//======================================================================FloodFill with Jump 02================================================================================


import java.io.*;
import java.util.*;

public class Main {
    
     public static void main(String[] args) throws Exception{
        
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
        String[] dirS = { "d", "u", "r", "l", "S", "E", "N", "W" };
        
        boolean[][] vis = new boolean[3][3];
        
        int ans = floodFill_jump_2(0, 0, 2, 2, vis, dir, dirS, "");
        System.out.println(ans);
     }

    public static int floodFill_jump_2(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS, String psf) {

        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++)
            for (int rad = 1; rad <= Math.max(er, ec); rad++) {
                int r = sr + rad * dir[d][0];
                int c = sc + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                    if (!vis[r][c])
                        count += floodFill_jump_2(r, c, er, ec, vis, dir, dirS, psf + rad + dirS[d]);
                } else
                    break;
            }
        vis[sr][sc] = false;
        return count;
    }

}



//=====================================================================FloodFill with Jump 03=================================================================================



import java.io.*;
import java.util.*;

public class Main {
    
     public static void main(String[] args) throws Exception{
        
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
        String[] dirS = { "d", "u", "r", "l", "S", "E", "N", "W" };
        
        boolean[][] vis = new boolean[3][3];
        
        int ans = floodFill_jump_3(0, 0, 2, 2, vis, dir, dirS, "");
        System.out.println(ans);
     }

    public static int floodFill_jump_3(int sr, int sc, int er, int ec, boolean[][] vis, int[][] dir, String[] dirS, String psf) {

        if (sr == er && sc == ec) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0], c = sc + dir[d][1];
            int rad = 1;
            while (r >= 0 && c >= 0 && r <= er && c <= ec) {
                if (!vis[r][c])
                    count += floodFill_jump_3(r, c, er, ec, vis, dir, dirS, psf + rad + dirS[d]);
                r += dir[d][0];
                c += dir[d][1];
                rad++;
            }
        }
        vis[sr][sc] = false;
        return count;
    }

}



//=========================================================================Knights Tour======================================================================================



import java.io.*;
import java.util.*;

public class Main {
    
     public static void main(String[] args) throws Exception{
        
        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
        int[][] board = new int[5][5];
        
        boolean ans = knightTour(0, 0, board, dir, 0);
        System.out.println(ans);
     }

    public static boolean knightTour(int sr, int sc, int[][] board, int[][] dir, int count) {

        int n = board.length, m = board[0].length;
        board[sr][sc] = count;
        if (count == n * m) {
            return true;
        }

        boolean res = false;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 0)
                res = res || knightTour(r, c, board, dir, count + 1);

        }
        if (!res)
            board[sr][sc] = 0;
        return res;
    }

}

