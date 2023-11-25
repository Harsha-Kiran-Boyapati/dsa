package dsa.others;

    public class SplitNumString {
        public int numArrays(String s, int maxVal){
            int[] dp = new int[s.length()];
            if(s.isEmpty()) return 0;
//            if(s.charAt(0)!='0') dp[0] = 1;
            int n = s.length();
            for(int i=0; i<s.length(); i++){
                //cannot break string here
                if(i+1!=n && s.charAt(i+1) == '0')continue;
                int j=0;
                while(i-j>=0){
                    if(s.charAt(i-j)=='0'){j++;continue;}
                    int num = Integer.parseInt(s.substring(i-j,i+1));
                    if(num<=maxVal) dp[i]+= i-j-1>=0?dp[i-j-1]:1;
                    else break;
                    j++;
                }
            }
            return dp[n-1];
        }
    }
