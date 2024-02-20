package com.prudhvi.geeks_for_geeks.february;

public class Feb_21_BooleanParenthesization {

	public static void main(String[] args) {
		int n = 5;
		String s = "T^F|F";
		System.out.println(countWays(n, s));

	}
	/**
	 * Counts the number of ways to parenthesize the given expression such that it evaluates to true.
	 *
	 * @param N The length of the expression.
	 * @param expression The input expression containing operands ('T' and 'F') and operators ('|', '&', '^').
	 * @return The number of ways to parenthesize the expression to make it true.
	 *
	 * Time Complexity: O(N^3), where N is the length of the expression.
	 * Space Complexity: O(N^2).
	 */
	public static int countWays(int N, String expression){
        int mod=1003;
		StringBuilder operand=new StringBuilder();
		StringBuilder operator=new StringBuilder();
		for(int i=0;i<expression.length();i++) {
			char ch=expression.charAt(i);
			if(ch=='|' || ch=='^' || ch=='&' )
				operator.append(ch);
			else
				operand.append(ch);
		}
		int n=operand.length();
		long[][] dpTrue=new long[n][n];
		long[][] dpFalse=new long[n][n];
		for(int d=0;d<n;d++) {
			for(int i=0,j=d;j<n;j++,i++) {
				// Base case for substrings of length 1
				if(d==0) {
					if(operand.charAt(i)=='T') {
						dpTrue[i][j]=1;
						dpFalse[i][j]=0;
					}else {
						dpTrue[i][j]=0;
						dpFalse[i][j]=1;
					}
				}
				// Build the DP table for substrings of length greater than 1
				else {
					for(int k=i;k<j;k++){
						char ch=operator.charAt(k);
						long leftTrue=dpTrue[i][k];
						long leftFalse=dpFalse[i][k];
						long rightTrue=dpTrue[k+1][j];
						long rightFalse=dpFalse[k+1][j];
						if(ch=='&') {
							long trueWays=(leftTrue*rightTrue)%mod;
							long falseWays=(leftFalse*rightFalse)%mod+(leftFalse*rightTrue)%mod+(leftTrue*rightFalse)%mod;
							dpTrue[i][j]=(dpTrue[i][j]+trueWays)%mod;
							dpFalse[i][j]=(dpFalse[i][j]+falseWays)%mod;
						}else if(ch=='|') {
							long trueWays=(leftFalse*rightTrue)%mod+(leftTrue*rightFalse)%mod+(leftTrue*rightTrue)%mod;
							long falseWays=(leftFalse*rightFalse);
							dpTrue[i][j]=(dpTrue[i][j]+trueWays)%mod;
							dpFalse[i][j]=(dpFalse[i][j]+falseWays)%mod;
						}else if(ch=='^'){
							long trueWays=(leftFalse*rightTrue)%mod+(leftTrue*rightFalse)%mod;
							long falseWays=(leftFalse*rightFalse)%mod+(leftTrue*rightTrue)%mod;
							dpTrue[i][j]=(dpTrue[i][j]+trueWays)%mod;
							dpFalse[i][j]=(dpFalse[i][j]+falseWays)%mod;
						}
						
					}
				}
			}
		}
		return (int)(dpTrue[0][n-1]%mod);
    }

}
