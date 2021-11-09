package problem;

import java.util.ArrayList;
import java.util.List;

/*
*    프로그래머스 - 모음사전
*    https://programmers.co.kr/learn/courses/30/lessons/84512
*/

public class VowelDictionary {
    static List<String> dict = new ArrayList<>();

    public static int solution(String word) {
        String vowel = "AEIOU";
        dfs(vowel, "", 0);
        return dict.indexOf(word);
    }

    private static void dfs(String vowel, String word, int len) {
        if (len > 5) return;
        dict.add(word);
        for (int i = 0; i < vowel.length(); i++) {
            dfs(vowel, word + vowel.charAt(i), len + 1);
        }
    }

    public static void main(String[] args) {
        int wordIndex = solution("UUUUU");
        System.out.println("wordIndex = " + wordIndex);
    }
}
