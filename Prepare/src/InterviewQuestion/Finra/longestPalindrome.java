package InterviewQuestion.Finra;

public class longestPalindrome {
    public static int longetP(String s) {
        int len = s.length();
        boolean[][] check = new boolean[len][len];

        int res = 0;
        for(int i = 0; i < len; i++) {
            int j = i;
            while(j >= 0) {
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || check[j+1][i-1])) {
                    check[j][i] = true;
                    res = Math.max(res, i - j + 1);
                }
                j--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(longetP("abcbaa"));
    }
}
