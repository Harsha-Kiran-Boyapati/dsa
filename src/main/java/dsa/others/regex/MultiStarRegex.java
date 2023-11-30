package dsa.others.regex;

public class MultiStarRegex {
    public static boolean match(String s, String p){
        //avoid cosequetive stars in p
        //so merge consequetive stars
        StringBuilder pb = new StringBuilder();

        return helper(s,mergeStars(p),0,0);
    }
    private static String mergeStars(String s){
        StringBuilder sb = new StringBuilder();
        boolean hasStar = false;
        for(char c: s.toCharArray()){
            if(c=='*' && !hasStar){
                sb.append(c); hasStar = true;
            }
            if(c!='*'){
                sb.append(c); hasStar = false;
            }
        }
        return sb.toString();
    }
    private static boolean helper(String s, String p, int sIdx, int pIdx){
        //if string ended
        if(sIdx==s.length()) return pIdx==p.length() || pIdx==p.length()-1&&p.charAt(pIdx)=='*';
        //if pattern ended but not string
        else if(pIdx==p.length())return false;
        while(pIdx<p.length() && sIdx <s.length()){
            if(p.charAt(pIdx)!='*'){
                if(s.charAt(sIdx) == p.charAt(pIdx)){
//                    if(sIdx==s.length()-1 && (sIdx == s.length()-1) || pIdx ==s.length()-2 && s.charAt(s.length()-1) == '*') return true;
//                    else{
                        pIdx++; sIdx++; continue;
//                    }
                }
                else return false;
            }else{
                //if the char at pIdx is *
                if(pIdx == p.length()-1) return true;

                for(int subSIdx = sIdx ; subSIdx<s.length(); subSIdx++){
                    boolean subStrMatched = helper(s,p, subSIdx, pIdx+1);
                    if(subStrMatched) return true;
                }
                return false;
            }
        }

        if(pIdx == p.length() && sIdx == s.length()) return true;
        if(sIdx == s.length() && pIdx ==p.length()-1 && p.charAt(pIdx)=='*')return true;
       return false;

    }
}
