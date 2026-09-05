class Solution {
    public int numIslands(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int count= 0;

        if(n==0) return 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] arr, int i, int j){
        if(i>=arr.length || i<0 || j>=arr[0].length || j<0 || arr[i][j]=='0'){
            return;
        }

        arr[i][j]= '0';
        dfs(arr, i+1, j);
        dfs(arr, i, j+1);
        dfs(arr, i-1, j);
        dfs(arr, i, j-1);
    }

}