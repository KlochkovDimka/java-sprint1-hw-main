public class Converter {


    int convertToKm(int steps){
        int kilometer = (steps * 75) / 100000;
        return kilometer;
    }

    int convertStepsToKilocalories(int steps){
        int kilocalories = (steps * 50) / 1000;
        return kilocalories;
    }


}
