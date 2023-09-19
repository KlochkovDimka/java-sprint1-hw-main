
import java.util.Scanner;

public class StepTracker {

    private Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    MonthData monthData;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (!(month > 0 && month < 13)) {
            System.out.println("В году 12 месяцев. \n " +
                    "Введен не корректный номер");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (!(day > 0 && day < 31)) {
            System.out.println("Введите корректный номер");
            return;
        }
        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        if (step <= 0) {
            System.out.println("Введите положительное число");
            return;
        }

        MonthData monthData = monthToData[month - 1];
        monthData.day[day - 1] = step;
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель по шагам");
        int goalByStep = scanner.nextInt();
        if (goalByStep <= 0) {
            System.out.println("Колличество шагов должно быть больше нуля!");
            changeStepGoal();
        }
        goalByStepsPerDay = goalByStep;
        System.out.println("Цель успешно изменене!");
    }
    void printStatistic(){
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (!(month > 0 && month < 13)){
            System.out.println("Введите корректное число");
            printStatistic();
        }
        monthData = monthToData[month-1];
        int sumSteps = monthData.sumStepsFromMonth();
        System.out.println("Общая статистика по дням");
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов за месяц: " + monthData.maxSteps());
        System.out.println("Среднее пройденное количество шагов за месяц:" + monthData.averageStepsPerMonth());
        System.out.println("Пройденная за месяц дистанция в км: " + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий за месяц: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();

    }




}
