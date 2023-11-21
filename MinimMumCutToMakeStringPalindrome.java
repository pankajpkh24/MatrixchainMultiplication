import java.util.Arrays;

public class MinimMumCutToMakeStringPalindrome {

    public int minCut(String s) {
        if(s==null || s.length()==0)
            return 0;
        int i=0;
        int j= s.length()-1;
        int[][] dp = new int[j+1][j+1];
        for(int[] a :dp){
            Arrays.fill(a,-1);
        }
        int left =0;
        int right=0;
        return minCutAns(s,i,j,dp,left,right);

    }

    public int minCutAns(String s, int i, int j,int[][] dp,int left, int right){

        if(i>j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(isPalindrome(s,i,j)){
            //  System.out.println(s.substring(i,j));
            return 0;
        }

        //int min = Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        //int temp =0;
        for(int k=i;k<=j-1;k++){

            if(dp[i][k] != -1){
                left = dp[i][k];
            }
            else{
                left = minCutAns(s,i,k,dp,left,right);
                dp[i][k]=left;
            }

            if(dp[k+1][j] != -1){
                right = dp[k+1][j];
            }
            else{
                right = minCutAns(s,k+1,j,dp,left,right);
                dp[k+1][j]=right;
            }

            int temp = 1+left+right;

            //  int temp = 1+ minCutAns(s,i,k)+minCutAns(s,k+1,j);

            ans=Math.min(temp,ans);

        }
        return  dp[i][j] = ans;
    }

    private boolean isPalindrome(String s, int low ,int high){
        while(low<=high)
        {
            if(s.charAt(low) != s.charAt(high))
                return false;

            low++; high--;
        }

        return true;
    }
}
