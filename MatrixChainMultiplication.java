public class MatrixChainMultiplication {
    public int minScoreTriangulation(int[] A) {
        int n = A.length;
        int i=1;
        int j=n-1;
        int[][] t = new int[n+1][n+1];
        initalizeArray(t);
        return solve(A,i,j,t);

    }

    public int solve(int[] A, int i,int j,int[][] t){
        if(i>=j)
            return 0;
        int min = Integer.MAX_VALUE;
        if(t[i][j] != -1)
            return t[i][j];
        for(int k=i;k<=j-1;k++){
            int temp = solve(A,i,k,t)+solve(A,k+1,j,t)+(A[i-1]*A[k]*A[j]);
            if(temp<min){
                min=temp;
            }
            t[i][j] = min;
        }


        return t[i][j];


    }

    public void initalizeArray(int[][] t){
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }
    }
}
