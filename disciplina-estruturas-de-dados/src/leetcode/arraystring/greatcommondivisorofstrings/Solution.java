package leetcode.arraystring.greatcommondivisorofstrings;

public class Solution {

    public String gcdOfStrings(String str1, String str2) {
        int g = gcd(str1.length(), str2.length());

        String ans = str1.substring(0, g);

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();


        s1.ensureCapacity(str1.length());
        s2.ensureCapacity(str2.length());

        for (int i = 0; i < str1.length() / g; i++) {
            s1.append(ans);
        }

        for (int i = 0; i < str2.length() / g; i++) {
            s2.append(ans);
        }

        if (s1.toString().equals(str1) && s2.toString().equals(str2)) {
            return ans;
        }
        return "";
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(new Solution().gcdOfStrings(str1, str2));
    }
}
