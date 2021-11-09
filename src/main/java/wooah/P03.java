package wooah;

import java.util.*;

public class P03 {
    public static int getIngredientCost(Map<String, Integer> ingsMap, String ings) {
        int ingsCost = 0;

        for (int i = 0; i < ings.length(); i++) {
            String s = String.valueOf(ings.charAt(i));
            ingsCost += ingsMap.get(s);
        }

        return ingsCost;
    }

    public static int solution(String[] ings, String[] menu, String[] sell) {
        Map<String, Integer> ingsMap = new HashMap<>();
        for (String ing : ings) {
            String[] si = ing.split(" ");
            ingsMap.put(si[0], Integer.valueOf(si[1]));
        }

        Map<String, Integer> menuMap = new HashMap<>();
        for (String m : menu) {
            String[] sm = m.split(" ");
            menuMap.put(sm[0], Integer.parseInt(sm[2]) - getIngredientCost(ingsMap, sm[1]));
        }

        int totalIncome = 0;
        for (String s : sell) {
            String[] ss = s.split(" ");
            totalIncome += (menuMap.get(ss[0]) * Integer.parseInt(ss[1]));
        }

        return totalIncome;
    }

    public static void main(String[] args) {
        int solution = solution(new String[]{"r 10", "a 23", "t 124", "k 9"},
                new String[]{"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30",
                        "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"},
                new String[]{"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"});

        System.out.println("solution = " + solution);
    }
}
