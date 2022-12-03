
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HW_02_new {

    public static void main(String[] args) {

        // Распарсить файл с логами из заданий, выполненных на семинаре, найти записи уровня INFO/DEBUG.
        // Файл при первом запуске выдаст ошибку, которая запишеться в файл, и больше ошибки не будет
        FirstTast firstTast = new FirstTast();
        System.out.println(firstTast.logData());

        Bubblesort bubblesort = new Bubblesort();
        bubblesort.printArr();
        bubblesort.bubbleSort();
    }

}
class MyLogger {
    // Создаем логгер из встроенного класса util
    // И записываем некоторые данные в txt файал, что бы потом было что читать и парсить.
    private static final Logger log = Logger.getLogger("MyLogger");

    static {
        FileHandler fh;

        try {
            fh = new FileHandler("file.txt", true);
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        }catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public static void writeLog (String messeg){
        log.log(Level.INFO, "msgSupplier");
    }

    public static void writeLog (String messeg, Exception e){
        log.log(Level.WARNING, "msgSupplier", e);
    }
}
class FirstTast {
    // Распарсить файл с логами из заданий, выполненных на семинаре, найти записи уровня INFO/DEBUG.
    ArrayList logData(){
        ArrayList<String> logDataArr = new ArrayList<>();
        try {
            File file = new File("file.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                logDataArr.add((line));
            }
        } catch (FileNotFoundException e) {
            MyLogger.writeLog(" ", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            MyLogger.writeLog(" ", e);
            throw new RuntimeException(e);
        }

        return logDataArr;
    }

}

class Bubblesort {
//    Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл
    private int[] arr = new int[100];

    public Bubblesort () {
        for (int index = 0; index < arr.length; index++) {
            arr[index] = new Random().nextInt(1, 200);
        }
    }
    public Bubblesort (int[] arr) {
        this.arr = arr;
    }

    public void bubbleSort(){
//  Добавит запись каждой итерации      MyLogger.writeLog("test");
        int countStar = 0;
        int countEnd = 0;
        int countIter = 0;
        int temp = 0;
        boolean flag = true;
        do {
            for (int i = 0; i < arr.length-1; i++){
                if (arr[i] > arr[i+1]) {
                    temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                    countEnd++;
                }
            }
            printArr();
            ++countIter;
            if (countStar == countEnd) {
                flag = false;
            }
            else {
                countEnd = 0;
            }
        }while (flag);
        System.out.printf("Отсоратированно за %d проходов \n", countIter);
        System.out.println(temp);
    }

    public void printArr () {
        System.out.println(Arrays.toString(arr));
    }

    public int[] getArr() {
        return arr;
    }
}