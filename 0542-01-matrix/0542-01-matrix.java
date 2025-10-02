class Solution {
    class Pair{

        int r;
        int c ;
        int d;

        Pair(int r , int c , int d){
            this.r = r ;
            this.c = c;
            this.d = d;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length ;
        int n = mat[0].length;
        int distance [][]= new int[m][n];
        boolean visited[][] = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();

        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){

                if(mat[i][j] ==0){
                    q.add(new Pair(i , j , 0));
                    visited[i][j] = true;
                }
            }
        }
        int dirs [][] = {{0,1} , {1 ,0} ,{-1,0} , {0,-1}};
        while(!q.isEmpty()){
            
            Pair curr = q.poll();
            int row = curr.r ;
            int col = curr.c;
            int dis = curr.d;
            distance[row][col] = dis;
            for(int d=0 ; d<=3 ; d++){
                int nrow = row + dirs[d][0];
                int ncol = col + dirs[d][1];

                if(nrow>=0 && nrow <m && ncol>=0 && ncol <n && !visited[nrow][ncol]){
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow , ncol , dis+1));
                }
            }
        }

        return distance;
    }
}