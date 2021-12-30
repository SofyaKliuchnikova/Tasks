package task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        outer: while (true){
            System.out.println("Введите путь к файлу с массивом целых чисел");
            File file1 = new File(scanner.nextLine());  //C:\Users\son\IdeaProjects\Homework1\src\main\java\task4\example.txt
            ArrayList<String> numsStrArr = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file1))){
                String tempStr;
                int i = 0;
                while ((tempStr = bufferedReader.readLine()) != null){
                    numsStrArr.add(tempStr);
                    i++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int[] nums = new int[numsStrArr.size()];
            for (int i = 0; i < nums.length; i++){
                nums[i] = Integer.parseInt(numsStrArr.get(i));
            }
            System.out.println(NumberOfMoves(nums));
        }
    }

    private static int NumberOfMoves(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
        }
        int mean = sum/nums.length;
        int modulo = sum%nums.length;
        if (modulo >= (nums.length/2)) mean++;
        int number = 0;
        for (int i = 0; i < nums.length; i++){
            while (nums[i] != mean){
                if (nums[i] < mean){
                    nums[i]++;
                    number++;
                }
                if (nums[i] > mean){
                    nums[i]--;
                    number++;
                }
            }
        }
        return number;
    }
}
