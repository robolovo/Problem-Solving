package wooah;

public class P02 {
    public static int decodeTime(String start, String end) {
        String[] ss= start.split(":");
        String[] se = end.split(":");

        int sh = Integer.parseInt(ss[0]);
        int sm = Integer.parseInt(ss[1]);

        int eh = Integer.parseInt(se[0]);
        int em = Integer.parseInt(se[1]);

        int time = ((eh * 60) + em) - ((sh * 60) + sm);

        if (time < 5) {
            time = 0;
        }
        if (time > 105) {
            time = 105;
        }

        return time;
    }

    private static String encodeTime(int totalTime) {
        int hour = totalTime / 60;
        int minute = totalTime % 60;

        StringBuilder sb = new StringBuilder();
        if (hour < 10) {
            sb.append('0');
        }
        sb.append(hour);

        sb.append(':');

        if (minute < 10) {
            sb.append('0');
        }
        sb.append(minute);

        return sb.toString();
    }

    public static String solution(String[] log) {
        String start = "";
        int totalTime = 0;
        for (int i = 0; i < log.length; i++) {
            if (i % 2 != 0) {
                totalTime += decodeTime(start, log[i]);
            } else {
                start = log[i];
            }
        }
        return encodeTime(totalTime);
    }

    public static void main(String[] args) {
        String solution1 = solution(new String[]{"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"});
        System.out.println("solution1 = " + solution1);
    }
}
