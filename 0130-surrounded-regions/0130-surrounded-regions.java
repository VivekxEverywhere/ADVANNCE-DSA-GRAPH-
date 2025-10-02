class Solution {
    void dfs(char[][] mat, int i, int j, int n, int m, boolean[][] vis) {
        if(i<0 || j<0 || i>=n || j>=m || mat[i][j]=='X' || vis[i][j]) return;
        vis[i][j] = true;
        dfs(mat,i+1,j,n,m,vis);
        dfs(mat,i-1,j,n,m,vis);
        dfs(mat,i,j+1,n,m,vis);
        dfs(mat,i,j-1,n,m,vis);
    }
    public void solve(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<m;i++){
            if(mat[0][i]=='O') dfs(mat,0,i,n,m,vis);
            if(mat[n-1][i]=='O') dfs(mat,n-1,i,n,m,vis);
        }
        for(int i=0;i<n;i++) {
            if(mat[i][0]=='O') dfs(mat,i,0,n,m,vis);
            if(mat[i][m-1]=='O') dfs(mat,i,m-1,n,m,vis);
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(vis[i][j]==true) {
                    mat[i][j] = 'O';
                }else{
                    mat[i][j]='X';
                }
            }
        }
    }
}