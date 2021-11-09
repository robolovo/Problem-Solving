package problem;

import java.util.Arrays;

public class Supoza {
    public int[] solution(int[] answers) {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (s1[i % s1.length] == answers[i]) {
                a1++;
            }
            if (s2[i % s2.length] == answers[i]) {
                a2++;
            }
            if (s3[i % s3.length] == answers[i]) {
                a3++;
            }
        }

        int[] answer;
        if (a1 < a2) {
            answer = new int[]{2};
            if (a2 < a3) {
                answer = new int[]{3};
            } else if (a2 == a3) {
                answer = new int[]{2, 3};
            }
        } else if (a1 == a2) {
            answer = new int[]{1, 2};
            if (a2 < a3) {
                answer = new int[]{3};
            } else if (a2 == a3) {
                answer = new int[]{1, 2, 3};
            }
        } else {
            answer = new int[]{1};
            if (a1 < a3) {
                answer = new int[]{3};
            } else if (a1 == a3) {
                answer = new int[]{1, 3};
            }
        }

        return answer;
    }

}
