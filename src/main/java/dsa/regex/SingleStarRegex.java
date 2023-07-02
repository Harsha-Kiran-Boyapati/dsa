package dsa.regex;

//Given a string s and pattern p with utmost one star
//match s and p
//* can match any character
public class SingleStarRegex {
    public static boolean match(String s, String p) {
        if(s.isEmpty()) return (p.isEmpty() || p.equals("*"));
        if(p.isEmpty()) return false;

        //now none is empty

        if(!p.contains("*")) return s.equals(p);
        int starIdx = p.indexOf('*');
        String prefix = p.substring(0, starIdx), suffix = p.substring(starIdx+1);

        if(prefix.isEmpty() && suffix.isEmpty()) return true;
        if(prefix.isEmpty()) return s.endsWith(suffix);
        if(suffix.isEmpty()) return s.startsWith(prefix);
        return s.startsWith(prefix) && s.substring(prefix.length()).endsWith(suffix);
    }
}
