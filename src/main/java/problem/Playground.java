package problem;

import java.util.ArrayList;
import java.util.List;

public class Playground {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();

        list.add(new int[]{1, 0});
        list.add(new int[]{2, 0});
        list.add(new int[]{3, 0});
        list.add(new int[]{4, 0});
        list.add(new int[]{5, 0});

        List<int[]> newList = new ArrayList<>(list);

        newList.remove(0);

        for (int[] l : list) {
            System.out.println(l[0] + " " + l[1]);
        }

        System.out.println("-----------------");

        for (int[] l : newList) {
            System.out.println(l[0] + " " + l[1]);
        }
    }
}
