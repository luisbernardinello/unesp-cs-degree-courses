package leetcode.slidingwindow.minimumwindowsubstring;
import java.util.*;
//https://leetcode.com/problems/minimum-window-substring/
public class Solution {

    public String minWindow(String s, String t) {
        // define table
        int[] arr = new int[128];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n = sArr.length;

        //increment each character in t by one
        for(char current : tArr) {
            arr[current]++;
        }
        //define pointers
        int left = 0;
        int right = 0;
        //define minLen
        int minLength = Integer.MAX_VALUE;
        //define ans
        String ans = "";
        int counter = 0;
        //find the min window
        while(right < n) {
            //expand window
            char currentChar = sArr[right];
            if(--arr[currentChar] >= 0) {
                counter++;
            }
            //contract the window
            while(counter == tArr.length) {
                int currentWindow = right - left + 1;
                if(currentWindow < minLength) {
                    minLength = currentWindow;
                    ans = s.substring(left, right + 1);
                }
                char leftChar = sArr[left];
                if(++arr[leftChar] > 0) {
                    counter--;
                }
                left++;
            }
            right++;
        }
        //return ans
        return ans;


    }


    public String minWindowMap(String s, String t) {
        // Map para armazenar a frequência de cada caractere em t
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        // Map para rastrear os caracteres da janela atual
        Map<Character, Integer> windowMap = new HashMap<>();

        // Inicializa os ponteiros e variáveis
        int left = 0;
        int right = 0;
        int counter = 0; // Conta quantos caracteres necessários já foram atendidos
        int minLength = Integer.MAX_VALUE; // Comprimento mínimo da janela
        String result = ""; // Resultado final

        // Expande a janela para a direita
        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // Adiciona o caractere ao mapa da janela
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            // Verifica se o caractere atual atende a uma necessidade do targetMap
            if (targetMap.containsKey(currentChar) &&
                    windowMap.get(currentChar).intValue() == targetMap.get(currentChar).intValue()) {
                counter++; // Incrementa o contador se a necessidade for atendida
            }

            // Contrai a janela pelo lado esquerdo quando todos os caracteres de t estão presentes
            while (counter == targetMap.size()) {
                // Calcula o tamanho da janela atual
                int currentWindow = right - left + 1;

                // Atualiza o menor comprimento da janela e o resultado
                if (currentWindow < minLength) {
                    minLength = currentWindow;
                    result = s.substring(left, right + 1);
                }

                // Remove o caractere mais à esquerda da janela
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // Verifica se a remoção quebra a condição de "janela válida"
                if (targetMap.containsKey(leftChar) &&
                        windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    counter--; // Decrementa o contador
                }

                left++; // Move o ponteiro esquerdo para frente
            }

            // Expande a janela para a direita
            right++;
        }

        return result; // Retorna a menor janela encontrada
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t)); // Output: "BANC"
    }
}
