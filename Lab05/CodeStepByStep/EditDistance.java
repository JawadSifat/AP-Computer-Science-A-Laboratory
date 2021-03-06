public static int different(char c1, char c2){
    if(c1 == c2)
        return 0;
    return 1;
}

public static int editDistance(String s1, String s2){
    if (s1.length() == 0)
        return s2.length();
    if (s2.length() == 0)
        return s1.length();
    int replace = editDistance(s1.substring(1), s2.substring(1)) + different(s1.charAt(0), s2.charAt(0));
    int delete = editDistance(s1.substring(1), s2) + 1;
    int insert = editDistance(s1, s2.substring(1)) + 1;
    return Math.min(replace, Math.min(delete, insert));
}

