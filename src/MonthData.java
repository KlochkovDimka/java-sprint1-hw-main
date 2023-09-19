public class MonthData {
    int[] day = new int[30];

    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < day.length; i++) {
            System.out.println(i + 1 + " день: " + day[i]);
        }
    }

    int sumStepsFromMonth(){
        int sumSteps = 0;
        for (int i = 0; i < day.length; i++) {
            sumSteps += day[i];
        }
        return sumSteps;
    }

    int maxSteps(){
        int maxSteps = 0;
        for (int i = 0; i < day.length; i++) {
            maxSteps = Math.max(maxSteps, day[i]);
        }
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay){
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < day.length; i++) {
            if (goalByStepsPerDay <= day[i]){
                currentSeries ++;
                finalSeries = Math.max(currentSeries, finalSeries);
            }else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }

    int averageStepsPerMonth(){
        return sumStepsFromMonth() / 30;
    }
}
