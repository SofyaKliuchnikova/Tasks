package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        outer: while (true){
            System.out.println("Введите путь к файлу с координатами центра и радиусом окружности");
            File file1 = new File(scanner.nextLine());  //C:\Users\son\IdeaProjects\Homework1\src\main\java\task2\example1.txt
            float center = 0;
            float radius = 0;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))){
                center = Float.parseFloat(bufferedReader.readLine());
                radius = Float.parseFloat(bufferedReader.readLine());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Введите путь к файлу с координатами точек");
            File file2 = new File(scanner.nextLine());  //C:\Users\son\IdeaProjects\Homework1\src\main\java\task2\example2.txt
            ArrayList<String> dotsStrArr = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file2))){
                String tempStr;
                int i = 0;
                while ((tempStr = bufferedReader.readLine()) != null){
                    dotsStrArr.add(tempStr);
                    i++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            float dot;
            for (int i = 0; i < dotsStrArr.size(); i++){
                dot = Float.parseFloat(dotsStrArr.get(i));
                System.out.println(WhereDot(center,radius,dot));
            }
        }
    }

    private static int WhereDot(float center, float radius, float dot) {
        float crossing1 = center - radius;
        float crossing2 = center + radius;
        if (dot == crossing1 || dot == crossing2) return 0;
        if (dot > crossing1 & dot < crossing2) return 1;
        else return 2;
    }
}
