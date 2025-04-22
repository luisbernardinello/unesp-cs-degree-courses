package leetcode.slidingwindow.permutationinstring;
import java.util.*;
//https://leetcode.com/problems/permutation-in-string/
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        //define table
        int[] arr = new int[128];
        //define pointers
        int left = 0;
        int right = 0;

        //fill up our table
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int n = s2Arr.length;
        for(char cur : s1Arr) {
            arr[cur]++;
        }
        //define minLen
        int minLen = Integer.MAX_VALUE;
        //define counter
        int counter = 0;

        //check if there is a permutation
        while (right < n) {
            //expand window
            char currentChar = s2Arr[right];
            if(--arr[currentChar] >= 0) {
                counter++;
            }
            //contract window
            while(counter == s1.length()) {
                int currentLen = right - left + 1;
                minLen = Math.min(minLen, currentLen);
                char leftChar = s2Arr[left];
                if(++arr[leftChar] > 0) {
                    counter--;
                }
                left++;

            }
            right++;
        }
        //return if minLen == size of s1
        return minLen == s1.length();


    }


    public boolean checkInclusion2(String s1, String s2) {
        // Verificação rápida para evitar execução desnecessária
        if (s1.length() > s2.length()) return false;

        // Definir tabela de frequência usando HashMap
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, counter = 0;
        int n = s2.length();

        // Preencher o HashMap com a frequência dos caracteres de s1
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Verificar se há uma permutação em s2
        while (right < n) {
            char currentChar = s2.charAt(right);

            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) - 1);
                if (map.get(currentChar) >= 0) {
                    counter++;
                }
            }

            // Quando a janela atingir o tamanho de s1, verificamos se encontramos uma permutação
            while (counter == s1.length()) {
                if (right - left + 1 == s1.length()) return true;

                char leftChar = s2.charAt(left);
                if (map.containsKey(leftChar)) {
                    if (map.get(leftChar) >= 0) {
                        counter--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
                left++;
            }

            right++;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
