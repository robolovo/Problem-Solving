package wooah;

public class P06 {

    public static String solution(double time, String[][] plans) {
        String lastTrip = "";

        for (String[] plan : plans) {
            String departure = plan[1];
            String arrive = plan[2];

            int dTime = Integer.parseInt(departure.substring(0, departure.length() - 2));
            if (departure.endsWith("PM")) {
                dTime += 12;
            }

            if (dTime < 18) {
                time -= (18 - dTime);
            }

            int aTime = Integer.parseInt(arrive.substring(0, arrive.length() - 2));
            if (arrive.endsWith("PM")) {
                aTime += 12;
            }

            if (aTime > 13) {
                time -= (aTime - 13);
            }

            if (time < 0) {
                break;
            }

            lastTrip = plan[0];
        }

        return lastTrip;
    }

    public static void main(String[] args) {
        String solution = solution(3.5, new String[][]{{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}});
        System.out.println("solution = " + solution);
    }
}
