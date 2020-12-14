class Solution {
    public boolean isAnagram(String s, String t) {
        // 法一：
//        if (s.length() != t.length())
//            return false;
//        char [] chs = s.toCharArray();
//        char [] cht = t.toCharArray();
//        Arrays.sort(chs);
//        Arrays.sort(cht);
//        return Arrays.equals(chs,cht);
        // 法二
        if (s.length() != t.length()){
            return false;
        }
        int [] table = new int[26];
        for (int i =0;i<s.length();i++){
            table[s.charAt(i)-'a']++;
        }
        for (int j = 0;j<t.length();j++){
            table[t.charAt(j)-'a']--;
            if(table[t.charAt(j)-'a']<0){
                return false;
            }
        }
        return true;
    }
}