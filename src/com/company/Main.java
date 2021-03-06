package com.company;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int nmoment = 0;
    private static int nperiod = 0;
    public static void generateTimeMoments(int[] attribute, int[] moments, int[] period){
        Random random = new Random();

        for (int k : attribute) {
            int max=0;
            int min=0;
            int moment=0;
            int summ=0;
            for (int i = 0; i < k; i++) {
                min += summ;
                max = period[nperiod] + summ;
                moment = moments[nmoment] - 1;
                for (int j = 0; j < moments[nmoment]; j++) {
                    min = random.nextInt(max - min - moment) + min + 1;
                    moment--;
                    System.out.println(min);
                }
                summ += period[nperiod];
                nperiod++;
                nmoment++;
                min = 0;
            }
        }
    }

    public static void generateVolumes(String[][][] volume, int[] illness, int[] moments){
        Random random = new Random();
        nmoment = 0;
        for(int i=0; i<illness.length;i++){

            for(int j=0; j<illness[i];j++){
                for(int k=0; k<moments[nmoment]; k++)
                System.out.println(volume[i][j][random.nextInt(volume[i][j].length)]);
                nmoment++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        int[] rm={5, 2, 3, 2, 4, 1};//Число ПД для первой болезни
        int[] sm={5, 5, 3, 2, 3, 4};//Число ПД для второй(для удобства)
        String[][][] rm_v={
                {{"Очень пололжительная", "Крайне негативная", "Рациональная"},
                        {"Пололжительная", "Отрицательная", "Эмоциональная"},
                        {"Нормальная", "Крайне негативная", "Очень положительная"},
                        {"Пололжительная", "Отрицательная", "Крайне негативная", "Рациональная"},
                        {"Очень пололжительная", "Нормальная", "Эмоциональная"}},
                {{"нет"},
                        {"да"}},
                {{"50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75"},
                        {"80","81","82","83"},
                        {"85","86","87","88","89","90"}},
                {{"1","2","3","4"},
                        {"5","6","7"}},
                {{"Скудоумная", "Весёлая", "Заурядная"},
                        {"Адекватная", "Печальная", "Невменяемая"},
                        {"Скудоумная", "Весёлая", "Заурядная", "Странная"},
                        {"Адекватная", "Печальная", "Непонятная", "Невменяемая"}},
                {{"отсутствует"}}};//Значения в периоды первой болезни

        String[][][] sm_v={
                {{"Пололжительная", "Отрицательная", "Эмоциональная"},
                        {"Очень пололжительная", "Нормальная", "Рациональная"},
                        {"Пололжительная", "Крайне негативная", "Эмоциональная"},
                        {"Очень пололжительная", "Отрицательная", "Рациональная"},
                        {"Положительная", "Нормальная", "Крайне негативная", "Эмоциональная"}},
                {{"да"},
                        {"нет"},
                        {"да"},
                        {"нет"},
                        {"да"}},
                {{"25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40"},
                        {"75","76","77","78","79","80"},
                        {"90","91","92","93","94","95","96","97","98","99"}},
                {{"1","2","3","4","5"},
                        {"8","9","10"}},
                {{"Скудоумная", "Печальная", "Странная", "Заурядная"},
                        {"Адекватная", "Весёлая", "Непонтная"},
                        {"Скудоумная", "Печальная", "Невменяемая", "Заурядная"}},
                {{"есть"},
                        {"отсутствует"},
                        {"есть"},
                        {"отсутствует"}}};//Значения в периоды второй болезни(для удобства)
        Scanner in = new Scanner(System.in);


        System.out.print("Число МН/ПД: ");
        int num = in.nextInt();
        int[] moments=new int[num];//Задаём МН для всей ИБ
        int[] period=new int[num];//Задаём длины ПД для все ИБ
        System.out.println("МН: ");
        for(int i=0; i<num;i++)
            moments[i]=in.nextInt();
        System.out.println("ПД: ");
        for(int i=0; i<num;i++)
            period[i]=in.nextInt();
        generateTimeMoments(sm,moments,period);//Генерируем МН для ИБ
        generateVolumes(sm_v, sm,moments);//Генерируем значения МН для ИБ
    }
}
