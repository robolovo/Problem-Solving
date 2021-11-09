package problem;

/*
*   프로그래머스 - n^2 배열 자르기
*   https://programmers.co.kr/learn/courses/30/lessons/87390
*/

public class CuttingNArray {
    public int[] solution(int n, long left, long right) {
        long length = right - left;
        int[] answer = new int[(int)length + 1];

        long N = (long) n;
        int i = 0;
        while (left <= right) {
            long lx = left / N;
            long ly = left % N;

            long v;
            if (lx < ly) {
                v = ly + 1;
            } else {
                v = lx + 1;
            }
            answer[i] = (int) v;

            left++;
            i++;
        }

        return answer;
    }
}
