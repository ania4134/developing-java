package developing.tasks.string.challenge;

//Have the function StringChallenge(str) take the str parameter being passed which will be two times
//        (each properly formatted with a colon and am or pm) separated by a hyphen and return the total
//        number of minutes between the two times. The time will be in a 12 hours clock format.
//        For example: if str is 9:00am-10:00am then the output should be 60. If str is 1:00pm-11:00am then
//        the output should be 1320.


public class StringTimeChallenge {

    public static int StringChallenge(String str) {

        String[] times = str.split("-");
        int minutes =0;

        String time1 = times[0].substring(0, times[0].length() -2);
        String time2 = times[1].substring(0, times[1].length() -2);


        String hour1 = times[0].substring(0, times[0].indexOf(":"));
        String hour2 = times[1].substring(0, times[1].indexOf(":"));
        String minutes1 = times[0].substring(times[0].indexOf(":") + 1, times[0].length() - 2);
        String minutes2 = times[1].substring(times[1].indexOf(":") + 1, times[1].length() - 2);
        int totalTime1 = Integer.parseInt(hour1) * 60 + Integer.parseInt(minutes1);
        int totalTime2 = Integer.parseInt(hour2) * 60 + Integer.parseInt(minutes2);

        if(time1.equals(time2))
            return 1440;

        minutes += totalTime2 - totalTime1;

        if(minutes < 0 ) {
            if(times[0].charAt(times[0].length() - 2) != times[1].charAt(times[1].length() - 2)) {
                return 720 + minutes;
            } else
                return 1440 + minutes;
        }

        return minutes;
    }

    public static void main (String[] args) {
        System.out.println(StringChallenge("9:30am-10:31am"));
        System.out.println(StringChallenge("11:00am-1:00am"));
        System.out.println(StringChallenge("11:00pm-1:00am"));
        System.out.println(StringChallenge("1:00pm-11:00am"));
        System.out.println(StringChallenge("1:23am-1:08am"));
    }
}
